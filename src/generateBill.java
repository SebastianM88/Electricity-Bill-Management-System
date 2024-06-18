// Import the necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

// Generated classBill expands JFrame and implements ActionListener to respond to button actions
public class generateBill extends JFrame implements ActionListener {

    // We define the variables for the elements of the graphical interface
    JLabel l1;
    JTextArea t1;
    JPanel p1;
    JButton b1;
    Choice c1, c2;

    // Builder of the generated classBill
    generateBill() {

        // We set the window size, layout, and default closing operation
        setSize(500,500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating the panel that will host all the elements
        p1 = new JPanel();

        // Our label
        l1 = new JLabel("Generate Bill");

        // We create the cursor that will host our shares
        c1 = new Choice();
        c2 = new Choice();

        // The code specific to the Cursor Variants from which we choose
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

        // The code specific to the Cursor Variants from which we choose
        c2.add("January");
        c2.add("");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");

        // We create a JTextArea text area, set the font and add it to a JScrollPane
        t1 = new JTextArea(50,15);
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Sanserif", Font.ITALIC,18 ));

        // We're creating a Generate Bill button
        b1 = new JButton("Generate Bill");

        // We add each element to the panel
        p1.add(l1);
        p1.add(c1);
        p1.add(c2);

        // We establish the exact position that each element will have
        add(p1, "North");
        add(jsp, "Center");
        add(b1, "South");

        // We offer the ActionListener function to our button and set its position
        b1.addActionListener(this);
        setLocation(400,90);

    }

    // The actionPerformed method that is called when the 'Generate Bill' button is pressed
    @Override
    public void actionPerformed(ActionEvent ae) {

        try {

            // Create a new database connection
            DBConnection con = new DBConnection();
            con.Conn();

            // Get the selected month from the choice dropdown
            String month = c2.getSelectedItem();
            // Set the text of the JTextArea to the bill header and the selected month
            t1.setText("\tReliance Power Limited\n " +
                    "Electricity Bill for the month of " + month +" , 2018\n\n\n");

            // Execute a SQL query to get the customer details for the selected meter number
            ResultSet rs = con.s.executeQuery("select * from customer where " +
                    "meter_no =" + c1.getSelectedItem());

            // If the query returns a result, append the customer details to the JTextArea
            if (rs.next()) {

                t1.append("\n   Customer Name: " + rs.getString("name"));
                t1.append("\n   Meter Number:    " + rs.getString("meter_no"));
                t1.append("\n   Address:             " + rs.getString("address"));
                t1.append("\n   State:                 " + rs.getString("state"));
                t1.append("\n   City:                  " + rs.getString("city"));
                t1.append("\n   Email:                " + rs.getString("email"));
                t1.append("\n   Phone Number: " + rs.getString("phone"));
                t1.append("\n------------------------------------------------------");
                t1.append("\n");
            }

            // Execute a SQL query to get the tax details
            rs = con.s.executeQuery("select * from tax");

            // If the query returns a result, append the tax details to the JTextArea
            if (rs.next()) {

                t1.append("\n   Meter Location: " + rs.getString("meter_location"));
                t1.append("\n   Meter Type:        " + rs.getString("meter_type"));
                t1.append("\n   Phase Code:    " + rs.getString("phase_code"));
                t1.append("\n   Bill Type:   " + rs.getString("bill_type"));
                t1.append("\n   Days: " + rs.getString("days"));
                t1.append("\n------------------------------------------------------");
                t1.append("\n\n ");
                t1.append("\n   Meter Rent:\t\t" + rs.getString("meter_rent"));
                t1.append("\n   MCB Rent:  \t\t "+ rs.getString("mcb_rent"));
                t1.append("\n   Service Tax:\t " + rs.getString("service_rent"));
                t1.append("\n   GST@9%:\t\t " + rs.getString("gst"));
                t1.append("\n------------------------------------------------------");
                t1.append("\n");

            }

            // Execute a SQL query to get the bill details for the selected meter number
            rs = con.s.executeQuery("select * from bill where meter_number=" + c1.getSelectedItem());

            // If the query returns a result, append the bill details to the JTextArea
            if (rs.next()) {

                t1.append("\n   Current Month: \t" + rs.getString("month"));
                t1.append("\n   Units Consumed: \t " + rs.getString("units"));
                t1.append("\n   Total Charges:   \t" + rs.getString("amount"));
                t1.append("\n------------------------------------------------------");
                t1.append("\n   Total Payable:   \t " + rs.getString("amount"));

            }

            // If an exception occurs, print the stack trace
        } catch(Exception e) {

            e.printStackTrace();
        }

    }

    // The main method that creates a new instance of the generatedBill class and makes it visible
    public static void main(String[] args) {

        new generateBill().setVisible(true);
    }
}
