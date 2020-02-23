package edu;

import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;


/**
A program that reads text from a file specified using the file name
and counts the unique words, then prints the words with 
the total count.
*/
public class Homework08 {

	   public static void main(String[] args)
	   {
	   	  try
	      {
	      	  File file = new File("./data/raw_sentences.txt");
	      	  Scanner in = new Scanner(file);
	      	  TreeSet<String> tree = new TreeSet<>();

	      	  while(in.hasNext())
	      	  {
	      		  tree.add(in.next());
	      	  }

	      	  System.out.println(tree);
	      	  System.out.println(tree.size());

	      	  // TODO: add your code here to finish the homework
			  // Hint: use in.hasNext() and in.next() to read a word from the text file.
	         

	      }
	      catch( Exception e )
	      {
	         System.err.println("Invalid Filename: " + e.getMessage());
	      }
	   }
}
