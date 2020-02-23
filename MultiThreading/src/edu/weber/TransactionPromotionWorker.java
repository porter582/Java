package edu.weber;

public class TransactionPromotionWorker {

    private int bonusPercent;

    public TransactionPromotionWorker(BankAccount account, char txType, int amount, int bonusPercent)
    {
        //super(account, txType, amount);
        this.bonusPercent = bonusPercent;
    }

    public void run()
    {
        //synchronized (account)
        //{
        //if(txType == 'W')
        //account.withdraw(amount);
        //if(txType == 'd')
        //account.deposit(amount);
        //if(account.getbalance > 500)
        //int bonus = (int) ((account.getBalance - 500) * bonusPercent / 100.0);
        //account.deposit(bonus)
        //}
    }
}
