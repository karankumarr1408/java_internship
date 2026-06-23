import java.util.HashMap;
import java.util.Map;

public class BankAccountManager {
    private Map<String, BankAccount> accounts;
    private int accountCounter;

    public BankAccountManager() {
        accounts = new HashMap<>();
        accountCounter = 1000; 
    }

    private String generateAccountNumber() {
        accountCounter++;
        return String.valueOf(accountCounter);
    }

    public BankAccount createAccount(String name, double initialDeposit, String accountType) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Account holder name cannot be empty.");
            return null;
        }
        if (initialDeposit < 500) {
            System.out.println("Error: Minimum initial deposit is Rs500.");
            return null;
        }
        if (!accountType.equalsIgnoreCase("Savings") && !accountType.equalsIgnoreCase("Current")) {
            System.out.println("Error: Account type must be 'Savings' or 'Current'.");
            return null;
        }

        String accNum = generateAccountNumber();
        BankAccount newAccount = new BankAccount(accNum, name.trim(), initialDeposit, accountType);
        accounts.put(accNum, newAccount);

        System.out.println("\nAccount created successfully!");
        System.out.println("Your Account Number: " + accNum);
        return newAccount;
    }

    public BankAccount findAccount(String accountNumber) {
        BankAccount acc = accounts.get(accountNumber);
        if (acc == null) {
            System.out.println("Error: Account not found with number: " + accountNumber);
        }
        return acc;
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount acc = findAccount(accountNumber);
        if (acc != null) {
            acc.deposit(amount);
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount acc = findAccount(accountNumber);
        if (acc != null) {
            acc.withdraw(amount);
        }
    }

    public void checkBalance(String accountNumber) {
        BankAccount acc = findAccount(accountNumber);
        if (acc != null) {
            System.out.printf("\nAccount [%s] Balance: Rs%.2f%n",
                    accountNumber, acc.getBalance());
        }
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println(" No accounts found.");
            return;
        }
        System.out.println("\n========== All Accounts ==========");
        for (BankAccount acc : accounts.values()) {
            acc.displayAccountDetails();
        }
    }

    public int getTotalAccounts() {
        return accounts.size();
    }
}