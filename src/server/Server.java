package server;

import javax.swing.*;

public class Server {

    public static void main(String[] args) {

        ServerApp server = new ServerApp();
        server.setSize(400,250);
        server.setVisible(true);
        server.setTitle("Checkers Server");
        server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //start Connection
        server.startRunning();
    }
}
