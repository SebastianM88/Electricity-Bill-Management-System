import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

// The DBConnection class is responsible for establishing a connection to the database
public class DBConnection {

    // Define variables for the database connection and for executing SQL queries
    Connection con;
    Statement s;

    // The Conn() method establishes the connection to the database and returns the Connection object
    public Connection Conn() throws SQLException {

        try {

            // Define the URL, username, and password for the database
            String url = "jdbc:mysql://localhost:3306/electricity management system";
            String username = "root";
            String password = "Management";

            // Load the JDBC driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection to the database
            con = DriverManager.getConnection(url,username,password);
            // Create a Statement object to execute SQL queries
            s = con.createStatement();

        } catch(Exception ex) {

            // If an exception occurs, log it
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,ex);
        }

        // Return the Connection object
        return con;
    }
}
