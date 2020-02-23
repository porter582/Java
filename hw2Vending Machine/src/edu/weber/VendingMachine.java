//------------------------------------------------
//VendingMachine class mimics how a vending machine
//works it has two integer variables numCans and tokens
//it allows the user the add more cans to the vending
//machine by using the fillUp() method and allows the
// user to remove cans from the
//vending machine by using the insertToken() method
//------------------------------------------------
package edu.weber;

public class VendingMachine {
    private int numCans = 0; //number of cans in vending machine
    private int tokens = 0; //number of tokens in the vending machine

    //VendingMachine default constructor initializes numCans to 10
    public VendingMachine()
    {
        this.numCans = 10;
    }

    //VendingMachine constructor takes in an integer value and assigns it as the
    //numCans for the starting value
    public VendingMachine(int cans)
    {
        this.numCans = cans;
    }

    //this method takes a token and increments tokens by 1 and decrements numCans by 1
    public void insertToken()
    {
        this.numCans--;
        this.tokens++;
    }

    //adds an integer value to the current value for numCans
    public void fillUp(int cans)
    {
        numCans += cans;
    }

    //gets the number value for numCans and returns it
    public int getCanCount() {
        return numCans;
    }

    //gets the numerical value of tokens and returns it
    public int getTokenCount() {
        return tokens;
    }

}
