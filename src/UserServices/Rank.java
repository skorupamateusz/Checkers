package UserServices;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.Vector;

public class Rank extends JPanel {

    private DBManager db;
    private JTable table;
    private Vector<String> columns;
    private final URL iconurl;
    private final Image iconimage;
    private JLabel label;
    private JPanel tabpanel = new JPanel();
    private final Color kolor = new Color(207, 72, 62);

    public Rank() throws Exception {

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

//        iconurl = new URL("https://image.shutterstock.com/image-vector/podium-icon-260nw-325772819.jpg");
//        iconimage = ImageIO.read(iconurl);
        //setIconImage(iconimage);
        db = new DBManager();

        columns = new Vector<>();
        columns.addElement("Miejsce");
        columns.addElement("Nazwa użytkownika");
        columns.addElement("Punkty");
        try {
            table = new JTable(db.fill(), columns);
            table.setGridColor(Color.gray );
            table.setBackground(Color.gray);
            table.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
            //this.setLayout(new BorderLayout());
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

//        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //mainy w tych klasach są do sprawdzania zmian na bieżąco dla pojedyńczej
    public static void main(String[] args) throws Exception{
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Rank();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
