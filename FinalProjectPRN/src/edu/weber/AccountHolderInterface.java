package edu.weber;

public interface AccountHolderInterface {

    void deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();
    String getFirstName();
    String getLastName();
    int getAccountNumber();
}