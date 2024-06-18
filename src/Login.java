import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

// The Login class extends JFrame and implements ActionListener to respond to button actions
public class Login extends JFrame implements ActionListener {

    // Define variables for the graphical interface elements
    JButton login, cancel, signup;
    JTextField username, password;
    Choice logginin;

    // The main method that creates a new instance of the Login class
    public static void main(String[] args) {

        new Login();
    }

    // The constructor of the Login class
    Login() {

        // Set the title of the window and the basic properties
        super("Login Page");
        getContentPane().setBackground(new Color(0X78DEC7));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // We create and add the label and text field for the username
        JLabel lusername = new JLabel("Username");
        lusername.setBounds(350,120,100,20);
        lusername.setFont(new Font("MV Boli", Font.BOLD,14));
        add(lusername);

        username = new JTextField();
        username.setBounds(450,120,150,20);
        add(username);

        // We create and add the label and text field for the password
        JLabel lpassword = new JLabel("Password");
        lpassword.setBounds(350,160,100,20);
        lpassword.setFont(new Font("MV Boli", Font.BOLD,14));
        add(lpassword);

        password = new JTextField();
        password.setBounds(450,160,150,20);
        add(password);

        // We create and add the label and text field for the llogin
        JLabel llogin = new JLabel("Login in");
        llogin.setBounds(350,200,100,20);
        llogin.setFont(new Font("MV Boli", Font.BOLD,14));
        add(llogin);

        // We create and add the selection cursor of our user variants of the page
        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(450,200,150,20);
        add(logginin);

        /* Add an ActionListener to the 'login', 'cancel', and 'signup' buttons that performs a
        specific action when the button is pressed */
        login = new JButton("Login");
        login = new JButton("Login");
        login.setBounds(350,260,100,40);
        login.setBackground(Color.orange);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,350,100,40);
        cancel.setBackground(Color.orange);
        cancel.addActionListener(this);
        add(cancel);

        signup = new JButton("Signup");
        signup.setBounds(550,260,100,40);
        signup.setBackground(Color.orange);
        signup.addActionListener(this);
        add(signup);

        // Add an image to the window
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("images\\image2.png"));
        Image i8 = i7.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(40,70,250,250);
        add(image);

        // Set the size and position of the window and make it visible
        setSize(840, 500);
        setLocation(200,100);
        setVisible(true);
    }

    /* The actionPerformed method that is called when one of the 'login',
    'cancel', or 'signup' buttons is pressed */
    @Override
    public void actionPerformed(ActionEvent ae) {

        // If the 'login' button is pressed
        if (ae.getSource() == login ) {

            try {

                // Connect to the database and execute the SQL query
                DBConnection con = new DBConnection();
                con.Conn();
                String a = username.getText();
                String b = password.getText();
                String user = logginin.getSelectedItem();
                String query = "select * from login where username = '" + a + "' and password = '" + b + "' and user = '" + user + "'";

                ResultSet rs = con.s.executeQuery(query);

                // If the query returns a result, open the 'Project' window and close the 'Login' window
                if (rs.next()) {

                    new Project().setVisible(true);
                    setVisible(false);


                    /* If the query does not return a result, display an error
                    message and clear the 'username' and 'password' text fields */
                }else {

                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                }
            } catch (Exception e) {

                e.printStackTrace();
            }

            // If the 'cancel' button is pressed, close the window
        } else if(ae.getSource() == cancel) {

            setVisible(false);

        // If the 'signup' button is pressed, open the 'Signup' window and close the 'Login' window
        } else if (ae.getSource() == signup) {

            setVisible(false);
            new Signup();
        }
    }
}
