package edu.weber;

public class WrongFileException extends Exception{
    @Override
    public String getMessage() {
        return "You Chose the Wrong File!";
    }
}
