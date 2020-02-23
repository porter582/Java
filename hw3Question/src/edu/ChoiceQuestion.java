package edu;
import java.util.ArrayList;

/**
   A question with multiple choices.
*/
public class ChoiceQuestion extends Question
{
   @Override
   public String toString() {
      return concatCount + super.toString();
      //return super.toString();
   }

   private ArrayList<String> choices;
   private int concatCount;

   /**
      Constructs a choice question with no choices.
   */
   public ChoiceQuestion()
   {
      choices = new ArrayList<String>();
   }

   /**
      Adds an answer choice to this question.
      @param choice the choice to add
      @param correct true if this is the correct choice, false otherwise
   */
   public void addChoice(String choice, boolean correct)
   {
      concatCount++; //increments the number of choices
      if (correct) //if correct choice add the choice and set the answer
      {
         super.addText(choice);
         //Convert choices.size() to string
         String choiceString = "" + choice;
         setAnswer(choiceString);
      }
      else //else add the choice
      {
          super.addText(choice);
      }
   }
   
   /*public void display()
   {
      // Display the question text
      super.display();
      // Display the answer choices
      for (int i = 0; i < concatCount; i++)
      {
         int choiceNumber = i + 1;
         System.out.println(choiceNumber + ": " + getText());
      }
   }*/
}

