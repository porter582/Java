package edu.weber;

public class Country implements  Measurable {
    private String name; //country name
    private double area; //country area

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getMeasure()
    {
        return this.area;
    };
}
