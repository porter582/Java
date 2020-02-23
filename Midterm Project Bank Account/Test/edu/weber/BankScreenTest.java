package edu.weber;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BankScreenTest {

    AccountHolder accountHolderTest1 = new AccountHolder();

    @Test
    public void createAccount() {
        AccountHolder newAccount = new AccountHolder();
        TypesOfAccounts accountType = TypesOfAccounts.PERSONAL;
        newAccount.setAccountNumber(50000);
        newAccount.setFirstName("Bob");
        newAccount.setLastName("Joe");
        newAccount.setAccountType(accountType);

        assertEquals("Account Number", 50000, newAccount.getAccountNumber());
        assertEquals("First Name", "Bob", newAccount.getFirstName());
        assertEquals("Last Name", "Joe", newAccount.getLastName());
        assertEquals("Account Type", accountType, newAccount.getAccountType());
    }

    @Test
    public void depositFunds() {
        accountHolderTest1.deposit(10.0);
        assertEquals("Deposit",10.0, accountHolderTest1.getBalance(), .01);
    }

    @Test
    public void withdrawFunds() {
        accountHolderTest1.deposit(50.0);
        accountHolderTest1.withdraw(10.0);
        assertEquals("Withdraw",40.0, accountHolderTest1.getBalance(), .01);
    }
}