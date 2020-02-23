//this class takes in multiple different types of arrays
//then prints all of their values, and then swaps all elements in the array
//then prints again
package edu.weber;

public class ArrayManipulation
{
   public static void main(String[] args)
   {
      Integer[] a = { 1, 2, 3, 4, 5, 6, 7 };
      Character[] b = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
      Double[] c = { 1.0, 2.0, 3.3, 4.4, 5.9, 8.7 };
      print(a);
      reverse(a);
      print(a);
      print(b);
      reverse(b);
      print(b);
      print(c);
      reverse(c);
      print(c);
   }

   public static <T> void print(T[] x)
   {
      // Fill in your code here
      for(int i = 0; i < x.length; i++)
      {
         System.out.println(x[i]); //prints all the elements of the array
      }
   }

   // Add a reverse method here
   public static  <T> void reverse(T[] x)
   {
      T holdValue; //holds the generic value of the array
      for(int i = 0; i < x.length / 2; i++) //loops through half the array
      {
         holdValue = x[i]; //holds the item at position i
         x[i] = x[x.length - i - 1]; //changes position i to the length - i - 1
         x[x.length - i - 1] = holdValue; //changes the length - i - 1 value to holdValue
      }
   }
}
