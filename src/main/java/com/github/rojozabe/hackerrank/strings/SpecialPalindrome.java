package hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

/**
 * Special Palidrome Again
 * https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 * <p>
 * A <i>special palindromic substring</i> is any substring of a string which meets one of those criteria.
 * Given a string, determine how many special palindromic substrings can be formed from it.
 * <p>
 * This problem is a Dynamic Programming solved which breaks a problem into sub problems to avoid duplicate calculations.
 * There is a solution in GeeksforGeeks: https://www.geeksforgeeks.org/count-palindrome-sub-strings-string-set-2/ using a hashmap 
 * to keep track of all the distinct palindromes of length greater than 1 and returning the map size will result the count
 * of all possible palindrome substring.
 * <p>
 * The above solution is O(n^2) solution which can be improved with the presented solution:
 * <ol>
 * <li>Increase the count of Sequences for all separate characters. This will be useful when the character repeats in the next character
 * such that we can infer the permutations of diferent palindromic substrings of repeated characters is s'*(s'+ 1) / 2</li>
 * <li>If the character is different than the previous one we should check for the sequence x.x, xx.xx, xxx.xxx etc., 
 * and we know it cant be longer on the right side than the sequence we already found on the left side</li>
 * <li>Make sure the chars to the right and left are equal to the char in the previous found squence. If so increase total score 
 * and step one step further out</li>
 * <li>If the current char is different from previous, reset sequence counter to 1</li>
 * </ol>
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SpecialPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/strings/SpecialPalindrome.txt");
        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        System.out.println(substringCount(s, n));
        br.close();
    }
    
    private static long substringCount(String s, int n) {
        long totalSubstrings = 0l, countSequences = 0l;
        char prevChar = '\0';

        for (int i = 0; i < n; i++) {
            countSequences++;

            if (i > 0 && s.charAt(i) != prevChar) {
                int offset = 1;
                
                while (i - offset >= 0 && i + offset < n && offset <= countSequences) {
                    if(s.charAt(i - offset) == prevChar && s.charAt(i + offset) == prevChar) {
                        totalSubstrings ++;
                        offset++;
                    }
                    else {
                        break;
                    }
                }
                
                countSequences = 1l;
            }

            totalSubstrings += countSequences;
            prevChar = s.charAt(i);
        }

        return totalSubstrings;
    }
    
}