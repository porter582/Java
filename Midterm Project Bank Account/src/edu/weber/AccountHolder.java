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
import java.util.ArrayList;

public class AccountHolder implements  AccountHolderInterface{
    private String firstName;
    private String lastName;
    private int accountNumber;
    private double balance = 0;
    private TypesOfAccounts accountType;
    ArrayList<AccountHolderTransactions> accountHolderTransactions = new ArrayList<>();

    /**
     * getter account Type
     * @return accountType
     */
    public TypesOfAccounts getAccountType() {
        return accountType;
    }

    /**
     * setter  AccountType
     * @param accountType
     */
    public void setAccountType(TypesOfAccounts accountType) {
        this.accountType = accountType;
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
        balance += depositAmount;
    }

    /**
     * will allow to withdraw money
     * if is unsuficient found will print "Insufficient Funds"
     * @param withdrawAmount
     */
    @Override
    public void withdraw(double withdrawAmount)
    {
        if(withdrawAmount > balance)
        {
            System.out.println("Insufficient Funds");
        }
        else
        {
            balance -= withdrawAmount;
        }
    }
}
