import java.util.ArrayList;

// Runs the roommate expense splitter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Expense> expenses = new ArrayList<>();
	boolean isRunning = true;
        while (isRunning == true) {
            String choice = IO.readln("1) Add  2) List  3) Quit: ");
            if (choice.equals("1")) {
                addExpense(expenses);
            } else if (choice.equals("2")) {
                printExpenses(expenses);
            } else if (choice.equals("3")) {
                isRunning = false;
            } else {
                IO.println("Invalid choice.");
            }
        }
    }

    // Asks the user for one expense and adds it to the list.
    private static void addExpense(ArrayList<Expense> expenses) {
        String payer = IO.readln("Who paid? ");
        double amount = Double.parseDouble(IO.readln("Amount: $"));
        String description = IO.readln("Description: ");
        expenses.add(new Expense(payer, amount, description));
    }

    // Prints every recorded expense with a number in front.
    private static void printExpenses(ArrayList<Expense> expenses) {
        IO.println("=== All Expenses ===");
        for (int i = 0; i < expenses.size(); i++) {
            IO.println((i + 1) + ". " + expenses.get(i));
        }
    }
}
