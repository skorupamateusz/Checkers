package client.Constants;

public enum SessionVariable{

    myID(3);
    //public static Mouse mouseListener = new Mouse();

    private int value;

    SessionVariable(int value){
        this.setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
