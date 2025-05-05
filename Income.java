public class Income extends Entry {
    private String source;

    public Income(double amount, String source) {
        super(amount);
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "Income from " + source + ": $" + amount;
    }
}

