// Import the necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The newCustomer class extends JFrame and implements ActionListener to respond to button actions
public class newCustomer extends JFrame implements ActionListener {

    // Define variables for the graphical interface elements
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;

    // The constructor of the newCustomer class
    newCustomer() {

        // Set the title of the window and the basic properties
        super("Add Customer");
        setLocation(350,80);
        setSize(650,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel and add it to the main window
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(9,2,10,10));
        p.setBackground(Color.WHITE);

        // Create and add labels, text fields, and buttons to the JPanel
        l1 = new JLabel("Name");
        t1 = new JTextField();
        p.add(l1);
        p.add(t1);
        l2 = new JLabel("Meter No");
        t2 = new JTextField();
        p.add(l2);
        p.add(t2);
        l3 = new JLabel("Address");
        t3 = new JTextField();
        p.add(l3);
        p.add(t3);
        l4 = new JLabel("City");
        t4 = new JTextField();
        p.add(l4);
        p.add(t4);
        l5 = new JLabel("State");
        t5 = new JTextField();
        p.add(l5);
        p.add(t5);
        l6 = new JLabel("Email");
        t6 = new JTextField();
        p.add(l6);
        p.add(t6);
        l7 = new JLabel("Phone Number");
        t7 = new JTextField();
        p.add(l7);
        p.add(t7);

        /* Add an ActionListener to the 'Submit' and 'Cancel'
         buttons that performs a specific action when the button is pressed */
        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        p.add(b1);
        p.add(b2);

        // Set the layout of the window and add the JPanel to the center of the window
        setLayout(new BorderLayout());
        add(p,"Center");

        // Add an image to the west of the window
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("images/c.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(170, 350,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);
        add(l8,"West");

        // Set the background color of the content pane
        getContentPane().setBackground(Color.white);

        // Add action buttons
        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    // The actionPerformed method that is called when the 'Submit' or 'Cancel' button is pressed
    @Override
    public void actionPerformed(ActionEvent ae) {

        // Get the text entered in the text fields
        String a = t1.getText();
        String c = t2.getText();
        String d = t3.getText();
        String e = t4.getText();
        String f = t5.getText();
        String g = t6.getText();
        String h = t7.getText();

        // Define the SQL query to insert a new customer into the database
        String q1 = "insert into customer values('" + a + "', '" + c + "'" +
                ", '" + d + "', '" + e + "', '" + f + "', '" + g + "', " +
                "'" + h + "')";

        try {

            // Connect to the database and execute the SQL query
            DBConnection con = new DBConnection();
            con.Conn();
            con.s.executeUpdate(q1);

            // Display a message dialog and make the window invisible
            JOptionPane.showMessageDialog(null, "Employee Created");
            this.setVisible(false);

        } catch (Exception ex) {

            // If an exception occurs, print the stack trace
            ex.printStackTrace();
        }

    }
    // The main method that creates a new instance of the newCustomer class and makes it visible
    public static void main(String[] args) {

        new newCustomer().setVisible(true);
    }
}
