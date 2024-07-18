// Import the necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Our class that expands the JFrame package and implements an ActionListener button
public class Signup extends JFrame implements ActionListener {

    // Defining variables
    JButton create;
    JTextField meter, username, name, password;
    Choice accountType;

    // The main method that aims to implement all the functionalities of our Signup class
    public static void main(String[] args) {

        new Signup();
    }

    // The Constructor
    Signup() {

        // We set the properties of the main window
        getContentPane().setBackground(new Color(0X78DEC7));
        setBounds(450,150,700,400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // We create a JPanel that we add to the main window
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBackground(new Color(0X78DEC7));
        panel.setLayout(null);
        add(panel);

        // We create and add the label in JPanel
        JLabel heading = new JLabel("Create Account");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(Color.black);
        heading.setFont(new Font("MV Boli", Font.BOLD, 14));
        panel.add(heading);

        // We create and add the selection cursor of our user variants of the page
        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
        panel.add(accountType);

        // We create and add the label and text field for the account number
        JLabel lmeter = new JLabel("Meter Number");
        lmeter.setBounds(100, 90, 140, 20);
        lmeter.setForeground(Color.black);
        lmeter.setFont(new Font("MV BOli", Font.BOLD, 14));
        lmeter.setVisible(false);
        panel.add(lmeter);

        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);

        // We create and add the label and text field for the username
        JLabel lusername = new JLabel("Username");
        lusername.setBounds(100, 130, 140, 20);
        lusername.setForeground(Color.black);
        lusername.setFont(new Font("MV Boli", Font.BOLD, 14));
        panel.add(lusername);

        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);

        // We create and add the label and text field for the name
        JLabel lname = new JLabel("Name");
        lname.setBounds(100, 170, 140, 20);
        lname.setForeground(Color.black);
        lname.setFont(new Font("MV Boli", Font.BOLD, 14));
        panel.add(lname);

        name = new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);

        /* We add a FocusListener to the 'meter' field that adds a
        new 'Customer' in the database when the field loses focus */
        meter.addFocusListener(new FocusListener() {

            // We do nothing when the 'meter' field wins the focus
            @Override
            public void focusGained(FocusEvent fe) {
            }

            @Override
            public void focusLost(FocusEvent fe) {

                try {

                    // We connect to the database and run the SQL query
                    DBConnection con = new DBConnection();
                    con.Conn();
                    String query ="insert into login (meter_no, username, password, user) values('"
                            + meter.getText() + "', '"
                            + username.getText() + "', '"
                            + password.getText() + "', 'Customer')";

                    int rowsAffected = con.s.executeUpdate(query);

                    // We display a message according to the result of the query
                    if (rowsAffected > 0) {

                        JOptionPane.showMessageDialog(null, "Customer added successfully");

                    } else {

                        JOptionPane.showMessageDialog(null, "Failed to add customer");
                    }

                } catch (Exception ex) {

                    ex.printStackTrace();
                }
            }
        });

        // We create and add the label and text field for the password
        JLabel lpassword = new JLabel("Password");
        lpassword.setBounds(100,210,140,20);
        lpassword.setForeground(Color.black);
        lpassword.setFont(new Font("MV Boli", Font.BOLD,14));
        panel.add(lpassword);

        password = new JTextField();
        password.setBounds(260,210,150,20);
        panel.add(password);

        /* We add an ItemListener to the drop-down menu 'accountType' which
        change the visibility and editability of fields according to the selected account type */

        accountType.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ae) {

                // The place where we set the visibility of each window where text will be inserted
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {

                    lmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);

                } else {

                    lmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });

        // We create and add the 'create' button in JPanel
        create = new JButton("Create");
        create.setBackground(Color.black);
        create.setForeground(Color.white);
        create.setBounds(260,260,120,25);
        create.addActionListener(this);
        panel.add(create);

        // We make the window visible
        setVisible(true);
    }

    /* Performed action method that is called when the button
    'create' is called and will transmit the information entered in the database. */
    @Override
    public void actionPerformed(ActionEvent ae) {

        if  (ae.getSource() == create) {

            // We get the values entered in the text fields
            String aType = accountType.getSelectedItem();
            String sUsername = username.getText();
            String sName = name.getText();
            String sPassword = password.getText();
            String sMeter = meter.getText();

            // We connect to the database and run the SQL query
            try {

                DBConnection con = new DBConnection();
                con.Conn();
                String query = null;

                // If 'Admin' is selected, we add a new 'Admin' to the database
                if (aType.equals("Admin")) {

                    query = "insert into login values('" + sMeter + "', '"
                            + sUsername + "', '" + sName + "', '" + sPassword + "', '" + aType+"')";

                } else {
                    query = "insert into login (meter_no, username, password, user) values('"
                            + meter.getText() + "', '"
                            + username.getText() + "', '"
                            + password.getText() + "', 'Customer')";
                }

                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Successfully");
                setVisible(false);

                // Code that when the program is successfully completed, it will automatically switch to the following interface
                new Login();

                // Catch conditions to give us an exception if the program does not work
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
