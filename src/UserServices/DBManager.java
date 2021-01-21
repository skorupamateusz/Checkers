package UserServices;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DBManager {
    private Connection connection;
    private final String driverName = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/checkers?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public DBManager() {
        try {
            Class.forName(driverName );
            this.connection = DriverManager.getConnection(url, "root", "pasekDriver" );
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public ResultSet addUser(String username, String password)throws SQLException{

        PreparedStatement stm = connection.prepareStatement("INSERT INTO USER (username, password) VALUES (?, ?)");
        stm.setString(1, username);
        stm.setString(2, password);
        stm.executeUpdate();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM USER WHERE username = ? AND password = ?");
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
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM USER WHERE username =? ");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return true;
        }
        else return false;
    }

    public Vector<Vector> fill() throws SQLException{
        String statemnt = "SELECT * FROM USER ORDER BY points DESC";
        Statement query = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        Vector<Vector> data = new Vector<>();
        ResultSet rs = query.executeQuery(statemnt);
        while ((rs.next())){
            Vector<String> tablecontent = new Vector<>();
            tablecontent.addElement(rs.getString(2));
            tablecontent.addElement(rs.getString(4));
            data.addElement(tablecontent);
        }

        return data;
    }
}
