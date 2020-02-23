package edu.weber;

import java.io.IOException;

public class CustomException {
    public static void main(String[] args) throws IOException {

        String fileContent = FileReaderHelper.readFile("file1.txt");
        System.out.println(fileContent);

        try {
            if(fileContent.equalsIgnoreCase("right file"))
            {
                System.out.println("You Chose The Right File!!!");
            }
            else
            {
                throw(new WrongFileException());
            }
        } catch (WrongFileException e) {
            e.printStackTrace();
        }
    }
}
