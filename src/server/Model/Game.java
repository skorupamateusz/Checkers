package server.Model;

import server.Constants.CheckersConstants;

public class Game {
    private Board[][] board;

    public Game(){
        board = new Board[8][8];

        initializeSquares();
        assignPlayerIDs();
    }
    public static class myException extends Exception {
        public myException() {
            super();
        }
    }

    /**
     * Initialize game settings
     */
    private void initializeSquares() {
        boolean rowInitialFilled, isFilled;
        int count = 0;

        for(int r=0;r<CheckersConstants.NUM_ROWS.getValue();r++){
            rowInitialFilled = (r%2 == 1) ? true : false;

            for(int c=0;c<CheckersConstants.NUM_COLS.getValue();c++){
                isFilled = (rowInitialFilled && c%2 == 0) ? true : (!rowInitialFilled && c%2 == 1) ? true : false;
                count++;

                board[r][c] = new Board(count, r, c, isFilled);
            }
        }
    }

    private void assignPlayerIDs() {
        for(int r=0;r<3;r++){
            for(int c=0;c<CheckersConstants.NUM_COLS.getValue();c++){
                if(board[r][c].getIsFilled()){
                    board[r][c].setPlayerID(CheckersConstants.PLAYER_ONE.getValue());
                }
            }
        }
        for(int r=5;r<8;r++){
            for(int c=0;c<CheckersConstants.NUM_COLS.getValue();c++){
                if(board[r][c].getIsFilled()){
                    board[r][c].setPlayerID(CheckersConstants.PLAYER_TWO.getValue());
                }
            }
        }
    }

    public Board getSquare(int from) {
        for(Board[] sRows:board){
            for(Board s: sRows){
                if(s.getSquareID()==from){
                    return s;
                }

            }
        }
        return null;
    }

    public boolean isOver()  {

        int playerOne = 0;
        int playerTwo = 0;
        for(int r=0;r<CheckersConstants.NUM_ROWS.getValue();r++){
            for(int c=0;c<CheckersConstants.NUM_COLS.getValue();c++){
                if(board[r][c].getPlayerID()==1)
                    playerOne++;

                if(board[r][c].getPlayerID()==2)
                    playerTwo++;
            }
        }
        if(playerOne==0 || playerTwo==0){
            return true;
        }
        return false;
    }

    public boolean isOverPlayer()throws myException {
        int playerOne = 0;
        int playerTwo = 0;
        for(int r=0;r<CheckersConstants.NUM_ROWS.getValue();r++){
            for(int c=0;c<CheckersConstants.NUM_COLS.getValue();c++){
                if(board[r][c].getPlayerID()==1)
                    playerOne++;

                if(board[r][c].getPlayerID()==2)
                    playerTwo++;
            }
        }
        if(playerOne==0){
            return true;
        }
        if(playerTwo ==0){
            throw  new myException();
        }
        return  false;
    }
}