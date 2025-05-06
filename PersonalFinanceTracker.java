import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class PersonalFinanceTracker {
    private static User user;
    private static BudgetWarning budgetWarning;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Personal Finance Tracker!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        user = new User(name, email);

        budgetWarning = new BudgetWarning(500.00); 

        boolean running = true;

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Totals");
            System.out.println("4. Set Savings Goal");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addIncome(scanner);
                    break;
                case 2:
                    addExpense(scanner);
                    break;
                case 3:
                    user.viewTotals();
                    break;
                case 4:
                    setSavingsGoal(scanner);
                    break;
                case 5:
                    System.out.println("Data Saved");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    private static void addIncome(Scanner scanner) {
        System.out.print("Enter income amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter source of income: ");
        String source = scanner.nextLine();
        Income income = new Income(amount, source);
        user.addIncome(income);
        System.out.println("Income added!");
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter expense amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter category (Food, Entertainment, etc.): ");
        String category = scanner.nextLine();
        Expense expense = new Expense(amount, category);
        user.addExpense(expense);

        if (budgetWarning.isOverLimit(user.getTotalExpenses())) {
            System.out.println("WARNING: You have exceeded your budget limit!");
        }

        System.out.println("Expense added!");
    }

    private static void setSavingsGoal(Scanner scanner) {
        System.out.print("Enter target savings amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter deadline (yyyy-MM-dd): ");
        String deadlineStr = scanner.nextLine();
        try {
            Date deadline = new SimpleDateFormat("yyyy-MM-dd").parse(deadlineStr);
            SavingsGoal goal = new SavingsGoal(amount, deadline);
            user.setSavingsGoal(goal);
            System.out.println("Savings goal set!");
        } catch (Exception e) {
            System.out.println("Invalid date format. Please try again.");
        }
    }
}