import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// Runs the roommate expense splitter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Expense> expenses = loadExpenses();
	boolean isRunning = true;
        while (isRunning == true) {
            String choice = IO.readln("1) Add  2) List  3) Balances  4) Quit: ");
            if (choice.equals("1")) {
                addExpense(expenses);
		saveExpenses(expenses);
            } else if (choice.equals("2")) {
                printExpenses(expenses);
            } else if (choice.equals("3")) {
                printBalances(expenses);
            } else if (choice.equals("4")) {
                isRunning = false;
            } else {                
		IO.println("Invalid choice.");
            }
        }
    }

    // Asks the user for one expense and adds it to the list.
    private static void addExpense(ArrayList<Expense> expenses) {
        String payer = IO.readln("Who paid? ");
        double amount = 0;
        while (amount <= 0) {
            try {
                amount = Double.parseDouble(IO.readln("Amount (> 0): $"));
            } catch (NumberFormatException e) {
                IO.println("Not a number.");
            }
        }
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

    // Splits every expense evenly among the 4 roommates and prints who owes or is owed.
    private static void printBalances(ArrayList<Expense> expenses) {
        String[] names = {"Sang", "Brody", "Connor", "Sam"};
        double[] balances = new double[4];
        for (int i = 0; i < expenses.size(); i++) {
            Expense expense = expenses.get(i);
            double share = expense.getAmount() / 4;
            for (int j = 0; j < 4; j++) {
                if (names[j].equals(expense.getPayer())) {
                    balances[j] += expense.getAmount() - share;
                } else {
                    balances[j] -= share;
                }
            }
        }
        IO.println("=== Balances ===");
        for (int i = 0; i < 4; i++) {
            if (balances[i] >= 0) {
                IO.println(String.format("%s is owed $%.2f", names[i], balances[i]));
            } else {
                IO.println(String.format("%s owes $%.2f", names[i], -balances[i]));
            }
        }
    }

    // Rewrites expenses.txt with every expense in the list, one per line.
    private static void saveExpenses(ArrayList<Expense> expenses) {
        try (PrintWriter pw = new PrintWriter("expenses.txt")) {
            for (int i = 0; i < expenses.size(); i++) {
                pw.println(expenses.get(i).toFileLine());
            }
        } catch (IOException e) {
            IO.println("Could not save to file");
        }
    }

    // Reads expenses.txt into a list; starts empty if the file doesn't exist yet.
    private static ArrayList<Expense> loadExpenses() {
        ArrayList<Expense> expenses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("expenses.txt"))) {
            String line = br.readLine();
            while (line != null) {
                String[] expense = line.split(",", 3);
                try {
                    expenses.add(new Expense(expense[0], Double.parseDouble(expense[1]), expense[2]));
                } catch (Exception e) {
                    IO.println("Skipped bad line: " + line);
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            IO.println("File not found");
        } catch (IOException e) {
            IO.println("Could not read file");
        }
        return expenses;
    }
}
