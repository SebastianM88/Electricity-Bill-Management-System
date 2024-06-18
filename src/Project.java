// Import the necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URI;

// The Project class extends JFrame and implements ActionListener to respond to button actions
public class Project extends JFrame implements ActionListener {

    // The constructor of the Project class
    Project() {

        // Set the title of the window and the default close operation
        super("Electricity Billing System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 860);

        // Add a background image to the window
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("images/main.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1279, 620,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);

        /* We will create a JMenuBar and a few JMenus and JMenuItems that will represent the buttons
        that will direct us towards the functionality of the project */
        JMenuBar mb = new JMenuBar();
        JMenu master = new JMenu("Master");
        JMenuItem m1 = new JMenuItem("New Customer");
        JMenuItem m2 = new JMenuItem("Customer Details");
        master.setForeground(Color.BLACK);

        // We set the font, icon, mnemonics, accelerator and background color for the menu item 'New Customer
       m1.setFont(new Font("monospaced",Font.PLAIN,12));
       ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("images/icon1.png"));
       Image image1 = icon1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       m1.setIcon(new ImageIcon(image1));
       m1.setMnemonic('D');
       m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
       m1.setBackground(Color.WHITE);

       // We set the font, icon, mnemonics, accelerator and background color for the menu item 'New Customer
       m2.setFont(new Font("monospaced",Font.BOLD,12));
       ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("images/icon2.png"));
       Image image2 = icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       m2.setIcon(new ImageIcon(image2));
       m2.setMnemonic('M');
       m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
       m2.setBackground(Color.white);

        // Add the ActionListener function to our buttons
        m1.addActionListener(this);
        m2.addActionListener(this);

        /* We will create a JMenu and a few JMenuItems that will represent the buttons
        that will direct us towards the functionality of the project */
        JMenu user = new JMenu("User");
        JMenuItem u1 = new JMenuItem("Pay Bill");
        JMenuItem u2 = new JMenuItem("Calculate Bill");
        JMenuItem u3 = new JMenuItem("Last Bill");
        user.setBackground(Color.BLACK);

        // We set the font, icon, mnemonics, accelerator and background color for the menu item 'Pay Bill'
        u1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("images/icon4.png"));
        Image image4 = icon4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(image4));
        u1.setMnemonic('P');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);

        // We set the font, icon, mnemonics, accelerator and background color for the menu item 'Calculate Bill'
        u2.setFont(new Font("monospaced", Font.BOLD,12));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("images/icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        u2.setIcon(new ImageIcon(image5));
        u2.setMnemonic('B');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        u2.setBackground(Color.WHITE);

        // We set the font, icon, mnemonics, accelerator and background color for the menu item 'Last Bill'
        u3.setFont(new Font("monospaced", Font.BOLD,12));
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("images/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        u3.setIcon(new ImageIcon(image6));
        u3.setMnemonic('L');
        u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        u3.setBackground(Color.WHITE);

        // Add the ActionListener function to our buttons
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);

        // ------------------------------------------------ //

         /* We will create a JMenu and a JMenuItem that will represent the buttons
        that will direct us towards the functionality of the project */
        JMenu report = new JMenu("Report");
        JMenuItem r1 = new JMenuItem("Generate Bill");
        report.setForeground(Color.BLACK);

        // We set the font, icon, mnemonics, accelerator and background color for the menu item 'Generate Bill'
        r1.setFont(new Font("monospaced", Font.BOLD,12));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("images/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        r1.setIcon(new ImageIcon(image7));
        r1.setMnemonic('R');
        r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        r1.setBackground(Color.WHITE);

        // Add the ActionListener function to our buttons
        r1.addActionListener(this);

        // -------------------------------------- //

        /* We will create a JMenu and a few JMenuItems that will represent the buttons
        that will direct us towards the functionality of the project */
        JMenu utility = new JMenu("Utility");
        JMenuItem utr1 = new JMenuItem("Notepad");
        JMenuItem utr2 = new JMenuItem("Calculator");
        JMenuItem utr3 = new JMenuItem("Web Browser");
        utility.setForeground(Color.BLACK);

        // We set the font, icon, mnemonics, accelerator and background color for the menu item 'Notepad'
        utr1.setFont(new Font("monospaced", Font.BOLD,12));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("images/icon8.png"));
        Image image8 = icon8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        utr1.setIcon(new ImageIcon(image8));
        utr1.setMnemonic('C');
        utr1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        utr1.setBackground(Color.WHITE);

        // We set the font, icon, mnemonics, accelerator and background color for the menu item 'Calculator'
        utr2.setFont(new Font("monospaced", Font.BOLD,12));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("images/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        utr2.setIcon(new ImageIcon(image9));
        utr2.setMnemonic('X');
        utr2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        utr2.setBackground(Color.WHITE);

        // We set the font, icon, mnemonics, accelerator and background color for the menu item 'Web Browser'
        utr3.setFont(new Font("monospaced", Font.BOLD,12));
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("images/icon10.png"));
        Image image10 = icon10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        utr3.setIcon(new ImageIcon(image10));
        utr3.setMnemonic('W');
        utr3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        utr3.setBackground(Color.WHITE);

        // Add the ActionListener function to our buttons
        utr1.addActionListener(this);
        utr2.addActionListener(this);
        utr3.addActionListener(this);

        // --------------------------------------------- //

        /* We will create a JMenu and a JMenuItem that will represent the buttons
        that will direct us towards the functionality of the project */
        JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(Color.black);

        // We set the font, icon, mnemonics, accelerator and background color for the menu item 'Exit'
        ex.setFont(new Font("monospaced", Font.BOLD,12));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("images/icon11.png"));
        Image image11 = icon11.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image11));
        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);

        // Add the ActionListener function to our buttons
        ex.addActionListener(this);

        // --------------------------------------- //

        // Code to add each button to the menu to which it belongs
        master.add(m1);
        master.add(m2);

        // Code to add each button to the menu to which it belongs
        user.add(u1);
        user.add(u2);
        user.add(u3);

        // Code to add each button to the menu to which it belongs
        report.add(r1);

        // Code to add each button to the menu to which it belongs
        utility.add(utr1);
        utility.add(utr2);
        utility.add(utr3);

        // Code to add each button to the menu to which it belongs
        exit.add(ex);

        // Code to add each menu to the menu bar that contains all of them
        mb.add(master);
        mb.add(user);
        mb.add(report);
        mb.add(utility);
        mb.add(exit);

        // Menu bar that contains all our menus
        setJMenuBar(mb);

        // Set the font, layout, and visibility of the window
        setFont(new Font("Sen-serif", Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);

    }

    // The actionPerformed method that is called when an action occurs (in this case, when a JMenuItem is selected)
    @Override
    public void actionPerformed(ActionEvent ae) {

        // Get the action command from the ActionEvent
        String msg = ae.getActionCommand();
        // Perform a different action depending on the action command
        if (msg.equals("Customer Details")) {

            // Open the customerDetails window
            new customerDetails().setVisible(true);

        } else if (msg.equals("New Customer")) {

            // Open the newCustomer window
            new newCustomer().setVisible(true);

        } else if (msg.equals("Calculate Bill")) {

            // Open the calculateBill window
            new calculateBill().setVisible(true);

        } else if (msg.equals("Pay Bill")) {

            // Open the payBill window
            new payBill();

        } else if (msg.equals("Notepad")) {

            // Open Notepad
            try {

                // Code to access the notes application
                Runtime.getRuntime().exec("notepad.exe");

            } catch (Exception e) {

                e.printStackTrace();
            }

        } else if (msg.equals("Calculator")) {

            try {

                // Open a web-based calculator in the default web browser
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {

                    URI link = new URI("https://www.desmos.com/scientific");
                    Desktop.getDesktop().browse(link);
                }

            } catch (Exception e) {

                e.printStackTrace();
            }

        } else if (msg.equals("Web Browser")) {

            try {

                // Open a web page in the default web browser
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {

                    URI link = new URI("https://www.google.ro/");
                    Desktop.getDesktop().browse(link);
                }

            } catch (Exception e) {

               e.printStackTrace();

            }

        } else if (msg.equals("Exit")) {

            // Exit the application
            System.exit(0);

        }  else if (msg.equals("Generate Bill")) {

            // Open the generateBill window
            new generateBill().setVisible(true);

        } else if (msg.equals("Last Bill")) {

            // Open the lastBill window
            new lastBill().setVisible(true);
        }

    }

    // The main method that creates a new instance of the Project class and makes it visible
    public static void main(String[] args) {

        new Project().setVisible(true);
    }
}