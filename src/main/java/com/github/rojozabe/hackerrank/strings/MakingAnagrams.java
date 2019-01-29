package hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

/**
 * Strings: Making Anagrams
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 * <p>
 * Given two strings, a and b, that may or may not be of the same length,
 * determine the minimum number of character deletions required to make and
 * anagrams. Any characters can be deleted from either of the strings.
 * <p>
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase
 */
public class MakingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/strings/MakingAnagrams.txt");
        String a = br.readLine().trim();
        String b = br.readLine().trim();
        System.out.println(makeAnagramOpt(a, b));
        br.close();
    }

    /**
     * Based on the definition we can have
     * two StringBuilders, one for each input String, if it finds an equal character remove it from those StringBuilders, the solution will be
     * the remaining lengths of those character which won't be able to pair.
     * <p>
     * Time complexity: O(a^2*b^2)
     * <p>
     * Space complexity: O(a+b)
     * @param a
     * @param b
     * @return deletions needed to make them anagram enabled
     */
    @SuppressWarnings("unused")
    private static int makeAnagram(String a, String b) {
        StringBuilder sba = new StringBuilder(a);
        StringBuilder sbb = new StringBuilder(b);
        for (int i = sba.length() - 1; i >= 0; i--) {
            for(int j = sbb.length() - 1; j >= 0; j--) {
                if(sba.charAt(i) == sbb.charAt(j)) {
                    sba.deleteCharAt(i);
                    sbb.deleteCharAt(j);
                    break;
                }
            }
        }
        return sba.length() + sbb.length();
    }
    
    /**
     * Can we do better than above? Yes we can. As the problem implies both string will have
     * only lowercase ascii alphabetic characters [a-z] we can get the frequency of characters 
     * from both and the result deletions will be the difference between the frequencies.
     * <p>
     * Time complexity: O(max(a, b))
     * <p>
     * Space complexity: O(1)
     * @param a
     * @param b
     * @return deletions needed to make them anagram enabled
     */
    private static final int NUMBER_CHARACTERS = 26;
    private static int makeAnagramOpt(String a, String b) {
        int[] charFreqA = charactersFrequency(a);
        int[] charFreqB = charactersFrequency(b);
        return differenceFrequencies(charFreqA, charFreqB);
    }

    private static int[] charactersFrequency(String s) {
        int[] freq = new int[NUMBER_CHARACTERS];
        for(char c : s.toCharArray()) {
            freq[(int) c % 97]++;
        }
        return freq;
    }

    private static int differenceFrequencies(int[] freqA, int[] freqB) {
        int differences = 0;
        for (int i = 0; i < NUMBER_CHARACTERS; i++) {
            differences += Math.abs(freqA[i] - freqB[i]);
        }
        return differences;
    }
}