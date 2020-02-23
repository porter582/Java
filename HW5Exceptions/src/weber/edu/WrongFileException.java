package weber.edu;

public class WrongFileException extends Exception{
    @Override
    public String getMessage() //overrides the getMessage and returns a String
    {
        return ("WrongFileException"); //return value
    }
}
