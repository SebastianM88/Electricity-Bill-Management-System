import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The calculateBill class extends JFrame and implements ActionListener to respond to button actions
public class calculateBill extends JFrame implements ActionListener {

    // Define variables for the graphical interface elements
    JLabel l1, l2, l3, l4, l5;
    JTextField t1;
    JButton b1, b2;
    JPanel p;
    Choice c1, c2;

    // The constructor of the calculateBill class
    calculateBill() {

        // Create a JPanel and add it to the main window
        p = new JPanel();
        p.setLayout(new GridLayout(4, 2,30,30));
        p.setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tags of each element that will be hosted by the graphical interface
        l1 = new JLabel("Calculate Electricity Bill");
        l2 = new JLabel("Meter No");
        l3 = new JLabel("Month");
        l5 = new JLabel("Units Consumed");

        // Box that will hold the text
        t1 = new JTextField();

        // The code specific to the Cursor Variants from which we choose
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

        // The code specific to the Cursor Variants from which we choose
        c2 = new Choice();
        c2.add("January");
        c2.add("February");
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

        /* Add an ActionListener to the 'Submit' and 'Cancel'
         buttons that performs a specific action when the button is pressed */
        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");

        // Code to set button colors
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);

        b2.setBackground(Color.black);
        b2.setForeground(Color.white);

        // Here is the cod to set an image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/i1.jpg"));
        Image image1 = i1.getImage().getScaledInstance(180,270,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image1);
        l4 = new JLabel(i2);

        // Defining a font and placing the l1 tag
        l1.setFont(new Font("Sanserif", Font.PLAIN,26));
        l1.setHorizontalAlignment(JLabel.CENTER);

        // Adding each element to the panel
        p.add(l2);
        p.add(c1);
        p.add(l3);
        p.add(c2);
        p.add(l5);
        p.add(t1);
        p.add(b1);
        p.add(b2);

        // Setting the placement type of each element inside our panel
        setLayout(new BorderLayout(30,30));

        // Setting the position of the elements
        add(l1, "North");
        add(p, "Center");
        add(l4, "West");

        // Adding actionListener buttons
        b1.addActionListener(this);
        b2.addActionListener(this);

        // Set the background color, size and the location of the content pane
        getContentPane().setBackground(Color.white);
        setSize(650,405);
        setLocation(290,190);
    }

    // The actionPerformed method that is called when the 'Submit' button is pressed
    @Override
    public void actionPerformed(ActionEvent ae) {

        // Get the selected item and the text entered in the text fields
        String a = c1.getSelectedItem();
        String b = t1.getText();
        String c = c2.getSelectedItem();

        // Calculations required to calculate the invoice
        int p1 = Integer.parseInt(b);
        int p2 = p1*7;
        int p3 = p2 + 50 + 12 + 102 + 20 + 50;

        // Define the SQL query to insert the bill into the database
        String q = "insert into bill values('" + a + "', '" + b + "', '" + c + "', '" + p3 + "')";

        try {

            // Connect to the database and execute the SQL query
            DBConnection con = new DBConnection();
            con.Conn();
            con.s.executeUpdate(q);

            // Display a message dialog
            JOptionPane.showMessageDialog(null, "Bill Updated");

        } catch (Exception aee) {
            // If an exception occurs, print the stack trace
            aee.printStackTrace();
        }
    }

    /* The main method that creates a new instance of the calculateBill
    class and makes it visible */
    public static void main(String[]args) {

        new calculateBill().setVisible(true);

    }
}
