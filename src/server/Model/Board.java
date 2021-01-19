package server.Model;

import server.Constants.CheckersConstants;

public class Board {

    private int SquareID;
    private int SquareRow;
    private int SquareCol;
    private boolean filled;
    private int playerID;


    //Constructor
    public Board(int SquareID, int SquareRow, int SquareCol, boolean isFilled){
        this.SquareID=SquareID;
        this.SquareRow=SquareRow;
        this.SquareCol=SquareCol;
        this.setFilled(isFilled);

        if(this.filled){
            this.playerID = CheckersConstants.EMPTY_SQUARE.getValue();
        }
    }

    public boolean getIsFilled() {
        return filled;
    }

    private void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void setPlayerID(int ID){
        this.playerID=ID;
    }

    public int getPlayerID(){
        return this.playerID;
    }

    public int getSquareID(){
        return this.SquareID;
    }

    public int getSquareRow(){
        return this.SquareRow;
    }

    public int getSquareCol(){
        return this.SquareCol;
    }

}