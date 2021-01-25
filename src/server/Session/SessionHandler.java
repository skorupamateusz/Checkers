package server.Session;

import client.Login.ConnectDB;
import server.Model.Board;
import server.Model.Game;
import server.Model.Player;

import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SessionHandler implements Runnable {

    private Game CheckersConstants;
    private Player player1;
    private Player player2;

    private boolean continueToPlay = true;

    public SessionHandler(Socket p1, Socket p2){
        player1 = new Player(server.Constants.CheckersConstants.PLAYER_ONE.getValue(), p1);
        player2 = new Player(server.Constants.CheckersConstants.PLAYER_TWO.getValue(), p2);

        CheckersConstants = new Game();
    }
    /**
     * Update score after the game has ended.
     * @param username
     */
    public void newResult(String username){
        try{
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT * FROM USERS WHERE USERNAME =?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery() ;
            rs.next();
            int result = rs.getInt(4);
            result++;
            PreparedStatement stm = ConnectDB.getConnection().prepareStatement("UPDATE USERS SET points = ? where username = ?");
            stm.setInt(1, result);
            stm.setString(2, username);
            stm.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public void run() {
        try{
            player1.sendData(1);

            String pName = player1.receiveDataString();
            String pName2 = player2.receiveDataString();

            while(continueToPlay){
                //Wait for Player 1 action
                int from = player1.receiveData();
                int to = player1.receiveData();
                checkStatus(from, to);
                updateGameModel(from, to);

                //Send data back to Player 2
                if(CheckersConstants.isOver())
                    player2.sendData(server.Constants.CheckersConstants.YOU_LOSE.getValue());
                int fromStatus = player2.sendData(from);
                int toStatus = player2.sendData(to);
                checkStatus(fromStatus,toStatus);

                //Break if game is over
                if(CheckersConstants.isOver()){
                    player1.sendData(server.Constants.CheckersConstants.YOU_WIN.getValue());
                    continueToPlay=false;
                    break;
                }

                System.out.println("Player 1 has moved.");

                //Wait for Player 2 action
                from = player2.receiveData();
                to = player2.receiveData();
                checkStatus(from, to);
                updateGameModel(from, to);
                //Send data back to Player 1

                if(CheckersConstants.isOver()){
                    player1.sendData(server.Constants.CheckersConstants.YOU_LOSE.getValue());
                }

                fromStatus = player1.sendData(from);
                toStatus = player1.sendData(to);
                checkStatus(fromStatus,toStatus);


                //IF game is over, break

                if(CheckersConstants.isOver()){
                    player2.sendData(server.Constants.CheckersConstants.YOU_WIN.getValue());
                    continueToPlay=false;
                    break;
                }
                System.out.println("Player 2 has moved.");
            }

            try {
                if (CheckersConstants.isOverPlayer()) {
                    newResult(pName2);
                    System.out.println("Winner: " + pName2 + ".");

                }
            }
            catch(Game.myException e)
            {
                newResult(pName);
                System.out.println("Winner: " + pName + ".");
            }

        }catch(Exception ex){
            System.out.println("Connection is being closed");

            if(player1.isOnline())
                player1.closeConnection();

            if(player2.isOnline())
                player2.closeConnection();

            return;
        }
    }

    private void checkStatus(int status, int status2) throws Exception{
        if(status==99 || status2==99){
            throw new Exception("Connection is lost");
        }
    }

    private void updateGameModel(int from, int to){
        Board fromSquare = CheckersConstants.getSquare(from);
        Board toSquare = CheckersConstants.getSquare(to);
        toSquare.setPlayerID(fromSquare.getPlayerID());
        fromSquare.setPlayerID(server.Constants.CheckersConstants.EMPTY_SQUARE.getValue());

        checkCrossJump(fromSquare, toSquare);
    }

    private void checkCrossJump(Board from, Board to){
        if(Math.abs(from.getSquareRow()-to.getSquareRow())==2){
            int middleRow = (from.getSquareRow() + to.getSquareRow())/2;
            int middleCol = (from.getSquareCol() + to.getSquareCol())/2;

            Board middleSquare = CheckersConstants.getSquare((middleRow*8)+middleCol+1);
            middleSquare.setPlayerID(server.Constants.CheckersConstants.EMPTY_SQUARE.getValue());
        }
    }
}