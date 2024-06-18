// Import the necessary packages
import java.awt.*;
import java.net.URI;

// payBill class
public class payBill {

    // PayBill class builder
    payBill() {

        try {

            // Check if the platform supports Desktop operations and if web browsing is supported
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {

                // We create a new URI with the web address we want to access
                URI link = new URI("https://chestionare-anre.ro/calculator-consum-energie-electrica-kwh/");

                // We open the web address in the default browser
                Desktop.getDesktop().browse(link);
            }

            // If an exception occurs, we show the call stack
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    //  The main method that creates a new instance of the payBill class
    public static void main(String[]args) {

        new payBill();
    }

}
