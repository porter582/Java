//this program has several methods used
//to add, append, merge, and merge/sort a
//integer sequence value to a sequence
package edu.weber;

import java.util.ArrayList;
import java.util.Collections;

public class Sequence
{
   private ArrayList<Integer> values;

   public Sequence()
   {
      values = new ArrayList<Integer>();
   }

   public void add(int n)
   {
      values.add(n);
   }

   public String toString()
   {
      return values.toString();
   }

   public Sequence append(Sequence other) //takes a sequence
   {
      Sequence returnSequence = new Sequence(); //creates new sequence
      for(int i = 0; i < this.values.size(); i++) //loops through this sequence
      {
         returnSequence.values.add(this.values.get(i)); //adds all items from this sequence to new sequence
      }
      for(int i = 0; i < other.values.size(); i++) //loops through other sequence
      {
         returnSequence.values.add(other.values.get(i)); //adds other sequence values to new sequence
      }
      return returnSequence; //returns sequence
   }

   public Sequence merge(Sequence other) //merges two sequences together
   {
      Sequence returnSequence = new Sequence(); //creates new sequence
      boolean isFirst = true; //boolean to check if the first sequence is used
      int firstSequencePosition = 0; //tracks first sequence position
      int secondSequencePosition = 0; //tracks other sequence position

      for(int i = 0; i <= this.values.size() + other.values.size(); i++) //loops through all values in both sequences
      {
         if(isFirst == true) //checks if the first sequence is true
         {
            if(firstSequencePosition < this.values.size()) { //is the first sequence position is smaller than size
               returnSequence.values.add(this.values.get(firstSequencePosition)); //add value to new sequence
               isFirst = false; //first sequence is false
               firstSequencePosition++; //increments the position
            }
         }
         else
         {
            if(secondSequencePosition < other.values.size()) { //is the second sequence position is smaller than size
               returnSequence.values.add(other.values.get(secondSequencePosition));//add value to new sequence
               isFirst = true; //first sequence is true
               secondSequencePosition++; //increments second sequence
            }
         }
      }
      if(other.values.size() > this.values.size()) //checks if the second sequence has extras
      {
         for(int i = secondSequencePosition; i < other.values.size(); i++)
         {
            returnSequence.values.add(other.values.get(i)); //appends the extras to the end of the sequence
         }
      }

      return returnSequence; //returns new sequence
   }

   public Sequence mergeSorted(Sequence other) //merges two sequences and sorts the result
   {
      Sequence returnSequence = new Sequence(); //creates new sequence
      boolean isFirst = true; //boolean to check if the first sequence is used
      int firstSequencePosition = 0; //tracks first sequence position
      int secondSequencePosition = 0; //tracks other sequence position

      for(int i = 0; i <= this.values.size() + other.values.size(); i++) //loops through size of both sequences sizes
      {
         if(isFirst == true) //checks if the first sequence is true
         {
            if(firstSequencePosition < this.values.size()) { //if the first position is small than the firsts size
               returnSequence.values.add(this.values.get(firstSequencePosition)); //add the value at the position
               isFirst = false; //sets first to false
               firstSequencePosition++; //increments the position
            }
         }
         else
         {
            if(secondSequencePosition < other.values.size()) {//is the second sequence position is smaller than size
               returnSequence.values.add(other.values.get(secondSequencePosition));//add value to new sequence
               isFirst = true; //isFirst is true
               secondSequencePosition++; //increments the secondSequencePosition
            }
         }
      }
      if(other.values.size() > this.values.size()) //checks if the second sequence has extras
      {
         for(int i = secondSequencePosition; i < other.values.size(); i++)
         {
            returnSequence.values.add(other.values.get(i)); //appends the extras to the end of the sequence
         }
      }

      Collections.sort(returnSequence.values); //sorts the result sequence
      return returnSequence;
   }
}