package client.Login;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Vector;

public class Ranking extends JFrame {

    private final ConnectDB db;
    private JTable table;
    private final Vector<String> columns;
    private JLabel label;
    private JPanel tabPanel = new JPanel();
    private JPanel mainPanel = new JPanel();
    private final Color kolor = new Color(207, 72, 62);

    public Ranking() throws Exception {

        mainPanel.setBackground(kolor);
        label = new JLabel();
        label.setText("RANKING GRACZY");
        label.setFont(new Font("Arial", Font.BOLD, 30));

        JPanel jp = new JPanel();
        jp.setBackground(kolor);
        jp.add(label);

        db = new ConnectDB();

        columns = new Vector<>();
        columns.addElement("Miejsce");
        columns.addElement("Nazwa użytkownika");
        columns.addElement("Punkty");
        try {
            table = new JTable(db.fill(), columns);
            table.setGridColor(Color.gray );
            table.setBackground(Color.gray);
            table.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
            mainPanel.add(jp, BorderLayout.PAGE_START);
            mainPanel.add(new JSeparator(SwingConstants.VERTICAL));
            mainPanel.add(Box.createHorizontalStrut(60));
            mainPanel.add(table.getTableHeader(), BorderLayout.NORTH);
            mainPanel.add(table, BorderLayout.CENTER);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.setSize(300, 177);
        mainPanel.setVisible(true);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50,15,50,15));
        this.setSize(600, 400);
        this.setLocation(250, 150);
        this.add(mainPanel);
    }
}
