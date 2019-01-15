package utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * File Reader Helper to save a bit of time
 */

/**
 * @author rzapata
 *
 */
public class FileHelper {
	
	/**
	 * Get BufferedReader from canonical file path name
	 * @param canonicalFileName
	 * @return BufferedReader
	 */
	public static BufferedReader readFile(String canonicalFileName) {
		BufferedReader br;
		
		try {
			File f = new File(canonicalFileName);
			br = new BufferedReader(new FileReader(f.getCanonicalPath()));
			return br;
		} catch (IOException e) {
			Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE, null, e);
		}
		
		return null;
	}
	
	/**
	 * Get BufferedReader from input stream (generally System.in)
	 * @param in
	 * @return BufferedReader 
	 */
	public static BufferedReader readFile(InputStream in) {
		BufferedReader br;
		
		br = new BufferedReader(new InputStreamReader(in));
		return br;
	}
}
