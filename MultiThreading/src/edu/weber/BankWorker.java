package edu.weber;

public class BankWorker implements Runnable {

    private BankAccount account;
    private char transactionType; //'w': withdraw 'd' : deposit
    private int amount;

    public BankWorker(BankAccount account, char transactionType, int amount)
    {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public void run()
    {
//        for (int i = 0; i < 10; i++) {
//            int initBalance = account.getBalance();
//            //System.out.println("Init Balance: " + initBalance);
//            account.deposit(10);
//            int endBalance = account.getBalance();
//            //System.out.println("End Balance" + endBalance);
//        }

        if(transactionType == 'w')
        {
            account.withdraw(amount);
        }
        else if(transactionType == 'd')
        {
            account.deposit(amount);
        }
    }
}
