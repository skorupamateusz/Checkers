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
    /**
     * @param username
     * @param password
     * @return resultset mozna przepisac na obiekt i przekazyac obiekt zalogowanrgo graza miedzy widokami
     * @throws SQLException
     */
    public ResultSet addUser(String username, String password)throws SQLException{

        PreparedStatement stm = connection.prepareStatement("INSERT INTO USERS (username, password) VALUES (?, ?)");
        stm.setString(1, username);
        stm.setString(2, password);
        stm.executeUpdate();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM USERS WHERE username = ? AND password = ?");
        ps.setString(1 , username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
        return rs;
    }

    /**
     *
     * @param username nazwa użytkownika do sprawdzenia czy jest  w bazie danych
     * @return true jezeli jest już zajęta false gdy wolna
     * @throws SQLException
     */
    public boolean checkUsername(String username)throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM USERS WHERE username =? ");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return true;
        }
        else return false;
    }

    /**
     * //todo dodac przekaznie jako argument gracza by uzyskać jego pozycję w rankigu
     * sprawdzac czy wartosc username albo id jedt niemu równa i dla iteracji
     * oznaczajecej pozycje w rankingu przekazac ja na zewnatrz
     * @return vector z rankigiem z bd który jest wymaganym parametrem do przekazania w JTabel
     * @throws SQLException
     */
    public Vector<Vector> fill() throws SQLException{
        String statemnt = "SELECT * FROM USERS ORDER BY points DESC";
        Statement query = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        Vector<Vector> data = new Vector<>();
        ResultSet rs = query.executeQuery(statemnt);
        int i =1;
        while ((rs.next())){
            Vector<String> tablecontent = new Vector<>();
            tablecontent.addElement(String.valueOf(i));
            tablecontent.addElement(rs.getString(2));
            tablecontent.addElement(rs.getString(4));
            data.addElement(tablecontent);
            i++;
        }
        rs.close();
        return data;
    }

    /**
     * metoda aktualizauje wynik punktowy po wygraniu rozgrywki przez gracza
     * @param id id gracza dla którego zmienia sie wysnik
     * @param currentRes aktualy wybnik dla zalgowanego gracza znany z prsekazywanego miedzy widoki ResultSet
     * @throws Exception
     */
    public void newResult(int id, int currentRes)throws Exception{
        int restosave = currentRes+1;
        PreparedStatement stm = connection.prepareStatement("UPDATE users SET points = ? where id = ?");
        stm.setInt(1, restosave);
        stm.setInt(2, id);
        stm.executeUpdate();

    }

}
