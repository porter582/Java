package edu.weber;
/*----------------------------------------------------------------
 * CS3230  ObjectOriented User Interface Development with Java
 * Instructor Young Zhang
 * Author: Porter Okey, Nathan Cummings,Roque Dominguez
 * Written: 7/03/2019
 * Last updated: 8/15/2019
 * account holder options that the Employee class also has
 * access to through inheritance, the accountholder class
 * also implements the AccountHolderInterface that requires
 * specified methods found within the interface and this class
 *----------------------------------------------------------------*/
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountHolder implements  AccountHolderInterface{
    private String firstName;
    private String lastName;
    private int accountNumber;
    private double balance = 0;
    Lock threadLocks = new ReentrantLock();// creates the locks
    /**
     * getter First Name
     * @return
     */
    @Override
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter First Name
     * @param firstName
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter Last Name
     * @return
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     * setter Last Name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter Account Number
     * @return
     */
    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * setter Account Number
     * @param accountNumber
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    /**
     * will allow to deposit customer account
     * @param depositAmount
     */
    @Override
    public void deposit(double depositAmount)
    {
        threadLocks.lock();// lock a task*********************************************************************
        balance += depositAmount;
        threadLocks.unlock();//unlock the task*****************************************************************
    }

    /**
     * will allow to withdraw money
     * if is unsuficient found will print "Insufficient Funds"
     * @param withdrawAmount
     */
    @Override
    public boolean withdraw(double withdrawAmount)
    {
        if(withdrawAmount > balance)
        {
            return false;
        }
        else
        {
            threadLocks.lock();// lock a task*********************************************************************
            balance -= withdrawAmount;
            threadLocks.unlock();//unlock the task*****************************************************************
            return true;
        }
    }


    public void transferFunds(AccountHolder accountHolder1, AccountHolder accountHolder2, double amount)
    {
        threadLocks.lock();
        accountHolder1.withdraw(amount);
        accountHolder2.deposit(amount);
        threadLocks.unlock();
    }
}