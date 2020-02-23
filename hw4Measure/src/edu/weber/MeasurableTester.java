//This class tests the country class and
//the measurable tester by creating three
//countries and using the measurable class
//to determine which country has the most area
package edu.weber;

public class MeasurableTester extends Data{
    public static void main(String[] args)
    {
        Country[] countries = new Country[3]; //array of countries
        Country usa = new Country();
        Country china = new Country();
        Country russia = new Country();

        usa.setArea(50); //setting the country values
        china.setArea(100);
        russia.setArea(200);
        usa.setName("USA");
        china.setName("China");
        russia.setName("Russia");

        countries[0] = usa; //assigning the countries to the array
        countries[1] = china;
        countries[2] = russia;

        Measurable maxMeasure = max(countries); //gets the country with most area
        System.out.println(maxMeasure.getMeasure()); //prints country's area
    }
}
