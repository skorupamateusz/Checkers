package client;

import client.Handler.Controller;
import client.Handler.Mouse;
import client.Login.Login;
import client.Model.Player;
import client.View.BoardPanel;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp extends JFrame {

    private static final long serialVersionUID = 1L;

    private String address;
    private int port;
    private Player player;
    private BoardPanel boardPanel;
    private Socket connection;
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    public ClientApp() {
        try {
            PropertyManager pm = PropertyManager.getInstance();
            address = pm.getAddress();
            port = pm.getPort();
            player = new Player(Login.username);
            connect();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid IPv4-Address", "Error", JOptionPane.ERROR_MESSAGE,
                    null);
            System.exit(0);
        }
    }

    private void connect() {
        try {
            connection = new Socket(address, port);

            fromServer = new DataInputStream(connection.getInputStream());
            toServer = new DataOutputStream(connection.getOutputStream());
            player.setPlayerID(fromServer.readInt());

            Controller task = new Controller(player, fromServer, toServer);
            setup(task);

            new Thread(task).start();
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Internal Server Error - Check your IPv4-Address", "Error occurred",
                    JOptionPane.ERROR_MESSAGE, null);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Couldn't connect to Server. Please try again", "Error occurred",
                    JOptionPane.ERROR_MESSAGE, null);
            System.exit(0);
        }
    }

    private void setup(Controller c) {
        Mouse listener = new Mouse();
        listener.setController(c);

        boardPanel = new BoardPanel(listener);
        c.setBoardPanel(boardPanel);
        add(boardPanel);
    }
}