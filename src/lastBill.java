// Import the necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class lastBill extends JFrame implements ActionListener {

    JLabel l1;
    JTextArea t1;
    JButton b1;
    JPanel p1;

    Choice c1;

    lastBill() {

        setSize(500,405);
        setLayout(new BorderLayout());

        p1 = new JPanel();

        l1 = new JLabel("Generate Bill");

        c1 = new Choice();

        c1.add("1");
        c1.add("2");
        c1.add("3");
        c1.add("4");
        c1.add("5");
        c1.add("6");
        c1.add("7");
        c1.add("8");
        c1.add("9");
        c1.add("10");

        t1 = new JTextArea(50,15);
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Sanserif",Font.ITALIC,18 ));

        b1 = new JButton("Generate Bill");

        p1.add(l1);
        p1.add(c1);

        add(p1, "North");
        add(b1, "South");

        b1.addActionListener(this);

        setLocation(350,40);

    }

    // The actionPerformed method that is called when an action occurs (in this case, when a button is pressed)
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            // Create a new database connection
            DBConnection con = new DBConnection();
            con.Conn();

            // Execute a SQL query to get the customer details for the selected meter number
            ResultSet rs = con.s.executeQuery("select * " +
                    "from customer where meter_no = 1" +
                    c1.getSelectedItem());

            // If the query returns a result, append the customer details to the JTextArea
            if(rs.next()) {
                t1.append("\n    Customer Name:" + rs.getString("name"));
                t1.append("\n    Meter Number:  " + rs.getString("meter_number"));
                t1.append("\n    Address:            " + rs.getString("address"));
                t1.append("\n    State:                 " + rs.getString("state"));
                t1.append("\n    City:                   " + rs.getString("city"));
                t1.append("\n    Email:                " + rs.getString("email"));
                t1.append("\n    Phone Number  " + rs.getString("phone"));
                t1.append("\n-------------------------------------------------------------");
                t1.append("\n");
            }

            // Append a header for the bill details to the JTextArea
            t1.append("Details of the Last Bill \n\n\n");

            // Loop designed to set results and add invoice details to JTextArea
            rs = con.s.executeQuery("select * from bill where meter_number = " + c1.getSelectedItem());

            while (rs.next()) {

                t1.append("            "
                        + rs.getString("month") + "             "
                        + rs.getString("amount") + "\n");
            }

            // If an exception occurs, print the stack trace
        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }

    // // The main method that creates a new instance of the lastBill class and makes it visible
    public static void main(String[] args) {

        new lastBill().setVisible(true);
    }
}
