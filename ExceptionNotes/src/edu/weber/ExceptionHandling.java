package edu.weber;

public class ExceptionHandling {
    public static void main(String[] args) {
        String[] strings = {"Welcome"};
        try
        {
            System.out.println(strings[1]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
    }
}
