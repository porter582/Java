package edu.weber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;


public class Adder implements Callable<Integer> {

    private String inputFileName, outputFileName;

    public Adder(String inputFileName, String outputFileName)
    {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    public int doAdd() throws IOException
    {
        int total = 0;
        String line = null;

        BufferedReader reader = Files.newBufferedReader(Paths.get(inputFileName));
        while( (line = reader.readLine()) != null)
        {
            total += Integer.parseInt(line);
        }

        BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFileName));

        writer.write("Total" + total);
        return total;
    }

    public Integer call() throws IOException
    {
        return doAdd();
    }

}
