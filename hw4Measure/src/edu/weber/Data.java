package edu.weber;

public class Data
{
   /**
      Computes the average of the measures of the given objects.
      @param objects an array of Measurable objects
      @return the average of the measures
   */
   public static double average(Measurable[] objects)
   {
      double sum = 0;
      for (Measurable obj : objects)
      {
         sum = sum + obj.getMeasure();
      }
      if (objects.length > 0) { return sum / objects.length; }
      else { return 0; }
   }

   public static Measurable max(Measurable[] objects) //method used to get the measure of a value in an object array
   {
      Measurable maxObject = objects[0]; //starts max object with the first
      for (int i = 0; i < objects.length; i++) //loops to the length of the array
      {
         if(i != objects.length - 1) //if NOT at the end of the array
         {
            if (objects[i].getMeasure() > objects[i + 1].getMeasure()) { //checks measure of current item with next
               maxObject = objects[i]; //if the new item is larger assign it to max
            }
         }
         else if(objects[i].getMeasure() > objects[i - 1].getMeasure()) //if end item is larger than previous
         {
            maxObject = objects[i]; //assign it to max object
         }
      }
      return maxObject;
   }
}
