package edu.weber;

public interface AccountHolderInterface {

    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    String getFirstName();
    String getLastName();
    int getAccountNumber();
}