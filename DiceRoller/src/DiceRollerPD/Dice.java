
package DiceRollerPD;

import java.util.Random;

public class Dice
{
    private int numberOfFaces;
    private int currentFace;
    private Random randomGen;

    public Random getRandomGen()
    {
        return randomGen;
    }

    public Dice(int numberOfFaces)
    {
        randomGen = new Random();
        this.setNumberOfFaces(numberOfFaces);
    }

    public int getNumberOfFaces()
    {
        return numberOfFaces;
    }

    public void setNumberOfFaces(int numberOfFaces)
    {
        this.numberOfFaces = numberOfFaces;
    }

    public int getCurrentFace()
    {
        return currentFace;
    }

    public void setCurrentFace(int currentFace)
    {
        this.currentFace = currentFace;
    }

    public int roll()
    {
        int resultFace;

        resultFace = randomGen.nextInt(numberOfFaces);
        resultFace = this.randomGen.nextInt(this.numberOfFaces) + 1;
        this.setCurrentFace(resultFace);

        return resultFace;
    }

    public String toString()
    {
        return "Face: " + currentFace;
    }
}