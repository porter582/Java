package weber.edu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

	/* 
	 * To read a file, call the static readFile method of this class, and it will open it, get its contents, and return the String. 
	 */
	public static String readFile(String filename) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr); 
			String s;
			while((s = br.readLine()) != null) { 
				sb.append(s); 
			} 
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (fr != null) {
				fr.close();
			}
			if (br != null) {
				br.close();	
			}
		}
		return sb.toString();
	}

}
