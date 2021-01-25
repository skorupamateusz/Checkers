package server.Model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Player{
    private int PlayerID;
    private Socket socket;
    private DataInputStream fromPlayer;
    private DataOutputStream toPlayer;

    public Player(int ID, Socket s){
        this.PlayerID = ID;
        this.socket = s;

        try{
            fromPlayer = new DataInputStream(socket.getInputStream());
            toPlayer = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int sendData(int data){
        try {
            this.toPlayer.writeInt(data);
            return 1;
        } catch (IOException e) {
            System.out.println("sending: Player not found");
            e.printStackTrace();
            return 99;
        }
    }

    public int receiveData(){
        int data = 0;;
        try{
            data = this.fromPlayer.readInt();
            return data;
        }catch (IOException e) {
            System.out.println("Waiting: No respond from Player");
            return 99;
        }
    }

    public String receiveDataString() {
        String data = null;
        try {
            data = this.fromPlayer.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    return data;
    }

    public void closeConnection(){
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isOnline(){
        return socket.isConnected();
    }
}
