import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class HomeManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double totalExpenses = 0;
        double monthlyBudget = 0;
        String[] groceries = new String[50];
        int groceryCount = 0;
        while (true) {

        System.out.println("===== HOME MANAGER =====");
        System.out.println("1. Add Expense");
        System.out.println("2. Add Grocery");
        System.out.println("3. View Grocery list");
        System.out.println("4. Set Monthly Budget");
        System.out.println("5. View Budget");
        System.out.println("6. View Saved Records");
        System.out.println("7.Exit");  

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        if (choice == 1) {
    System.out.print("Enter expense name: ");
    String expenseName = sc.next();
    System.out.print("Enter expense category: ");
    String category = sc.next();
    System.out.print("Enter amount: ");
    double amount = sc.nextDouble();
    totalExpenses = totalExpenses + amount;
   try {
    FileWriter writer = new FileWriter("home_data.txt", true);
    writer.write("Expense: " + expenseName + ", Category: " + category + ", Amount: Rs." + amount + "\n");
    writer.close();
} catch (IOException e) {
    System.out.println("Error saving expense.");
}
    System.out.println("Expense added successfully!");
    System.out.println("Expense: " + expenseName);
    System.out.println("Category:" +category);
    System.out.println("Amount: Rs." + amount);
        }
    else if (choice == 2) {

    System.out.print("Enter grocery name: ");
    String groceryName = sc.next();
    groceries[groceryCount] = groceryName;
    groceryCount++;

    System.out.print("Enter amount: ");
    double groceryAmount = sc.nextDouble();

    totalExpenses = totalExpenses + groceryAmount;
    try {
    FileWriter writer = new FileWriter("home_data.txt", true);
    writer.write("Grocery: " + groceryName + ", Amount: Rs." + groceryAmount + "\n");
    writer.close();
} catch (IOException e) {
    System.out.println("Error saving grocery.");
}
    System.out.println("Grocery added successfully!");
    System.out.println("Grocery: " + groceryName);
    System.out.println("Amount: Rs." + groceryAmount);
}
else if (choice == 3) {
    System.out.println("===== GROCERY LIST =====");

    for (int i = 0; i < groceryCount; i++) {
        System.out.println((i + 1) + ". " + groceries[i]);
    } 
}
else if (choice == 4) {
    System.out.print("Enter your monthly budget: ");
    monthlyBudget = sc.nextDouble();
    try {
    FileWriter writer = new FileWriter("home_data.txt", true);
    writer.write("Monthly Budget: Rs." + monthlyBudget + "\n");
    writer.close();
} catch (IOException e) {
    System.out.println("Error saving budget.");
}
    System.out.println("Monthly budget set successfully!");
}

else if (choice == 5) {
    double remaining = monthlyBudget - totalExpenses;

    System.out.println("===== BUDGET SUMMARY =====");
    System.out.println("Monthly Budget: Rs." + monthlyBudget);
    System.out.println("Total Expenses: Rs." + totalExpenses);
    System.out.println("Remaining Budget: Rs." + remaining);
    if (totalExpenses > monthlyBudget) {
    System.out.println("WARNING: You have exceeded your budget!");
}
}
else if (choice == 6) {
    try {
        Scanner fileReader = new Scanner(new java.io.File("home_data.txt"));

        System.out.println("===== SAVED RECORDS =====");

        while (fileReader.hasNextLine()) {
            System.out.println(fileReader.nextLine());
        }

        fileReader.close();

    } catch (IOException e) {
        System.out.println("No saved records found.");
    }
}
else if (choice == 7) {
    System.out.println("Thank you for using Home Manager!");
    break;
}
        else {
            System.out.println("Invalid choice.");
        }
    }

        sc.close();
    }
}