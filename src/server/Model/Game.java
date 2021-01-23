package server.Model;

import server.Constants.CheckersConstants;

public class Game {
    private Board[][] board;

    //Constructor
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

    //Initialize 64 board with ID, Row, Col & isFilled
    private void initializeSquares() {
        boolean rowInitialFilled, isFilled;
        int count = 0;

        //Rows
        for(int r=0;r<CheckersConstants.NUM_ROWS.getValue();r++){
            rowInitialFilled = (r%2 == 1) ? true : false;

            //Columns
            for(int c=0;c<CheckersConstants.NUM_COLS.getValue();c++){
                isFilled = (rowInitialFilled && c%2 == 0) ? true : (!rowInitialFilled && c%2 == 1) ? true : false;
                count++;

                board[r][c] = new Board(count, r, c, isFilled);
            }
        }
    }

    private void assignPlayerIDs() {

        //Rows 0-2 for player ONE
        for(int r=0;r<3;r++){
            //Columns
            for(int c=0;c<CheckersConstants.NUM_COLS.getValue();c++){
                if(board[r][c].getIsFilled()){
                    board[r][c].setPlayerID(CheckersConstants.PLAYER_ONE.getValue());
                }
            }
        }

        //Rows 5-7 for player TWO
        for(int r=5;r<8;r++){
            //Columns
            for(int c=0;c<CheckersConstants.NUM_COLS.getValue();c++){
                if(board[r][c].getIsFilled()){
                    board[r][c].setPlayerID(CheckersConstants.PLAYER_TWO.getValue());
                }
            }
        }
    }

    public Board[][] getSquares(){
        return this.board;
    }

    public int getTotlaSquares(){
        return board.length;
    }

    public void printSquareDetails(){
        for(int r=0;r<CheckersConstants.NUM_ROWS.getValue();r++){
            for(int c=0;c<CheckersConstants.NUM_COLS.getValue();c++){
                System.out.println(board[r][c].getSquareID() + "--" + board[r][c].getSquareRow() + "--" + board[r][c].getSquareCol()
                        + board[r][c].getPlayerID());
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

    public void printAvailableSquareDetails(){

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

        System.out.println("Player 1 has " + playerOne);
        System.out.println("Player 2 has " + playerTwo);
    }

    public boolean isOver() throws myException {

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

        if (playerOne == 0) {

            return true;
        }
        if(playerTwo == 0)
        {
            throw new myException();
        }
        /*
        if(playerOne==0 || playerTwo==0){
            return true;
        }
         */

        return false;
    }
}
