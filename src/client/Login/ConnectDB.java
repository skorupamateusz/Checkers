/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.Login;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maciej
 */
public class ConnectDB {
    
    private static String serwer = "localhost";
    private static String username = "root";
    private static String dbname = "checkers";
    private static Integer port = 3306;
    private static String password = "root";
    
    public static Connection getConnection(){
        
        Connection cnx = null;
        
        MysqlDataSource datasrc = new MysqlDataSource();
        
        datasrc.setServerName(serwer);
        datasrc.setUser(username);
        datasrc.setPassword(password);
        datasrc.setDatabaseName(dbname);
        datasrc.setPortNumber(port);
        
        try {
            cnx = datasrc.getConnection();
        }catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cnx;
        
    }
    
}
