import java.util.Date;

public abstract class Entry {
    protected Date date;
    protected double amount;

    public Entry(double amount) {
        this.date = new Date();
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}