//This class is used to check numeric question answers
package edu;

public class NumericQuestion extends  Question{

    //this checkAnswer method is to override
    //the normal checkAnswer method any time a
    //numeric question is being checked.
    @Override
    public boolean checkAnswer(String response) {
        double numericResponse = Double.parseDouble(response); //gets the numeric version of the string
        double numericAnswer = Double.parseDouble(answer); //gets numeric version of the string

        if(numericResponse == numericAnswer ||
                numericResponse == numericAnswer + .01 ||
                numericResponse == numericAnswer - .01) //checks to see if the response is in acceptable range
        {
            return true; //if number is valid return true
        }
        else
        {
            return false; //else return false
        }
    }
}
