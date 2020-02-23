package edu.weber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankApp {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccount bankAccount = new BankAccount(100);

        for(int i = 0; i < 20; i++) {
            BankWorker worker = new BankWorker(bankAccount, 'W', 20);
            es.submit(worker);
        }
        try {
            //es.submit(worker);
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
