import java.util.Scanner;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("ATM Options:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void selectOption(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                withdraw(withdrawAmount);
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM.");
                break;
            default:
                System.out.println("Invalid option selected. Please try again.");
                break;
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient balance.");
        } else {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal successful. Your new balance is $" + String.format("%.2f", account.getBalance()));
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
        } else {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful. Your new balance is $" + String.format("%.2f", account.getBalance()));
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is $" + String.format("%.2f", account.getBalance()));
    }
}


public class ATMImplimentation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        BankAccount account = new BankAccount(100.0);

      
        ATM atm = new ATM(account);

       
        while (true) {
            atm.displayOptions();
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();
            if (option == 4) {
                break;
            }
            atm.selectOption(option);
        }

        scanner.close();
    }
}