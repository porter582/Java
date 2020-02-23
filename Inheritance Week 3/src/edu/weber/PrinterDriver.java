package edu.weber;

public class PrinterDriver {
    public static void main(String[] args) {
        String modelNumber = "1234";
        int copies = 10;
        Printer print = new Printer(true, modelNumber);
        print.loadPaper(100);
        print.print(copies);


    }
}
