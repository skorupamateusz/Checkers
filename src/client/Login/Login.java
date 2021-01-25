package client.Login;

import client.ClientApp;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    public static String username;
    public static String password;

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonLog = new javax.swing.JButton();
        jButtonRank = new javax.swing.JButton();
        javax.swing.JLabel jCreateAcc = new javax.swing.JLabel();
        javax.swing.JPanel jPanel4 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(152, 152, 152));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldUsername.setForeground(new java.awt.Color(152, 152, 152));
        jTextFieldUsername.setText("username");
        jTextFieldUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldUsernameFocusLost(evt);
            }
        });

        jPasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordField.setForeground(new java.awt.Color(152, 152, 152));
        jPasswordField.setText("password");
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusLost(evt);
            }
        });

        jButtonRank.setBackground(new java.awt.Color(255, 0, 0));
        jButtonRank.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jButtonRank.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRank.setText("Ranking");
        jButtonRank.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRankMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRankMouseExited(evt);
            }
        });
        jButtonRank.addActionListener(this::jButtonRankActionPerformed);

        jButtonLog.setBackground(new java.awt.Color(255, 0, 0));
        jButtonLog.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jButtonLog.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLog.setText("Login");
        jButtonLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonLogMouseExited(evt);
            }
        });
        jButtonLog.addActionListener(this::jButtonLogActionPerformed);

        jCreateAcc.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jCreateAcc.setForeground(new java.awt.Color(255, 0, 0));
        jCreateAcc.setText("First time? Create account here!");
        jCreateAcc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCreateAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCreateAccMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButtonLog, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                                        .addComponent(jButtonRank, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                                        .addComponent(jPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldUsername)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(154, 154, 154)
                                                .addComponent(jCreateAcc)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonLog, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonRank, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCreateAcc)
                                .addContainerGap(14, Short.MAX_VALUE))
        );


        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 51, 0));
        jLabel3.setText("LOGIN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel3)
                                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(106, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)                                               ))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }


    private void jTextFieldUsernameFocusGained(java.awt.event.FocusEvent evt)
    {
        if(jTextFieldUsername.getText().trim().equalsIgnoreCase("username"))
        {
            jTextFieldUsername.setText("");
            jTextFieldUsername.setForeground(Color.black);
        }
    }

    private void jTextFieldUsernameFocusLost(java.awt.event.FocusEvent evt)
    {
        if(jTextFieldUsername.getText().trim().equals("") || jTextFieldUsername.getText().trim().equalsIgnoreCase("username"))
        {
            jTextFieldUsername.setText("username");
            jTextFieldUsername.setForeground(new Color(152,152,152));
        }
    }

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {

        String pass = String.valueOf(jPasswordField.getPassword());

        if(pass.trim().equalsIgnoreCase("password"))
        {
            jPasswordField.setText("");
            jPasswordField.setForeground(Color.black);
        }
    }

    private void jPasswordFieldFocusLost(java.awt.event.FocusEvent evt)
    {
        String pass = String.valueOf(jPasswordField.getPassword());

        if(pass.trim().equals("") || pass.trim().equalsIgnoreCase("password"))
        {
            jPasswordField.setText("password");
            jPasswordField.setForeground(new Color(152,152,152));
        }

    }

    private void jButtonLogMouseEntered(java.awt.event.MouseEvent evt) {
        jButtonLog.setBackground(new Color(255,51,51));

    }

    private void jButtonLogMouseExited(java.awt.event.MouseEvent evt)
    {
        jButtonLog.setBackground(new Color(255,0,0));
    }

    private void jButtonRankMouseEntered(java.awt.event.MouseEvent evt)
    {
        jButtonRank.setBackground(new Color(255,51,51));
    }

    private void jButtonRankMouseExited(java.awt.event.MouseEvent evt)
    {
        jButtonRank.setBackground(new Color(255,0,0));
    }

    private void jButtonRankActionPerformed(java.awt.event.ActionEvent evt)
    {
        try {
            Ranking ranking = new Ranking();
            ranking.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jButtonLogActionPerformed(java.awt.event.ActionEvent evt)
    {
        PreparedStatement st;
        ResultSet rs;

        username = jTextFieldUsername.getText();
        password = String.valueOf(jPasswordField.getPassword());

        String query = "SELECT * FROM `users` WHERE `username` = ? AND `password` = ?";

        try
        {
            st = ConnectDB.getConnection().prepareStatement(query);

            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();

            if(rs.next())
            {
                ClientApp client = new ClientApp();
                client.setTitle("Checkers - " + username + "");
                client.pack();
                client.setVisible(true);
                client.setLocation(250, 150);
                client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                this.dispose();

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid username / password", "Login unsuccessfull", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jCreateAccMouseClicked(java.awt.event.MouseEvent evt)
    {
        Register rf = new Register();
        rf.setVisible(true);
        rf.pack();
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }

    private javax.swing.JButton jButtonLog;
    private javax.swing.JButton jButtonRank;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUsername;
}