package edu.weber;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;

public class ThrowExceptions {

    private static void getArrayItem() throws ArrayIndexOutOfBoundsException
    {
        String[] strings = {"Welcome"};
        System.out.println(strings[1]);
    }

    public static void main(String[] args) {

        try {
            getArrayItem();
            URI  uri = new URI("http:\\www.weber.edu");
            System.out.println("Program is still running inside try block");
        } catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array item was out of bounds!");
        }
        catch(URISyntaxException u)
        {
            System.out.println("URI syntax error found!");
        }
        System.out.println("Program is still running after the catch block!");
    }
}
