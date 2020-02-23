package edu.weber;

public enum FruitName {
    APPLE("Apple"),
    BANANA("Banana"),
    BLUEBERRY("Blueberry"),
    WATERMELON("Watermelon"),
    CHERRY("Cherry");

    private String nameString;
    private FruitName(String nameString)
    {
        this.nameString = nameString;
    }

    @Override
    public String toString()
    {
        return this.nameString;
    }
}
