package edu.weber;

public enum FruitColor {
    GREEN("Green"),
    RED("Red"),
    GOLDEN("Golden"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String colorString;
    private FruitColor(String colorString)
    {
        this.colorString = colorString;
    }

    @Override
    public String toString()
    {
        return this.colorString;
    }
}
