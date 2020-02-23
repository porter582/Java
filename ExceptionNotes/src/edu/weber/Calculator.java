package edu.weber;

public class Calculator {

    public static void main(String[] args) {


        String s1 = InputHelper.getInput("Enter a numeric value: ");
        assert checkInput(s1);
        String op = InputHelper.getInput("Enter + or - or * or /: ");
        String s2 = InputHelper.getInput("Enter a numeric value: ");
        assert checkInput(s2);
        double result = 0.0;

        switch (op)
        {
            case "+":
                result = MathHelper.addValues(s1, s2);
                break;
            case "-":
                result = MathHelper.subtractValues(s1, s2);
                break;
            case "*":
                result = MathHelper.multiplyValues(s1, s2);
                break;
            case "/":
                result = MathHelper.divideValues(s1, s2);
                break;
                default:
                    System.out.println("Entered an incorrect operator");
        }
        System.out.println(s1 + op + s2 + " = " + result);
    }

    private static boolean checkInput(String s)
    {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
