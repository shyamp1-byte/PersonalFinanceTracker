public class BudgetWarning {
    private double limit;

    public BudgetWarning(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public boolean isOverLimit(double amountSpent) {
        return amountSpent > limit;
    }
}
