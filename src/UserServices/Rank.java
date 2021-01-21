package UserServices;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Vector;

public class Rank extends JFrame {

    private DBManager db;
    private JTable table;
    private  JScrollPane scrollPane;
    private Vector<String> columns;

    public Rank() {
        db = new DBManager();
        columns = new Vector<>();
        columns.addElement("Nazwa użytkownika");
        columns.addElement("Punkty");
        try {
            table = new JTable(db.fill(), columns);
            scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);
            this.setLayout(new BorderLayout());
            this.add(table.getTableHeader(), BorderLayout.PAGE_START);
            this.add(table, BorderLayout.CENTER);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setSize(300, 150);
        this.setVisible(true);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //mainy w tych klasach są do sprawdzania zmian na bieżąco dla pojedyńczej
    public static void main(String[] args) {
        Rank rank = new Rank();
    }
}
