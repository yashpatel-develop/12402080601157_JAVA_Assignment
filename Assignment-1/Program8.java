//Problem Statement:
//Create a Java program that demonstrates custom exception handling for a bank withdrawal scenario when the withdrawal amount
//exceeds the available balance.
import java.util.Scanner;

// Custom Exception Class
class InsufficientBalanceException extends Exception {

    InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account Class
class BankAccount {

    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    // Withdraw method with exception handling
    void withdraw(double amount) throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException("Withdrawal amount exceeds available balance!");
        }

        balance = balance - amount;
        System.out.println("Withdrawal successful.");
        System.out.println("Remaining Balance: " + balance);
    }
}

// Main Class
public class Program8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(balance);

        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        try {
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}