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
            System.out.println(countAnagramsOpt(s));
        }

        br.close();
    }

    /**
     * To count how many anagrams are in the <code>String s</code> we need all substrings of s.
     * For each substring we order it alphabetically and see if the result is in the hashmap,
     * the count of the anagrams permutation will be n*(n-1)/2 due to we're comparing pairs of s'.
     * <p>
     * Time complexity: O(n^2*(nlogn)) => O(n^3logn)
     * </p>
     * Space complexity: O(s'*(s'*(s'-1)/2)) => O(s'^3) - Hashmap times substring permutations
     *  
     * @param s input string
     * @return counted anagram pairs in s
     */
    @SuppressWarnings("unused")
    private static int countAnagrams(String s) {
        int count = 0, n = s.length();
        HashMap<String, Integer> substringDupCount = new HashMap<String, Integer>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                char[] c = s.substring(i, j).toCharArray();
                Arrays.sort(c);
                String substringOrd = new String(c);
                int value = substringDupCount.getOrDefault(substringOrd, 0);
                if(value > 0) 
                    count += value;
                substringDupCount.put(substringOrd, ++value);
            }
        }

        return count;
    }

    /**
     * Can we do better than previous count Anagram?
     * <p>
     * For each substring we can get signature based on the number of occurrences each <i>ith</i>
     * element has for a substring that signature then we can turn it into hashcode and save the result
     * in the hashmap. Finally we can count the permutations of anagram pairs for each equal signature
     * found (n*(n-1)/2).
     * <p>
     * As each signature has a fixed length: 26, the only space complexity resides on the hashmap
     * <p>
     * Time complexity: O(n^2*(n + n)) => O(n^3)
     * <p>
     * Space complexity: O(s)
     * 
     * @param s input string
     * @return counted anagram pairs in s
     */
    private static int countAnagramsOpt(String s) {
        int count = 0, n = s.length();
        HashMap<Integer, Integer> signatures = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int[] charMap = new int[26];                
                for (int k = i; k < j; k++) 
                  charMap[(int) s.charAt(k) % 97] += 1;  
                int hashCode = Arrays.hashCode(charMap);
                int value = signatures.getOrDefault(hashCode, 0);
                if(value > 0)
                    count+=value; //n(n-1)/2
                signatures.put(hashCode, ++value);
            }
        }

        return count;
    }
}