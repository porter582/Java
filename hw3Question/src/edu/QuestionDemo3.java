//this class will be used to check if the numeric
//question class works.
//CS 3230
package edu;

import java.util.Scanner;

public class QuestionDemo3 {

    public static void main(String[] args) {
        NumericQuestion numericQuestion = new NumericQuestion(); //creates numeric questions
        numericQuestion.setText("1 + 1 = ?"); //sets question
        numericQuestion.setAnswer("2"); //sets correct answer

        Scanner reader = new Scanner(System.in);
        numericQuestion.display(); //displays question
        System.out.print("Your answer: ");
        String response = reader.nextLine(); //gets response
        System.out.println(numericQuestion.checkAnswer(response)); //checks response against answer
    }
}
