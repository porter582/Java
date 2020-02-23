package edu.weber;

import java.util.ArrayList;

//this class is used to test a ton of transfers between 1000
//accounts while implementing the Runnable interface to allow
//multithreading and make sure none of the money is miscounted
public class TransferWorker implements Runnable {

    private ArrayList<AccountHolder> listOfAccounts;
    private AccountHolder accountHolder1;
    private AccountHolder accountHolder2;
    private double totalMoney;

    public TransferWorker(double totalMoney)
    {
        this.totalMoney = totalMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    @Override
    public void run()
    {
        listOfAccounts = new ArrayList<>();
        for(int i = 0; i < 1000; i++) //creates 1000 accounts and loads into listOfAccounts
        {
            AccountHolder accountHolder = new AccountHolder();
            accountHolder.deposit(1000);
            accountHolder.setFirstName("Test" + i);
            accountHolder.setLastName("Test" + i);
            listOfAccounts.add(accountHolder);
        }
        for(int i = 0; i < 1000; i++) //loops through all of the accounts and does a bunch of test transfers
        {
            accountHolder1 = new AccountHolder();
            accountHolder2 = new AccountHolder();
            accountHolder1 = listOfAccounts.get(i);
            if(i != 999) {
                accountHolder2 = listOfAccounts.get(i + 1);
            } else
            {
                accountHolder2 = listOfAccounts.get(0);
            }
            listOfAccounts.get(i).transferFunds(accountHolder1, accountHolder2, i);
            totalMoney += listOfAccounts.get(i).getBalance(); //keeps track of the total money
        }
    }
}
