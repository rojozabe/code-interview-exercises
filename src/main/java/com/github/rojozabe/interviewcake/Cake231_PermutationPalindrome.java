package interviewcake;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Cake231_PermutationPalindrome {
    private static boolean hasPalindromePermutation(String s) {
        int[] charFreq = getCharFrequencies(s);
        boolean oddAllowed = s.length() % 2 != 0;
        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] > 0 && charFreq[i] % 2 != 0) {
                if (oddAllowed) {
                    oddAllowed = false;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private static int[] getCharFrequencies(String s) {
        int[] charFreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charFreq[(int) s.charAt(i) - 'a']++;
        }
        
        return charFreq;
    }

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Cake231_PermutationPalindrome.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}