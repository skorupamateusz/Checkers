/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.Login;

import client.ClientApp;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Maciej
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public static String username;
    public static String password;

    public Login() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        Border labelBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black);
        
        jminimalize.setBorder(labelBorder);
        
        jexit.setBorder(labelBorder);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonLog = new javax.swing.JButton();
        jCreateAcc = new javax.swing.JLabel();
        jexit = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jminimalize = new javax.swing.JLabel();

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
        jButtonLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCreateAcc)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jexit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jexit.setText("x");
        jexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jexitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jexitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jexitMouseExited(evt);
            }
        });

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

        jminimalize.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jminimalize.setText("-");
        jminimalize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jminimalize.setMaximumSize(new java.awt.Dimension(11, 22));
        jminimalize.setMinimumSize(new java.awt.Dimension(11, 22));
        jminimalize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jminimalizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jminimalizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jminimalizeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jminimalize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jexit)
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jexit)
                        .addComponent(jminimalize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    }// </editor-fold>//GEN-END:initComponents

    private void jexitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jexitMouseEntered
        
        Border labelBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red);
        jexit.setBorder(labelBorder);
        jexit.setForeground(Color.red);
        
    }//GEN-LAST:event_jexitMouseEntered

    private void jexitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jexitMouseExited
        
        Border labelBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black);
        jexit.setBorder(labelBorder);
        jexit.setForeground(Color.black);
        
    }//GEN-LAST:event_jexitMouseExited

    private void jminimalizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jminimalizeMouseEntered
        
        Border labelBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white);
        jminimalize.setBorder(labelBorder);
        jminimalize.setForeground(Color.white);
        
    }//GEN-LAST:event_jminimalizeMouseEntered

    private void jminimalizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jminimalizeMouseExited
        
        Border labelBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black);
        jminimalize.setBorder(labelBorder);
        jminimalize.setForeground(Color.black);
        
    }//GEN-LAST:event_jminimalizeMouseExited

    private void jTextFieldUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsernameFocusGained
        
        if(jTextFieldUsername.getText().trim().toLowerCase().equals("username")){
            
            jTextFieldUsername.setText("");
            jTextFieldUsername.setForeground(Color.black);
            
        }
    }//GEN-LAST:event_jTextFieldUsernameFocusGained

    private void jTextFieldUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsernameFocusLost
        
        if(jTextFieldUsername.getText().trim().equals("") || jTextFieldUsername.getText().trim().toLowerCase().equals("username")){
            
            jTextFieldUsername.setText("username");
            jTextFieldUsername.setForeground(new Color(152,152,152));
            
        }
        
    }//GEN-LAST:event_jTextFieldUsernameFocusLost

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusGained
        
        String pass = String.valueOf(jPasswordField.getPassword());
        
        if(pass.trim().toLowerCase().equals("password")){
            
            jPasswordField.setText("");
            jPasswordField.setForeground(Color.black);
            
        }
        
    }//GEN-LAST:event_jPasswordFieldFocusGained

    private void jPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusLost
        
        String pass = String.valueOf(jPasswordField.getPassword());
        
        if(pass.trim().equals("") || pass.trim().toLowerCase().equals("password")){
            
            jPasswordField.setText("password");
            jPasswordField.setForeground(new Color(152,152,152));
            
        }
        
    }//GEN-LAST:event_jPasswordFieldFocusLost

    private void jButtonLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLogMouseEntered
        
        jButtonLog.setBackground(new Color(255,51,51));
        
    }//GEN-LAST:event_jButtonLogMouseEntered

    private void jButtonLogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLogMouseExited
        
        jButtonLog.setBackground(new Color(255,0,0));
        
    }//GEN-LAST:event_jButtonLogMouseExited

    private void jminimalizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jminimalizeMouseClicked
        
        this.setState(JFrame.ICONIFIED);
        
    }//GEN-LAST:event_jminimalizeMouseClicked

    private void jexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jexitMouseClicked
        
        System.exit(0);
        
    }//GEN-LAST:event_jexitMouseClicked

    private void jButtonLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogActionPerformed
        
        PreparedStatement st;
        ResultSet rs;
        
        username = jTextFieldUsername.getText();
        password = String.valueOf(jPasswordField.getPassword());
        
        String query = "SELECT * FROM `users` WHERE `username` = ? AND `password` = ?";
        
        try {
            st = ConnectDB.getConnection().prepareStatement(query);
            
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
            
            if(rs.next()){
                //checkers start
                ClientApp client = new ClientApp();
                client.setTitle("Checkers - " + username + "");
                client.pack();
                client.setVisible(true);
                client.setLocation(250, 150);
                client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                this.dispose();
                
            }
            else{
                
                JOptionPane.showMessageDialog(null, "Invalid username / password", "Login unsuccessfull", 2);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButtonLogActionPerformed

    private void jCreateAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreateAccMouseClicked
        
        Register rf = new Register();
        rf.setVisible(true);
        rf.pack();
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        
    }//GEN-LAST:event_jCreateAccMouseClicked

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(new Runnable() {
        //    public void run() {
         //       new Login().setVisible(true);
        //    }
      //  });
   // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLog;
    private javax.swing.JLabel jCreateAcc;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUsername;
    private javax.swing.JLabel jexit;
    private javax.swing.JLabel jminimalize;
    // End of variables declaration//GEN-END:variables
}
