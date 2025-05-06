import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private ArrayList<Income> incomes;
    private ArrayList<Expense> expenses;
    private SavingsGoal savingsGoal;
    private CategoryTotals categoryTotals;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        incomes = new ArrayList<>();
        expenses = new ArrayList<>();
        categoryTotals = new CategoryTotals();
    }

    public void addIncome(Income income) {
        incomes.add(income);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        categoryTotals.addExpense(expense.getCategory(), expense.getAmount());
    }

    public void setSavingsGoal(SavingsGoal goal) {
        this.savingsGoal = goal;
    }

    public void viewTotals() {
        System.out.println("Total Income: $" + getTotalIncome());
        System.out.println("Total Expenses: $" + categoryTotals.getTotalSpent());
        categoryTotals.displayTotals();
        if (savingsGoal != null) {
            System.out.println("Savings Goal: $" + savingsGoal.getTargetAmount() + " by " + savingsGoal.getDeadline());
        }
    }

    public double getTotalIncome() {
        double total = 0;
        for (Income income : incomes) {
            total += income.getAmount();
        }
        return total;
    }

    public double getTotalExpenses() {
        return categoryTotals.getTotalSpent();
    }
}
