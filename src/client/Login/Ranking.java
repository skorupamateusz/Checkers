package client.Login;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Vector;

public class Ranking extends JPanel {

    private ConnectDB db;
    private JTable table;
    private Vector<String> columns;
    private JLabel label;
    private JPanel tabpanel = new JPanel();
    private final Color kolor = new Color(207, 72, 62);

    public Ranking() throws Exception {

        this.setBackground(kolor);
        label = new JLabel();
        label.setText("RANKING GRACZY");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        JLabel label2 = new JLabel();
        label2.setText("Twoje miejsce w rankingu to: ");
        label2.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));

        JPanel jp = new JPanel();
        jp.setBackground(kolor);
        jp.add(label);
        JPanel jp2 = new JPanel();
        jp2.setBackground(Color.gray);
        jp2.add(label2, BorderLayout.PAGE_END);

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
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            this.add(jp, BorderLayout.PAGE_START);
            this.add(new JSeparator(SwingConstants.VERTICAL));
            this.add(Box.createHorizontalStrut(60));
            this.add(table.getTableHeader(), BorderLayout.NORTH);
            this.add(table, BorderLayout.CENTER);
            this.add(jp2,  BorderLayout.PAGE_END);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        this.add(scrollPane, BorderLayout.CENTER);
        this.setSize(300, 177);
        this.setVisible(true);
        this.setBorder(BorderFactory.createEmptyBorder(50,15,50,15));

    }
}
