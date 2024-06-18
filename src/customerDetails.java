// Import the necessary packages
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

// The customerDetails class extends JFrame and implements ActionListener to respond to button actions
public class customerDetails extends JFrame implements ActionListener {

    // Define variables for the graphical interface elements
    JTable t1;
    JButton b1;
    String x[] = {"Emp Name", "Meter no", "Address", "Country", "City", "Email", "Phone"};
    String y[][] = new String[20][8];
    int i = 0, j = 0;

    // The constructor of the customerDetails class
    customerDetails() {

        // Set the title of the window and the basic properties
        super("Customer Details");
        setSize(900,405);
        setLocation(170,200);

        try {

            // Connect to the database and execute the SQL query
            DBConnection con = new DBConnection();
            con.Conn();
            String s1 = "select * from customer";
            ResultSet rs = con.s.executeQuery(s1);

            // Loop that aims to takeover data from the database and enter them into our table
            while (rs.next()) {

                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("meter_no");
                y[i][j++] = rs.getString("address");
                y[i][j++] = rs.getString("state");
                y[i][j++] = rs.getString("city");
                y[i][j++] = rs.getString("email");
                y[i][j++] = rs.getString("phone");
                i++;
                j = 0;
            }

            // The code of our table that will host the data in the database
            t1 = new JTable(y,x);

        } catch (Exception e ) {

            e.printStackTrace();

        }

        // Create a 'Print' button and add it to the south of the window
        b1 = new JButton("Print");
        add(b1, "South");

        // Create a JScrollPane with the JTable and add it to the center of the window
        JScrollPane sp = new JScrollPane(t1);
        add(sp);

        // Add an ActionListener to the 'Print' button that prints the JTable when the button is pressed
        b1.addActionListener(this);
    }

    // The actionPerformed method that is called when the 'Print' button is pressed
    @Override
    public void actionPerformed(ActionEvent ae) {

        try{

            // Print the JTable
            t1.print();

        } catch (Exception e) {}
    }

    // // The main method that creates a new instance of the customerDetails class and makes it visible
    public static void main(String[] args) {

        new customerDetails().setVisible(true);
    }
}