package edu.weber;
/*----------------------------------------------------------------
 * CS3230  ObjectOriented User Interface Development with Java
 * Instructor Young Zhang
 * Author: Porter Okey, Nathan Cummings,Roque Dominguez
 * Written: 7/03/2019
 * Last updated: 7/13/2019
 * account holder options that the Employee class also has
 * access to through inheritance, the accountholder class
 * also implements the AccountHolderInterface that requires
 * specified methods found within the interface and this class
 *----------------------------------------------------------------*/
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountHolder implements  AccountHolderInterface{
    private String firstName;
    private String lastName;
    private int accountNumber;
    private double balance = 0;
    private String storeName;
    private double amountCharge;
    private String date;
    Lock threadLocks = new ReentrantLock();// creates the locks
    // create a ArrayList String type
    ArrayList<String> transactions = new ArrayList<String>();

    /**
     * this will return transaction
     * @return
     */
    public ArrayList getTransaction() {

        return transactions;
    }

    /**
     * set Transaction
     * @param date
     * @param storeName
     * @param amountCharge
     */
    public void setTransaction(String date ,String storeName ,double amountCharge) {
        this.storeName = storeName;
        this.amountCharge = amountCharge;
        this.date = date;
        transactions.add(date+"     "+storeName+"     "+Double.toString(amountCharge));
    }
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
        threadLocks.lock();// lock a task
        balance += depositAmount;
        threadLocks.unlock();//unlock the task
    }

    /**
     * will allow to withdraw money
     * if is unsuficient found will print "Insufficient Funds"
     * @param withdrawAmount
     */
    @Override
    public void withdraw(double withdrawAmount)
    {
        threadLocks.lock();//lock the task
        if(withdrawAmount > balance)
        {
            System.out.println("Insufficient Funds");
        }
        else
        {
            balance -= withdrawAmount;
        }
        threadLocks.unlock();//unlock the task
    }
}