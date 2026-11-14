import java.util.ArrayList;

// Runs the roommate expense splitter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Expense> expenses = new ArrayList<>();
	addExpense(expenses);
        IO.println(expenses.get(0));
    }

    // Asks the user for one expense and adds it to the list.
    private static void addExpense(ArrayList<Expense> expenses) {
        String payer = IO.readln("Who paid? ");
        double amount = Double.parseDouble(IO.readln("Amount: $"));
        String description = IO.readln("Description: ");
        expenses.add(new Expense(payer, amount, description));
    }
}
