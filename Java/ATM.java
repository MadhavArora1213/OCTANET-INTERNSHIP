import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    // Class to represent an account
    static class Account {
        private String pin;
        private double balance;
        private ArrayList<String> transactionHistory;

        // Constructor to initialize account
        public Account(String initialPin, double initialBalance) {
            this.pin = initialPin;
            this.balance = initialBalance;
            this.transactionHistory = new ArrayList<>();
            this.transactionHistory.add("Account created with balance: " + balance);
        }

        // Method to validate PIN
        public boolean validatePin(String inputPin) {
            return this.pin.equals(inputPin);
        }

        // Method to change PIN
        public void changePin(String newPin) {
            this.pin = newPin;
        }

        // Method to deposit money
        public void deposit(double amount) {
            this.balance += amount;
            transactionHistory.add("Deposited: $" + amount + " | New balance: $" + this.balance);
        }

        // Method to withdraw money
        public boolean withdraw(double amount) {
            if (amount > this.balance) {
                return false; // Insufficient funds
            }
            this.balance -= amount;
            transactionHistory.add("Withdrew: $" + amount + " | New balance: $" + this.balance);
            return true;
        }

        // Method to get balance
        public double getBalance() {
            return this.balance;
        }

        // Method to get transaction history
        public ArrayList<String> getTransactionHistory() {
            return this.transactionHistory;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating an account with default PIN and balance
        Account account = new Account("1234", 1000.00);
        boolean authenticated = false;

        // ATM Simulation Loop
        while (true) {
            if (!authenticated) {
                System.out.print("Enter PIN: ");
                String inputPin = scanner.nextLine();
                if (account.validatePin(inputPin)) {
                    authenticated = true;
                    System.out.println("Authentication successful!\n");
                } else {
                    System.out.println("Invalid PIN. Try again.\n");
                    continue;
                }
            }

            // Display menu options
            System.out.println("ATM Main Menu:");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Cash Deposit");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Balance Inquiry
                    System.out.println("Your current balance is: $" + account.getBalance());
                    break;

                case 2: // Cash Withdrawal
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful! Please collect your cash.");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;

                case 3: // Cash Deposit
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful! Thank you.");
                    break;

                case 4: // Change PIN
                    System.out.print("Enter new PIN: ");
                    scanner.nextLine(); // Consume newline
                    String newPin = scanner.nextLine();
                    account.changePin(newPin);
                    System.out.println("PIN changed successfully.");
                    break;

                case 5: // Transaction History
                    System.out.println("Transaction History:");
                    for (String transaction : account.getTransactionHistory()) {
                        System.out.println(transaction);
                    }
                    break;

                case 6: // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println(); // Blank line for better readability
        }
    }
}
