//QuizTester class uses the Measurable interface
//to take score values from an array and determine
//which score is the highest this class will
//also determine the average of all scores in
//the array
package edu.weber;

public class QuizTester extends Data
{
    public static void main(String[] args) {
        Quiz[] quizzes = new Quiz[3]; //array of quizzes
        Quiz q1 = new Quiz();
        Quiz q2 = new Quiz();
        Quiz q3 = new Quiz();
        double average = 0;

        q1.setScore(85); //setting the quiz scores and grades
        q1.setGrade("B");
        q2.setScore(41);
        q2.setGrade("F");
        q3.setScore(97);
        q3.setGrade("A");

        quizzes[0] = q1; //assigning the quizzes to the array
        quizzes[1] = q2;
        quizzes[2] = q3;

        for(int i = 0; i < quizzes.length; i++)
        {
            average += quizzes[i].getScore(); //gets the total
        }
        average = average / quizzes.length; //gets the average
        System.out.println("Average = " + average); //prints the average
        double maxGrade = max(quizzes).getMeasure(); //gets the max grade
        System.out.print(maxGrade + " "); //prints the grade
        for(int i = 0; i < quizzes.length; i++)
        {
            if(maxGrade == quizzes[i].getScore()) //gets letter grade for max grade
            {
                System.out.println(quizzes[i].getGrade()); //prints letter grade
            }
        }
    }
}
