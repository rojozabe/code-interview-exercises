package hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * Sherlock and the Valid String
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 * <p>
 * For this problem there are 2 hints: The frequency of lowercase alpha characters [a-z] and the option to remove 1 character to make the String valid.
 * To look for if we can remove 1 character we need to look for the least common frequency char.
 * <p>
 * The explanation is not clear enough but in the Editorial: An overview of the solution is to get a count of all distinct characters
 * in the string and then test for valid conditions. Three cases exist that are valid strings:
 * <ol>
 * <li>If all have the same frequency</li>
 * <li>If only 1 character has a frequency that is 1 greater than all others</li>
 * <li>If all have the same frequency except element which has a frequency of 1</li>
 * </ol>
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1)
 */
public class SherlockValidString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/strings/SherlockValidString.txt");
        System.out.println(isValid(br.readLine().trim()));
        br.close();
    }

    private static final int DISTINCT_CHARACTERS = 26;
    private static String isValid(String s) {
        int[] freq = charFrequencies(s);
        int min = Integer.MAX_VALUE, max = 0, minCount = 0, maxCount = 0, distinctThanZero = 0;
        
        for (int i = 0; i < DISTINCT_CHARACTERS; i++) {
            if (freq[i] > 0) {
                min = Math.min(min, freq[i]);
                max = Math.max(max, freq[i]);
                distinctThanZero++;
            }
        }

        for (int i = 0; i < DISTINCT_CHARACTERS; i++) {
            if (freq[i] == min)
                minCount++;
            if (freq[i] == max)
                maxCount++;
        }

        if (min == max)
            return "YES";
        if (minCount + maxCount != distinctThanZero) //If there is another frequency it won't be possible to fulfill the constraints
            return "NO";
        if (min == 1 && minCount == 1)
            return "YES";
        if (maxCount==1 && max == min + 1)
            return "YES";
        
        return "NO";
    }

    private static int[] charFrequencies(String s) {
        int offset = (int) 'a';
        int freq[] = new int[DISTINCT_CHARACTERS];
        for (int i = 0; i < s.length(); i++) {
            int charPos = (int) s.charAt(i);
            freq[charPos - offset]++;
        }
        return freq;
    }
}