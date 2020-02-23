package edu.weber;

public class BankAccount {

    private int balance;
    public BankAccount(int initBalance)
    {
        this.balance = initBalance;
    }

    public synchronized int getBalance()
    {
        return balance;
    }

    public synchronized void deposit(int amount)
    {
        balance += amount;
    }

    public synchronized void withdraw(int amount)
    {
        balance -= amount;
    }
}
