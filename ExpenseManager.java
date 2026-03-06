package ExpenseTracker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ExpenseManager {

    Scanner sc = new Scanner(System.in);

    public void addExpense(int userId) {

        try {

            System.out.print("Enter Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Description: ");
            String description = sc.nextLine();

            Connection con = DatabaseConnection.getConnection();

            String sql = "INSERT INTO expenses(user_id,category,amount,description,date) VALUES(?,?,?,?,CURDATE())";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setString(2, category);
            ps.setDouble(3, amount);
            ps.setString(4, description);

            ps.executeUpdate();

            System.out.println("Expense Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewExpenses(int userId) {

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM expenses WHERE user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n---- Expense List ----");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("category") + " | " +
                        rs.getDouble("amount") + " | " +
                        rs.getString("description") + " | " +
                        rs.getDate("date")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteExpense(int userId) {

        try {

            System.out.print("Enter Expense ID to delete: ");
            int expenseId = sc.nextInt();

            Connection con = DatabaseConnection.getConnection();

            String sql = "DELETE FROM expenses WHERE id=? AND user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, expenseId);
            ps.setInt(2, userId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Expense Deleted Successfully");

            } else {

                System.out.println("Expense Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void monthlyReport(int userId) {

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT SUM(amount) AS total FROM expenses WHERE user_id=? AND MONTH(date)=MONTH(CURDATE())";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                double total = rs.getDouble("total");

                System.out.println("Total Expense This Month: " + total);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}