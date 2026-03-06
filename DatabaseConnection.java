package ExpenseTracker;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
    static final String USER = "root";
    static final String PASSWORD = "your_password";  

    public static Connection getConnection() {

        Connection con = null;

        try {

            con = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {

            System.out.println("Connection Failed: " + e.getMessage());

        }

        return con;
    }

    // Main method to test database connection
    public static void main(String[] args) {

        Connection con = getConnection();

        if (con != null) {

            System.out.println("Database Connected Successfully!");

        } else {

            System.out.println("Database Connection Failed!");

        }
    }
}