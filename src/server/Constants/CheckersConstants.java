package server.Constants;

public enum CheckersConstants {

    NUM_ROWS(8),
    NUM_COLS(8),
    EMPTY_SQUARE(0),
    PLAYER_ONE(1),
    PLAYER_TWO(2),
    YOU_WIN(90),
    YOU_LOSE(91);

    private int value;

    CheckersConstants(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}