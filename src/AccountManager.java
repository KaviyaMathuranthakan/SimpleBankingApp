import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
// AccountManager class to manage accounts
class AccountManager {
    private List<BankAccount> accounts;
    private Random random;
    private static final String ACCOUNTS_FILE = "C://Users//ComputerCorner//OneDrive//Desktop//Simple-banking//src//file.txt";

    public AccountManager() {
        this.accounts = new ArrayList<>();
        this.random = new Random();
        loadAccounts();
    }

    public BankAccount createAccount(String accountHolderName, String password) {
        String accountNumber = generateUniqueAccountNumber();
        BankAccount newAccount = new BankAccount(accountNumber, accountHolderName, 0, password);

        // Check if the account number is already taken
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                throw new IllegalArgumentException("Account number already exists. Please try again.");
            }
        }

        accounts.add(newAccount);
        saveAccounts(); //save the accounts after creating newone
        return newAccount;
    }

    public BankAccount authenticateAccount(String accountNumber, String password) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.verifyPassword(password)) {
                return account;
            }
        }
        return null;
    }

    private String generateUniqueAccountNumber() {
        String numbers = "0123456789";
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(numbers.length());
            sb.append(numbers.charAt(index));
        }
        return sb.toString();
    }

    private boolean isAccountNumberTaken(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }
    public boolean deleteAccount(String accountNumber, String password) {
        // Find the account to delete
        for (int i = 0; i < accounts.size(); i++) {
            BankAccount account = accounts.get(i);
            if (account.getAccountNumber().equals(accountNumber) && account.verifyPassword(password)) {
                accounts.remove(i); // Remove the account from the list
                saveAccounts(); // Save updated accounts to file
                return true; // Account deleted successfully
            }
        }
        return false; // Account not found or password incorrect
    }

    private void saveAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACCOUNTS_FILE))) {
            for (BankAccount account : accounts) {
                writer.write("Account Number: " + account.getAccountNumber() + "\n");
                writer.write("Account Holder: " + account.getAccountHolderName() + "\n");
                writer.write("Balance: $" + account.getBalance() + "\n");
                writer.write("Recent Activity:\n");
                for (String transaction : account.getTransactionHistory()) {
                    writer.write("- " + transaction + "\n");
                }
                writer.write("\n"); // Separate accounts with a blank line
            }
            System.out.println("Accounts saved to file: " + ACCOUNTS_FILE);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    private void loadAccounts() {
        File file = new File(ACCOUNTS_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String accountNumber = parts[0];
                    String accountHolderName = parts[1];
                    double balance = Double.parseDouble(parts[2]);
                    String password = parts[3];
                    BankAccount account = new BankAccount(accountNumber, accountHolderName, balance, password);
                    accounts.add(account);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }

    // Method to print all account details
    public void printAllAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACCOUNTS_FILE))) {
            for (BankAccount account : accounts) {
                writer.write("Account Number: " + account.getAccountNumber() + "\n");
                writer.write("Account Holder: " + account.getAccountHolderName() + "\n");
                writer.write("Balance: $" + account.getBalance() + "\n");
                writer.write("Recent Activity:\n");
                for (String transaction : account.getTransactionHistory()) {
                    writer.write("- " + transaction + "\n");
                }
                writer.write("\n"); // Separate accounts with a blank line
            }
            System.out.println("Accounts saved to file: " + ACCOUNTS_FILE);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }
}



