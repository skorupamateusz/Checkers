package UserServices;


import javax.swing.*;
import java.awt.*;

public class RegisterField extends JFrame {

    private JScrollPane scroll;
    private JTextArea information;
    private JLabel title;

    public RegisterField(){
        super("Logowanie");
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        title = new JLabel("Server");
        information = new JTextArea();
        scroll = new JScrollPane(information);

        add(title,BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        setResizable(false);

    }

    public static void main(String[] args) {
        RegisterField rf = new RegisterField();
    }
}
