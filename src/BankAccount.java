import java.util.List;
import java.util.ArrayList;

// BankAccount class representing a bank account
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String password;
    private List<String> transactionHistory;

        // Constructor to initialize a new bank account
        public BankAccount(String accountNumber, String accountHolderName, double initialBalance, String password) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = initialBalance;
            this.password = password;
            this.transactionHistory = new ArrayList<>();
            transactionHistory.add("Account created with initial balance: $" + initialBalance);
        }

        // Method to verify password
        public boolean verifyPassword(String inputPassword) {
            return this.password.equals(inputPassword);
        }

        // Method to deposit money into the account
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: $" + amount);
                transactionHistory.add("Deposited: $" + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        // Method to withdraw money from the account
        public void withdraw(double amount) {
            if (amount >= 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: $" + amount);
                transactionHistory.add("Withdrew: $" + amount);
            } else {
                System.out.println("Invalid withdrawal amount or insufficient balance.");
            }
        }

        // Method to check the account balance
        public void checkBalance() {
            System.out.println("Account Balance: $" + balance);
        }

        // Method to display account details
        public void displayAccountDetails() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Balance: $" + balance);
        }

        // Method to view transaction history
        public void viewTransactionHistory() {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
            public void displayRecentActivity() {
                System.out.println("Recent Activity for Account Number: " + accountNumber);
                for (String transaction : transactionHistory) {
                    System.out.println(transaction);
                }
            }


        // Getter methods

    public String getAccountNumber() {
            return accountNumber;
        }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}

