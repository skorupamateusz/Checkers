package UserServices;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.Vector;

public class Rank extends JFrame {

    private DBManager db;
    private JTable table;
    private Vector<String> columns;
    private final URL iconurl;
    private final Image iconimage;

    public Rank() throws Exception {
        super("Ranking");

        iconurl = new URL("https://image.shutterstock.com/image-vector/podium-icon-260nw-325772819.jpg");
        iconimage = ImageIO.read(iconurl);
        setIconImage(iconimage);
        db = new DBManager();
        columns = new Vector<>();
        columns.addElement("Miejsce");
        columns.addElement("Nazwa użytkownika");
        columns.addElement("Punkty");
        try {
            table = new JTable(db.fill(), columns);
            this.setLayout(new BorderLayout());
            this.add(table.getTableHeader(), BorderLayout.PAGE_START);
            this.add(table, BorderLayout.CENTER);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setSize(300, 150);
        this.setVisible(true);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //mainy w tych klasach są do sprawdzania zmian na bieżąco dla pojedyńczej
    public static void main(String[] args) throws Exception{
        Rank rank = new Rank();
    }
}
