package UserServices;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.SQLException;

public class Signup extends JFrame {

    private final TextField usernametf;
    private final JPasswordField password1;
    private final JPasswordField password2;
    private final JLabel login;
    private final JLabel password1Lab;
    private final JLabel password2Lab;
    private final JButton registerB;
    private final URL iconurl;
    private final Image iconimage;
    private final DBManager db;

    public Signup() throws Exception{

        db = new DBManager();
        login = new JLabel();
        usernametf = new TextField();
        password2 = new JPasswordField();
        password1 = new JPasswordField();
        password2Lab = new JLabel();
        password1Lab = new JLabel();
        registerB = new JButton();
        iconurl = new URL("https://static.thenounproject.com/png/3264269-200.png");
        iconimage = ImageIO.read(iconurl);
        setIconImage(iconimage);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        setTitle("Rejestracja");
        setVisible(true);
        setSize(400, 200);
        setResizable(false);
        login.setText("Podaj nazwę użytkownka");
        login.setVisible(true);
        password1Lab.setText("Podaj hasło");
        password2Lab.setText("Potwierdź hasło");

        registerB.setText("Rejestruj");
        final JInternalFrame frame = new JInternalFrame();
        registerB.addActionListener(eloevent ->{
            if(usernametf.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Brak nazwy użytkownika", "Puste pole", JOptionPane.ERROR_MESSAGE);
            }
            else  if (password1.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Brak hasła", "Puste pole", JOptionPane.ERROR_MESSAGE);
            }
            else  if(password2.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Brak drugiego hasła", "Puste pole", JOptionPane.ERROR_MESSAGE);
            }
            else if(password1.getText().equals(password2.getText())){
                //todo dadać tutaj zapis do bazy danych ze sprawdzaniem loginu
                try {
                    if(db.checkUsername(usernametf.getText())){
                        JOptionPane.showMessageDialog(frame, "Nazwa użytkownika już zajęta", "Spróbuj ponownie", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        db.addUser(usernametf.getText(), password1.getText());
                        JOptionPane.showMessageDialog(frame, "Rejestracja się powiodła", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                JOptionPane.showMessageDialog(frame, "Hasła się nie zgadzają","Błąd haseł",JOptionPane.ERROR_MESSAGE );
            }
        });
        add(Box.createHorizontalGlue());
        add(login);add(usernametf); add(password1Lab);add(password1);add(password2Lab);add( password2);add(registerB);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new  Signup();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
