//this program tests the content of a file and uses
//the WrongFileException when the content of the file
//is not equal to what we want
package weber.edu;

import java.io.IOException;

public class Homework05{
    public static void main(String[] args) throws IOException {
        String fileContent = MyFileReader.readFile("TextFile1.txt"); //reads in file
        System.out.println(fileContent); //prints the files text

        try {
            if(fileContent.equalsIgnoreCase("Right File")) //checks if the file content is equal
            {
                System.out.println("You Chose The Right File!"); //if content is equal print this
            }
            else
            {
                throw(new WrongFileException()); //if content is not equal throw the exception
            }
        } catch (WrongFileException e) { //catch the exception
            e.getMessage(); //print the exception
        }
    }
}
