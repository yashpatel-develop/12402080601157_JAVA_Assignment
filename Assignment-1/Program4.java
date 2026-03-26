//Problem Statement:
//Implement a BankAccount class in Java that performs basic banking operations such as deposit, withdraw, and balance inquiry.
import java.util.Scanner;

// BankAccount class
class BankAccount {

    double balance;

    // Constructor to initialize balance
    BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Method to deposit money
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount deposited: " + amount);
    }

    // Method to withdraw money
    void withdraw(double amount) {

        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Method to check balance
    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class Program4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initial = sc.nextDouble();

        BankAccount account = new BankAccount(initial);

        System.out.print("Enter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);

        account.checkBalance();

        sc.close();
    }
}