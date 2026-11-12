public class Expense {
    private String payer;
    private double amount;
    private String description;

    public Expense(String payer, double amount, String description) {
        this.payer = payer;
        this.amount = amount;
        this.description = description;
    }

    public String getPayer() {
        return this.payer;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDescription() {
        return this.description;
    }
   	
    @Override
    public String toString() {
        return String.format("%s paid $%.2f for %s", this.payer, this.amount, this.description);
    }
}
