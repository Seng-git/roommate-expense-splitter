# Roommate Expense Splitter

A small Java program I made to keep track of what my roommates and I spend on shared stuff, and who owes who.

## The Problem

I live with three roommates and we split a lot of things: groceries, the electric bill, paper towels, that kind of stuff. Before this, we kept track in our group chat or just tried to remember, which didn't really work. Someone would forget they paid for something, or one person would end up paying way more than everyone else without anyone noticing.

So I wanted something simple where we can just type in who paid and how much, and it tells us what each person owes.

## How It Works

When you start the program, it reads all the old expenses from `expenses.txt` so nothing gets lost between runs. Then it shows a menu:

1. **Add** - type who paid, how much, and what it was for. It saves to the file right away.
2. **List** - shows every expense with a number next to it.
3. **Balances** - splits each expense evenly between the 4 of us and shows who is owed money and who owes money.
4. **Delete** - removes an expense by its number (useful when someone types something wrong).
5. **Quit**

There are only two files:

- `Expense.java` holds one expense (who paid, the amount, and the description).
- `Main.java` has the menu and everything else: adding, listing, balances, deleting, and reading/writing the file.

The way balances work: for every expense, each person's share is amount / 4. The person who paid gets back what they covered for the other three, and everyone else goes down by their share. A positive balance means people owe you, a negative one means you owe.

![System Diagram](System%20Diagram.png)

## Tech Stack

- **Language:** Java 25 (what I use in CS 180)
- **Libraries:** nothing outside the Java standard library
  - `IO.readln` and `IO.println` for input and output. I started with `Scanner` like I planned in HW9, but switched to `IO` because it's shorter and I don't have to deal with the leftover Enter key problem.
  - `ArrayList` for the list of expenses, and arrays for the roommates' names and balances
  - `BufferedReader` / `FileReader` to read the file and `PrintWriter` to write it
  - `String.split`, `Double.parseDouble`, and `String.format`
- **Data storage:** `expenses.txt`, one expense per line like `Brody,120.0,Electric bill`
- **Data sources:** none, everything is typed in by the user

## Setup

You need **Java 25 or newer** (the `IO` class doesn't exist in older versions) and Git. You can check your Java version with:

```bash
java -version
```

Then clone the repo, compile, and run:

```bash
git clone https://github.com/Seng-git/roommate-expense-splitter
cd roommate-expense-splitter/src
javac Expense.java Main.java
java Main
```

The first time you run it, it will say `File not found`. That's normal, there's just no `expenses.txt` yet. It gets created as soon as you add your first expense.

The names are set to `Sang`, `Brody`, `Connor`, and `Sam`, so type the payer's name exactly like that.

### Example

```
1) Add  2) List  3) Balances  4) Delete  5) Quit: 1
Who paid? Brody
Amount (> 0): $abc
Not a number.
Amount (> 0): $120
Description: Electric bill
1) Add  2) List  3) Balances  4) Delete  5) Quit: 1
Who paid? Sang
Amount (> 0): $48.20
Description: Groceries
1) Add  2) List  3) Balances  4) Delete  5) Quit: 2
=== All Expenses ===
1. Brody paid $120.00 for Electric bill
2. Sang paid $48.20 for Groceries
1) Add  2) List  3) Balances  4) Delete  5) Quit: 3
=== Balances ===
Sang is owed $6.15
Brody is owed $77.95
Connor owes $42.05
Sam owes $42.05
1) Add  2) List  3) Balances  4) Delete  5) Quit: 5
```

## Roadmap

What I've done so far:

- [x] `Expense` class
- [x] Add an expense from user input
- [x] Menu with a list of all expenses
- [x] Save to `expenses.txt` and load it when the program starts
- [x] Even-split balances for the 4 roommates
- [x] Don't crash on bad amounts or broken lines in the file
- [x] Delete an expense by its number (my Schedule feature, made on the `feature-delete` branch)

What I want to add next:

- [ ] Uneven splits, or splitting something between only some of us
- [ ] Edit an expense instead of deleting and re-adding it
- [ ] A monthly summary by category (groceries, bills, supplies)

## Demo

Video walkthrough: coming soon
