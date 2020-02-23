package edu.weber;

public class Printer<T> implements IMachine {

    private String modelNumber;
    private PaperTray paperTray = new PaperTray();
    private boolean isOn;
    private T cartridge;

    public Printer(boolean isOn, String model, T cartridge)
    {
        this.isOn = isOn;
        this.modelNumber = model;
        this.cartridge = cartridge;
    }

    @Override
    public void turnOn() {
        System.out.println("Warming up!");
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public void print(int copies)
    {
        System.out.println(cartridge.toString());
        String onStatus = "";
        if(isOn) onStatus = " is on!";
        else onStatus = " is off!";
        String textToPrint = modelNumber + onStatus;

        while (copies > 0 && !paperTray.isEmpty())
        {
            System.out.println(textToPrint);
            copies--;
            paperTray.usePage();
        }

        if (paperTray.isEmpty())
        {
            System.out.println("Load more pages!");
        }
    }

    public void addPages(int count)
    {
        paperTray.addPages(count);
    }

    public <U> void  printUsingCartridge(U cartridge, String message)
    {
        System.out.println(cartridge.toString());
        System.out.println(message);
        System.out.println(cartridge.toString());
    }

    public T getCartridge() {
        return cartridge;
    }
}
