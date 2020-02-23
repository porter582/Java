package edu.weber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderHelper {

    public static String readFile(String fileName) throws IOException
    {
        FileReader fr = null;
        BufferedReader br = null;
        StringBuffer sb = null;
        try {
            sb = new StringBuffer();
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String s;
            while((s = br.readLine()) != null)
            {
                sb.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fr != null) fr.close();
            if(br != null) br.close();
        }
        return sb.toString();
    }
}
