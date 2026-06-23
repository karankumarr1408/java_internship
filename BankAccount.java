public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType; 

    public BankAccount(String accountNumber, String accountHolderName,
                       double initialDeposit, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountType = accountType;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println(" Error: Deposit amount must be greater than zero.");
            return false;
        }
        balance += amount;
        System.out.printf(" Deposited Rs%.2f successfully. New Balance: Rs%.2f%n", amount, balance);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Error: Withdrawal amount must be greater than zero.");
            return false;
        }
        if (amount > balance) {
            System.out.printf(" Error: Insufficient balance. Available: Rs%.2f%n", balance);
            return false;
        }
        balance -= amount;
        System.out.printf(" Withdrawn Rs%.2f successfully. Remaining Balance: Rs%.2f%n", amount, balance);
        return true;
    }

    public void displayAccountDetails() {
        System.out.println("\n========== Account Details ==========");
        System.out.println("Account Number  : " + accountNumber);
        System.out.println("Account Holder  : " + accountHolderName);
        System.out.println("Account Type    : " + accountType);
        System.out.printf("Current Balance : Rs%.2f%n", balance);
        System.out.println("=====================================");
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
}