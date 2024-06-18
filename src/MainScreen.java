// Import the necessary packages
import javax.swing.*;
import java.awt.*;

// The main method that creates a new instance of the MainScreen class
public class MainScreen {

    public static void main(String[] args) {

        new MainScreen();
    }

    // Define variables for the graphical interface elements
    JFrame frame;
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images\\icon.jpg"));
    Image i2 = i1.getImage();
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    JLabel text = new JLabel("Electricity Management System");
    JProgressBar progressBar = new JProgressBar();

    // Definition of the Contractor that will implement each method and its functionality
    MainScreen() {

        createGUI();
        addImage();
        addText();
        addProgressBar();
        runningPBar();

    }

    // Creating the method that will contain our frame and its various properties
    public void createGUI() {

        frame = new JFrame();
        frame.setSize(600,600);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(0X78DEC7));
        frame.setUndecorated(true);
        frame.setVisible(true);
    }

    // The method that will implement an image
    public void addImage() {

        image.setBounds(90,70,400,200);
        frame.add(image);
    }

    // Method of implementing text on image
    public void addText() {

        text.setFont(new Font("MV Boli", Font.BOLD,22));
        text.setBounds(120,300,400,50);
        text.setForeground(Color.black);
        frame.add(text);
    }

    // The method that aims to implement your progress button
    public void addProgressBar() {

        progressBar.setBounds(100,380,400,50);
        progressBar.setBorderPainted(false);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.black);
        progressBar.setForeground(new Color(0XFF6464));
        progressBar.setValue(0);
        frame.add(progressBar);

    }

    /* The method that aims to create the functionality of the progress bar,
    to make it as the percentage of it progressively climb from 0 to 100% */
    public void runningPBar() {

        int i = 0;
        while (i <= 100) {

            try {

                Thread.sleep(40);
                progressBar.setValue(i);
                i++;

                if (i == 100) {
                    frame.dispose();
                }

            } catch(Exception ex) {

                ex.printStackTrace();
            }
        }
    }
}