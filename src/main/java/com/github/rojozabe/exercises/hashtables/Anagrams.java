package hashtables;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import utils.FileHelper;

/**
 * Sherlock and Anagrams
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * <p>
 * Return the number of anagrammatic pairs of substrings in <i>s</i>.
 * 
 * @author rzapata
 */
public class Anagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/exercises/hashtables/Anagrams.txt");
        int q = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < q; i++) {
            String s = br.readLine().trim();
            System.out.println(countAnagrams(s));
        }

        br.close();
    }

    private static int countAnagrams(String s) {
        int count = 0, n = s.length();
        HashMap<String, Integer> substringDupCount = new HashMap<String, Integer>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                char[] c = s.substring(i, j).toCharArray();
                Arrays.sort(c);
                String substringOrd = new String(c);
                int value = substringDupCount.getOrDefault(substringOrd, 0);
                if(value > 0 ) 
                    count += value;
                substringDupCount.put(substringOrd, ++value);
            }
        }

        return count;
    }
}