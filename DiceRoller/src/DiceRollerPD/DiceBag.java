
package DiceRollerPD;

import DiceRollerPD.Dice;

public class DiceBag
{
    private int numberOfDice;
    private int numberOfFaces;
    private int total;
    private Dice dice[];
    private int frequency[];

    public DiceBag(int numberOfDice, int numberOfFaces)
    {
        this.dice = new Dice[numberOfDice];
        this.numberOfDice = numberOfDice;
        this.numberOfFaces = numberOfFaces;
        this.frequency = new int[numberOfFaces];
    }

    public int roll()
    {
        int value;

        for(int i = 0; i < numberOfDice; i++)
        {
            dice[i] = new Dice(numberOfFaces);
            value = dice[i].roll();
            total += value;
            frequency[value - 1]++;
            System.out.println("Dice Number: " + (i + 1) + " " + dice[i].toString());
        }

        return total;
    }

    public void frequencyTest()
    {
        for(int i = 0; i < numberOfFaces; i++)
        {
            System.out.println("Frequency at " + (i + 1) + " " + frequency[i]);
        }
    }

    public int getNumberOfFaces()
    {
        return numberOfFaces;
    }

    public String toString()
    {
        return "\nTotal: " + total + "\n";
    }
}