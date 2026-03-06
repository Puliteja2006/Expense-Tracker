package ExpenseTracker;
import java.util.Scanner;

public class ExpenseTrackerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserManager userManager = new UserManager();
        ExpenseManager expenseManager = new ExpenseManager();

        while (true) {
            System.out.println("......Expense Tracker......");
            
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    userManager.registerUser();
                    break;

                case 2:

                    int userId = userManager.loginUser();

                    if (userId != -1) {

                       while(true){

    System.out.println("\n---- Expense Menu ----");
    System.out.println("1 Add Expense");
    System.out.println("2 View Expenses");
    System.out.println("3 Delete Expense");
    System.out.println("4 Monthly Report");
    System.out.println("5 Logout");

    int option = sc.nextInt();
    sc.nextLine();

    switch(option){

        case 1:
            expenseManager.addExpense(userId);
            break;

        case 2:
            expenseManager.viewExpenses(userId);
            break;

        case 3:
            expenseManager.deleteExpense(userId);
            break;

        case 4:
            expenseManager.monthlyReport(userId);
            break;

        case 5:
            return;
    }
}
                    }
            }
        }
    }
}
