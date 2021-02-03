package server;

import java.awt.BorderLayout;
import javax.swing.*;
import server.Constants.CheckersConstants;
import server.Session.SessionHandler;
import java.io.*;
import java.net.*;
import java.util.Date;

public class ServerApp extends JFrame {

    private static final long serialVersionUID = 1L;

    //Frame components
    private JScrollPane scroll;
    private JTextArea information;
    private JLabel title;

    //Network properties
    private ServerSocket serverSocket;
    int sessionNo;

    public ServerApp(){
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        title = new JLabel("Server");
        information = new JTextArea();
        scroll = new JScrollPane(information);

        add(title,BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    //Establish connection and wait for players
    public void startRunning(){

        try{
            PropertyManager pm = PropertyManager.getInstance();
            int port = pm.getPort();

            serverSocket = new ServerSocket(port);
            information.append(new Date() + "  -  Checkers Server started. \n\n");
            sessionNo = 1;

            while(true){

                information.append(new Date()+ "  -  Session "+ sessionNo + " is started.\n");

                //Wait for Player 1
                Socket player1 = serverSocket.accept();
                information.append(new Date() + "  -  Player1 joined the Server. \n");

                new DataOutputStream(player1.getOutputStream()).writeInt(CheckersConstants.PLAYER_ONE.getValue());

                //Wait for player 2
                Socket player2 = serverSocket.accept();
                information.append(new Date() + "  -  Player2 joined the Server. \n");

                new DataOutputStream(player2.getOutputStream()).writeInt(CheckersConstants.PLAYER_TWO.getValue());

                //Increase session
                sessionNo++;

                SessionHandler task = new SessionHandler(player1, player2);
                new Thread(task).start();
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.exit(0);
        }
    }
}