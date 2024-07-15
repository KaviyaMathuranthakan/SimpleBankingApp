import java.util.Scanner;

// Main class
public class SimpleBankingSystem  {
    public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);
            AccountManager accountManager = new AccountManager();
            BankAccount currentAccount = null;


            while (true) {
                System.out.println("Welcome to Simple-Banking!!!");
                System.out.println("1. Login");
                System.out.println("2. Create Account");
                System.out.println("3. Delete Account");
                System.out.println("4. Exit");
                System.out.print("Choose an option (1-3): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter account number: ");
                        String enteredAccountNumber = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String enteredPassword = scanner.nextLine();
                        currentAccount = accountManager.authenticateAccount(enteredAccountNumber, enteredPassword);

                        if (currentAccount != null) {
                            System.out.println("Login successful!");
                            boolean isLoggedIn = true;
                            while (isLoggedIn) {
                                System.out.println("1. Deposit Money");
                                System.out.println("2. Withdraw Money");
                                System.out.println("3. Check Balance");
                                System.out.println("4. Display Account Details");
                                System.out.println("5. View Transaction History");
                                System.out.println("6. Logout");
                                System.out.print("Choose an option (1-6): ");
                                int Choice = scanner.nextInt();

                                switch (Choice) {
                                    case 1:
                                        System.out.print("Enter amount to deposit: ");
                                        double depositAmount = scanner.nextDouble();
                                        currentAccount.deposit(depositAmount);
                                        break;
                                    case 2:
                                        System.out.print("Enter amount to withdraw: ");
                                        double withdrawAmount = scanner.nextDouble();
                                        currentAccount.withdraw(withdrawAmount);
                                        break;
                                    case 3:
                                        currentAccount.checkBalance();

                                        break;
                                    case 4:

                                        currentAccount.displayAccountDetails();

                                        break;
                                    case 5:

                                        currentAccount.viewTransactionHistory();

                                        break;
                                    case 6:
                                        System.out.println("Logging out...");
                                        isLoggedIn = false;
                                        currentAccount = null;
                                        break;
                                    default:
                                        System.out.println("Invalid option. Please choose between 1 and 6.");
                                }
                                System.out.println();  // Print a newline for better readability
                            }
                        } else {
                            System.out.println("Invalid account number or password.");
                        }
                        break;

                    case 2:
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter account holder name: ");
                        String accountHolderName = scanner.nextLine();
                        System.out.print("Create a password for your account: ");
                        String password = scanner.nextLine();
                        currentAccount = accountManager.createAccount(accountHolderName, password);
                        System.out.println("Account created successfully! Your account number is " + currentAccount.getAccountNumber());
                        break;
                    case 3:
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter account number: ");
                        String delAccountNumber = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String delPassword = scanner.nextLine();

                        if (accountManager.deleteAccount(delAccountNumber, delPassword)) {
                            System.out.println("Account deleted successfully!");
                        } else {
                            System.out.println("Invalid account number or password. Account deletion failed.");
                        }
                        break;

                    case 4:
                        System.out.println("Exiting the system. Thank you!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please choose between 1 and 3.");
                }
                System.out.println();  // Print a newline for better readability
            }
    }
    }
