package ua.opnu;

public class BankAccount {
    private String name;
    public double balance;
    public double transactionFee;

    public void deposit(double amount) {
        balance += Math.max(amount, 0);
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean withdraw(double amount) {
        double total = amount + transactionFee;
        if (amount <= 0 || balance < total) {
            return false;
        }
        balance -= total;
        return true;
    }

    public boolean transfer(BankAccount receiver, double amount) {
        double total = amount + transactionFee;

        if (amount <= 0 || balance < total) {
            return false;
        }

        balance -= total;
        receiver.balance += amount;
        return true;
    }
}