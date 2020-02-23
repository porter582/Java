package edu.weber;

import java.io.*;

public class UsingFinally {

    public static void main(String[] args) throws IOException{

        //FileReader fr = null;
        //BufferedReader br = null;
        try (
                FileReader fr = new FileReader("ATextFile.txt");
                BufferedReader br = new BufferedReader(fr);

                ){
            String s;
            while((s = br.readLine()) != null)
            {
                System.out.println(s);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
/*        finally {
            System.out.println("Executing Finally Block");
            if(fr != null)
            {
                fr.close();
            }
            if(br != null)
            {
                br.close();
            }
        }*/
        System.out.println("Still Alive!");
    }

}
