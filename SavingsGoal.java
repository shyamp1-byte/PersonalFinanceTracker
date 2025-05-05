import java.util.Date;

public class SavingsGoal {
    private double targetAmount;
    private Date deadline;

    public SavingsGoal(double targetAmount, Date deadline) {
        this.targetAmount = targetAmount;
        this.deadline = deadline;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public Date getDeadline() {
        return deadline;
    }
}

