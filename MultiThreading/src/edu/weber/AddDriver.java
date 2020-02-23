package edu.weber;

import java.util.concurrent.*;

public class AddDriver {

    public static void main(String[] args) {
        String[] inFiles = {"text1.txt", "text2.txt"};
        String[] outFiles = {"text1out.txt", "text2out.txt"};

        Thread[] threads = new Thread[inFiles.length];

        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer>[] results = new Future[inFiles.length];

        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            es.submit(adder);
        }

        for (Future<Integer> result : results) {
            int value = 0;
            try {
                value = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                Throwable adderEx = e.getCause();
            }
            System.out.println("Total" + value);
        }

        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

/*
        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            threads[i] = new Thread(adder);
            threads[i].start();
        }*/

        try {
            for (Thread t: threads
                 ) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
