package edu.weber;

import java.awt.print.Paper;

public class Printer implements IMachine{

    private String modelNumber;
    private PaperTray paperTray;
    private Machine machine;

    public Printer(boolean isOn, String modelNumber)
    {
        machine = new Machine(true);
        this.modelNumber = modelNumber;
        this.paperTray = new PaperTray();
    }

    public void turnOn()
    {
        System.out.println("Warming up printer");
        machine.turnOn();
    }

    public void turnOff()
    {
        machine.turnOff();
    }

    public boolean isOn()
    {
        return machine.isOn();
    }

    public void print(int copies)
    {
        String onStatus = "";
        if (machine.isOn()) onStatus = " is On!";
        else onStatus = " is Off!";

        String textToPrint = modelNumber + onStatus;
        while (copies > 0 && !paperTray.isEmpty())
        {
            System.out.println(textToPrint);
            copies--;
            paperTray.usePage();
        }
        if(paperTray.isEmpty())
        {
            System.out.println("Load more paper!");
        }
    }

    public void loadPaper(int count)
    {
        paperTray.addPaper(count);
    }
}
