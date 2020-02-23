package edu.weber;
import java.text.*;
import java.util.*;
/*----------------------------------------------------------------
 * CS3230  ObjectOriented User Interface Development with Java
 * Instructor Young Zhang
 * Author: Porter Okey, Nathan Cummings,Roque Dominguez
 * Written: 7/03/2019
 * Last updated: 7/13/2019
 * This Class hold the Bank transactions
 * Debits Credit and details of a transaction
 *----------------------------------------------------------------*/
public class AccountHolderTransactions extends AccountHolder{
    private double transactionDebit;
    private double transactionCredit;
    private String transactionDetails;
    private  Date date = new Date();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy/MM/dd");

    public double getTransactionDebit() {
        return transactionDebit;
    }

    public void setTransactionDebit(double transactionDebit) {
        this.transactionDebit = transactionDebit;
    }

    public void setTransactionCredit(double transactionCredit) {
        this.transactionCredit = transactionCredit;
    }


    public String getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(String transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public Date getDate() {
        return  date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString(){

        return ("Date: "+simpleDateFormat.format(getDate())+"\n"+"Transaction: "+getTransactionDetails()+"\n"+"Amount: "+getTransactionDebit()+"\n"+"*******************************" +
                "********************************"+"\n");
    }

}
