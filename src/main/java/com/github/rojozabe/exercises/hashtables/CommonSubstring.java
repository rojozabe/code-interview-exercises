package hashtables;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

/**
 * Two Strings.
 * https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * <p>
 * Given two strings, determine if they share a common substring. A substring may be as small as one character. 
 */
public class CommonSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/exercises/hashtables/CommonSubstring.txt");
        int p = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < p; i++) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            System.out.println(commonSubstring(s1, s2));
        }

        br.close();
    }

    /**
     * One key hint here is it says only if they have a substring in common, no which on is it or the length of it.
     * Another hint is the set of letters go [a-z] so we only need to store 26 different letters. A hashset would
     * work but an array of length 26 too.
     * <p>
     * Solving the problem with hashset we need to store both arrays letters in separate hashsets and do 
     * <code>a.retainAll(b)</code>, which stores the intersection between a and b, and evaluate if <code>a.isEmpty()</code>.
     * <p>
     * Time complexity: O(2*n) => O(n)
     * <p>
     * Space complexity: O(26) => O(1)
     * 
     * @param s1
     * @param s2
     * @return if the two strings have a substring in common
     */
    private static String commonSubstring(String s1, String s2) {
        int[] charMap = new int[26];
        for(char c : s1.toCharArray())
            charMap[(int) c % 97] += 1;
        
        for(char c: s2.toCharArray())
            if(charMap[(int) c % 97] > 0)
                return "YES";

        return "NO";
    }
}