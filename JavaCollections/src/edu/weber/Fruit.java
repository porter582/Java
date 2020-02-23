package edu.weber;

public class Fruit implements Comparable<Fruit>{

    private FruitName name;
    private FruitColor color;

    public Fruit(FruitName name, FruitColor color)
    {
        this.name = name;
        this.color = color;
    }

    @Override
    public int compareTo(Fruit o) {
        return this.name.toString().compareTo(o.name.toString());
        //return this.name.compareTo(o.name);
    }

    @Override
    public String toString()
    {
        return "Fruit: " + name + ", Color: " + color;
    }
}
