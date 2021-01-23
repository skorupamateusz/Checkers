package server.Session;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import client.Login.ConnectDB;
import server.Constants.CheckersConstants;
import server.Model.*;

public class SessionHandler implements Runnable {

    private Game CheckersConstants;
    private Player player1;
    private Player player2;

    private boolean continueToPlay = true;

    //Construct thread
    public SessionHandler(Socket p1, Socket p2){
        player1 = new Player(server.Constants.CheckersConstants.PLAYER_ONE.getValue(), p1);
        player2 = new Player(server.Constants.CheckersConstants.PLAYER_TWO.getValue(), p2);

        CheckersConstants = new Game();
    }

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
        //Send Data back and forth
        try{
            //notify Player 1 to start
            player1.sendData(1);

            String pName = player1.receiveDataString();
            String pName2 = player2.receiveDataString();

            while(continueToPlay){
                //wait for player 1's Action
                int from = player1.receiveData();
                int to = player1.receiveData();
                checkStatus(from, to);
                updateGameModel(from, to);

                //Send Data back to 2nd Player
                if(CheckersConstants.isOver())
                    player2.sendData(server.Constants.CheckersConstants.YOU_LOSE.getValue());	//Game Over notification
                int fromStatus = player2.sendData(from);
                int toStatus = player2.sendData(to);
                checkStatus(fromStatus,toStatus);

                //IF game is over, break
                if(CheckersConstants.isOver()){
                    player1.sendData(server.Constants.CheckersConstants.YOU_WIN.getValue());
                    continueToPlay=false;
                    break;
                }

                System.out.println("Player 1 has moved.");

                //wait for player 2's Action
                from = player2.receiveData();
                to = player2.receiveData();
                checkStatus(from, to);
                updateGameModel(from, to);
                //todo tu jest zakończenie gry dla obu graczy
                //Send Data back to 1st Player

                if(CheckersConstants.isOver()){
                    player1.sendData(server.Constants.CheckersConstants.YOU_LOSE.getValue());		//Game Over notification
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
                    //player2.sendData(server.Constants.CheckersConstants.YOU_WIN.getValue());
                    newResult(pName2);
                    System.out.println("Winner: " + pName2 + ".");

                }
            }
            catch(Game.myException e)
            {
                //player1.sendData(server.Constants.CheckersConstants.YOU_LOSE.getValue());		//Game Over notification
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