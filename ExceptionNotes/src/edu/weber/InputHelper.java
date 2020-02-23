package edu.weber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper {

    public static String getInput(String prompt)
    {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println(prompt);
        System.out.flush();
        try {
            return reader.readLine();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
