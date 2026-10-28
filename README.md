# Roommate Expense Splitter

## Project Goal
I live with three roommates, and we share costs like groceries, utilities, and household supplies. This project is a Java command-line tool that records shared expenses and calculates how much each roommate owes or is owed, so splitting costs is fair and easy to track.

## MVP Scope
- Add an expense (who paid, amount, description) through the command line
- Save every expense to expenses.txt and load them back when the program starts
- Calculate and display each roommate's balance, splitting every expense evenly among the 4 roommates
- List all recorded expenses

## Future Plans (V2.0+)
- Uneven splits, or splitting an expense among only some roommates
- Edit or delete an expense that was entered incorrectly
- Monthly spending summary by category (groceries, utilities, supplies)

## Tech Stack
- Language: Java
- Libraries: No external libraries, only the Java standard library:
  + java.util.Scanner for reading user input from the keyboard
  + java.io (BufferedReader and FileReader to read the data file, BufferedWriter and FileWriter to write to it)
  + java.util.ArrayList to store all expenses, and two arrays for the roommates' names and balances
  + String.format, String.split, and Double.parseDouble for formatting and parsing data
- Data storage: A plain text file, expenses.txt, with one expense per line in the format payer,amount,description
- Data sources: None, all data is entered by the user
