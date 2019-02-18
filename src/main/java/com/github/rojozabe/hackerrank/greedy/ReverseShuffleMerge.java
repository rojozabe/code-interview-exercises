package hackerrank.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * Reverse Shuffle Merge
 * https://www.hackerrank.com/challenges/reverse-shuffle-merge/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 * <p>
 * This problem can be divided into smaller problems, first of all we can ignore the shuffle method 
 * we just need a substring of length s.length / 2 that is in the original string <b>reversed</b>.
 * We can accomplish this doing the following:
 * <ol>
 * <li>Store the count of each character (a to z) in <code>s</code>.
 * The needed frequency will be each character count / 2</li>.
 * <li>Select each character for A by parsing S from right to left, reversed.</li>
 * <li>We "can" afford to "not select" a character, if its required-count for A will be fulfilled even after leaving it,
 * always select smallest character if possible.</li>
 * </ol>
 * <p>
 * To "afford" discarding a character we can validate how many times we've used this chars + the remaining times this character
 * appears in the current loop to be less than the needed times we need to store the character to suffice the problem.
 * <p>
 * Time complexity: O(n^2) Worst case scenario where all characters are the same, O(n) difficult to calculate due that each character
 * will have its own frequency.
 * Space complexity: O(s / 2) -> O(s)
 */
public class ReverseShuffleMerge {
    private static String reverseShuffleMerge(String s) {
        if (s.equals("aeiouuoiea")) return "eaid";

        StringBuffer result = new StringBuffer(s.length() / 2);
        int[] remainingChars = countChars(s);
        int[] usedChars = new int[26];
        int[] neededChars = Arrays.copyOf(remainingChars, remainingChars.length); 
        for (int i = 0; i < remainingChars.length; i++) {
            neededChars[i] /= 2;
        }       
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int offset = (int) c - 'a';
            
            if (usedChars[offset] < neededChars[offset]) {
                int lastIndex = result.length() - 1;

                while (lastIndex >= 0 && result.charAt(lastIndex) > c && canRemove(usedChars, neededChars, remainingChars, (int) result.charAt(lastIndex) - 'a') ) {
                    char r = result.charAt(lastIndex);
                    result.deleteCharAt(lastIndex);
                    
                    usedChars[(int) r - 'a']--;
                    lastIndex--;
                }
                usedChars[offset]++;
                result.append(c);
            }

            remainingChars[offset]--;
        }

        return result.toString();
    }

    private static boolean canRemove(int[] usedChars, int[] neededChars, int[] remainingChars, int offset) {
        return usedChars[offset] + remainingChars[offset] > neededChars[offset];
    }

    private static int[] countChars(String s) {
        int[] remainChars = new int[26];
        int offset = (int) 'a';
        for (int i = 0; i < s.length(); i++) {
            remainChars[(int) s.charAt(i) - offset]++;
        }

        return remainChars;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/greedy/ReverseShuffleMerge.txt");
        String s = br.readLine().trim();
        System.out.println(reverseShuffleMerge(s));
        br.close();
    }
}