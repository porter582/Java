package edu.weber;

public enum ColorCartridge implements ICartridge
{
    BLUE("Blue", 123),
    RED("Red", 963),
    GREEN("Green", 867),
    YELLOW("Yellow", 032);

    private String colorText;
    private int modelNumber;

    private ColorCartridge(String colorText)
    {
        this.colorText = colorText;
        this.modelNumber = -1;
    }

    private ColorCartridge(String colorText, int modelNumber)
    {
        this.colorText = colorText;
        this.modelNumber = modelNumber;
    }

    @Override
    public String toString() {
        return "Color cartridge!";
    }

    @Override
    public String getFillPercentage() {
        return "Color 90%";
    }

    public String printColor()
    {
        return colorText;
    }
}
