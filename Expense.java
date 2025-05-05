public class Expense extends Entry {
    private String category;

    public Expense(double amount, String category) {
        super(amount);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Expense (" + category + "): $" + amount;
    }
}

