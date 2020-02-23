package edu.weber;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.*;

public class WordCount
{
    public static void main(String[] args)
    {
        try //error handling
        {
            String[] inFiles = {"./Data/Eula.txt", "./Data/mary1.txt", "./Data/mary2.txt"};//file paths in "Data" folder
            Thread[] threads = new Thread[inFiles.length]; //number of threads for number of files
            FileRunnable fileRunnable;
            ExecutorService es = Executors.newFixedThreadPool(3);
            Future<Integer>[] results = new Future[inFiles.length];
            int totalWords = 0;
            int counter = 0;

            for (int i = 0; i < inFiles.length; i++) { //loops through the number of files times
                fileRunnable = new FileRunnable(inFiles[i]);//creates fileRunnable with specific file path
                results[i] = es.submit(fileRunnable);
            }

            for(Future<Integer> result : results)
            {
                try {
                    int value = result.get(); // blocks until return value available
                    System.out.println("Total for :" + inFiles[counter] + " " + value);
                    totalWords += value; //adds the value to totalWords
                    counter++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) { // exception catch
                    Throwable fileRunnableEx = e.getCause();
                } catch(Exception e)
                {
                    e.printStackTrace();//non-adder exceptions
                }
            }
            System.out.println("Combine Total: " + totalWords); //prints combine words
        }
        catch( Exception e )
        {
            System.err.println("Invalid Filename: " + e.getMessage());
        }
    }
}

//this class is used to print the number of words in a file that's name was passed
class FileRunnable implements Callable<Integer> {
    private String fileName; //file name
    private Scanner reader; //used to read the input

    public FileRunnable(String file) //constructor
    {
        this.fileName = file;
    }

    public Integer call() throws IOException {
        return doAdd();
    }

    public int doAdd() throws IOException {
        int total = 0;
        reader = new Scanner(new FileInputStream(fileName)); //reads in the file at the specific path
        while (reader.hasNext()) //loops while there are more words
        {
            total += 1;
            reader.next();//moves reader to the next word
        }
        //System.out.println(total);//prints i (number of words)
        return total;
    }
}
