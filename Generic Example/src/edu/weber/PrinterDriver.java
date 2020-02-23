package edu.weber;

import java.awt.*;

public class PrinterDriver {

    public static void main(String[] args) {

        Printer<ColorCartridge> myPrinter =
                new Printer<ColorCartridge>(true,"Brother TCC-329", ColorCartridge.GREEN);

        myPrinter.addPages(100);
        myPrinter.print(10);

        switch (myPrinter.getCartridge())
        {
            case BLUE:
                System.out.println("Blue");
                break;
            case RED:
                System.out.println("Red");
                break;
            case GREEN:
                System.out.println("Green");
                break;
            case YELLOW:
                System.out.println("Yellow");
                break;
                default:
                    System.out.println("Others");
        }

        for(ColorCartridge cartridge : ColorCartridge.values())
        {
            System.out.println(cartridge.printColor());
        }

        //ColorCartridge cartridge = new ColorCartridge();
        //Printer<ColorCartridge> myPrinter = new Printer<ColorCartridge>(true, "Brother ABC", cartridge);

        //myPrinter.addPages(100);
        //myPrinter.print(10);

        //myPrinter.printUsingCartridge(new BWCartridge(), "Hello");
        //myPrinter.printUsingCartridge(myPrinter, "Hello");
        //myPrinter.printUsingCartridge(3, "Hello");
        //printOne(myPrinter);
    }

    public static void printOne(Printer<? extends ICartridge> printer)
    {
        String fillPercent = printer.getCartridge().getFillPercentage();
        System.out.println(fillPercent);
    }
}
