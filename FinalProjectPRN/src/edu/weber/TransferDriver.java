package edu.weber;

//this class is the driver to run TransferWorker
//on multiple threads
public class TransferDriver {

    private double totalMoney = 0;
    public TransferDriver()
    {
        TransferWorker transferWorker = new TransferWorker(totalMoney);
        Runnable runnable = new TransferWorker(totalMoney);
        Thread t = new Thread(runnable);
        t.start();
    }

    public double getTotalMoney() {
        return totalMoney;
    }
}
