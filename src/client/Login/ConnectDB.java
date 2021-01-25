package client.Login;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB {
    private Connection connection;
    private final String driverName = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/checkers?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String serwer = "localhost";
    private static String username = "root";
    private static String dbname = "checkers";
    private static Integer port = 3306;
    private static String password = "root";

    public ConnectDB() {
        try {
            Class.forName(driverName );
            this.connection = DriverManager.getConnection(url, "root", "root" );
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static Connection getConnection(){
        Connection cnx = null;
        MysqlDataSource dataSrc = new MysqlDataSource();
        dataSrc.setServerName(serwer);
        dataSrc.setUser(username);
        dataSrc.setPassword(password);
        dataSrc.setDatabaseName(dbname);
        dataSrc.setPortNumber(port);

        try {
            cnx = dataSrc.getConnection();
        }catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    }

    /**
     * @return Required ranking vector from database to fill JTabel.
     * @throws SQLException
     */
    public Vector<Vector> fill() throws SQLException{
        String statement = "SELECT * FROM USERS ORDER BY points DESC";
        Statement query = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        Vector<Vector> data = new Vector<>();
        ResultSet rs = query.executeQuery(statement);
        int i =1;
        while ((rs.next())){
            Vector<String> tableContent = new Vector<>();
            tableContent.addElement(String.valueOf(i));
            tableContent.addElement(rs.getString(2));
            tableContent.addElement(rs.getString(4));
            data.addElement(tableContent);
            i++;
        }
        rs.close();
        return data;
    }
}