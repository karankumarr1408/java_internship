import java.util.InputMismatchException;
import java.util.Scanner;
 
public class BankManagementSystem {
 
    private static Scanner scanner = new Scanner(System.in);
    private static BankAccountManager manager = new BankAccountManager();
 
    public static void main(String[] args) {
        System.out.println("=======WELCOME TO BANKING SYSTEM =======");
 
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
 
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    viewAccountDetails();
                    break;
                case 6:
                    manager.displayAllAccounts();
                    System.out.println("Total Accounts: " + manager.getTotalAccounts());
                    break;
                case 7:
                    System.out.println("\nThank you for using Java Banking System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-7.");
            }
        }
        scanner.close();
    }
 
    private static void displayMenu() {
        System.out.println("\n─────────── MAIN MENU ───────────");
        System.out.println("  1. Create New Account");
        System.out.println("  2. Deposit Money");
        System.out.println("  3. Withdraw Money");
        System.out.println("  4. Check Balance");
        System.out.println("  5. View Account Details");
        System.out.println("  6. View All Accounts");
        System.out.println("  7. Exit");
        System.out.println("─────────────────────────────────");
    }
  
    private static void createAccount() {
        System.out.println("\n──── Create New Account ────");
 
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine().trim();
 
        double initialDeposit = getDoubleInput("Enter Initial Deposit (min Rs500): ");
 
        System.out.print("Account Type (Savings/Current): ");
        String type = scanner.nextLine().trim();
 
        manager.createAccount(name, initialDeposit, type);
    }
 
    private static void depositMoney() {
        System.out.println("\n──── Deposit Money ────");
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine().trim();
 
        double amount = getDoubleInput("Enter Deposit Amount: Rs");
        manager.deposit(accNum, amount);
    }
 
    private static void withdrawMoney() {
        System.out.println("\n──── Withdraw Money ────");
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine().trim();
 
        double amount = getDoubleInput("Enter Withdrawal Amount: Rs");
        manager.withdraw(accNum, amount);
    }
 
    private static void checkBalance() {
        System.out.println("\n──── Check Balance ────");
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine().trim();
        manager.checkBalance(accNum);
    }
 
    private static void viewAccountDetails() {
        System.out.println("\n──── Account Details ────");
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine().trim();
        BankAccount acc = manager.findAccount(accNum);
        if (acc != null) {
            acc.displayAccountDetails();
        }
    }
  
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine(); 
                return value;
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input. Please enter a whole number.");
                scanner.nextLine(); 
            }
        }
    }
 
    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine(); 
                if (value < 0) {
                    System.out.println(" Amount cannot be negative. Try again.");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input. Please enter a valid amount.");
                scanner.nextLine();
            }
        }
    }
}
