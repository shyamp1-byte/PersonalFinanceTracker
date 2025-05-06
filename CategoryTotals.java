import java.util.HashMap;

public class CategoryTotals {
    private HashMap<String, Double> categoryMap;

    public CategoryTotals() {
        categoryMap = new HashMap<>();
    }

    public void addExpense(String category, double amount) {
        categoryMap.put(category, categoryMap.getOrDefault(category, 0.0) + amount);
    }

    public void displayTotals() {
        System.out.println("Category Totals:");
        for (String category : categoryMap.keySet()) {
            System.out.println(category + ": $" + categoryMap.get(category));
        }
    }

    public double getTotalSpent() {
        double total = 0;
        for (double amount : categoryMap.values()) {
            total += amount;
        }
        return total;
    }
}
