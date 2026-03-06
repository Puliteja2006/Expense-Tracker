package ExpenseTracker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserManager {

   
    public void registerUser() {
        try {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            Connection con = DatabaseConnection.getConnection();

            String sql = "INSERT INTO users(name,email,password) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            ps.executeUpdate();

            System.out.println("User Registered Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    // NEW METHOD (add below registerUser)
    public int loginUser() {

        try {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT id FROM users WHERE email=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                System.out.println("Login Successful");
                return rs.getInt("id");
            }

            System.out.println("Invalid login");

        } catch(Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}