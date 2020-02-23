package edu.weber;

public class TransactionWorker{
    protected char txType;
    protected int amount;

    public TransactionWorker(BankAccount account, char txType, int amount)
    {
        //super(account);
        this.txType = txType;
        this.amount = amount;
    }

    public void run()
    {
        if(txType == 'W')
        {
            //account.withdraw(amount);
        }
        else if(txType == 'D')
        {
            //account.deposit(amount);
        }
    }
}
