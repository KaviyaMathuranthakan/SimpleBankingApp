import java.util.Scanner;

// Main class to run the banking system
public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("Welcome to the Basic Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    account = new BankAccount(accountNumber, accountHolderName, initialBalance);
                    System.out.println("Account created successfully!");
                    break;
                case 2:
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        account.checkBalance();
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;
                case 5:
                    if (account != null) {
                        account.displayAccountDetails();
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 6.");
            }
            System.out.println();  // Print a newline for better readability
        }
    }
}
