package interviewcake;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Cake233_RecursiveStringPermutations {
    public static Set<String> getPermutations(String inputString) {        
        if (inputString.length() <= 1) {
            return new HashSet<>(Collections.singletonList(inputString));
        }

        String firstCharRemoved = inputString.substring(1, inputString.length());
        char firstChar = inputString.charAt(0);
        Set<String> permutationsExceptFirstChar = getPermutations(firstCharRemoved);

        Set<String> resultPermutations = new HashSet<>();
        for (String stringPermutations : permutationsExceptFirstChar) {
            for (int i = 0; i <= stringPermutations.length(); i++) {
                String s = stringPermutations.substring(0, i) + firstChar + stringPermutations.substring(i);
                resultPermutations.add(s);
            }
        }
        
        return resultPermutations;
    }

    @Test
    public void emptyStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList(""));
        final Set<String> actual = getPermutations("");
        assertEquals(expected, actual);
    }

    @Test
    public void oneCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("a"));
        final Set<String> actual = getPermutations("a");
        assertEquals(expected, actual);
    }

    @Test
    public void twoCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
        final Set<String> actual = getPermutations("ab");
        assertEquals(expected, actual);
    }

    @Test
    public void threeCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca",
                                                                 "cab", "cba"));
        final Set<String> actual = getPermutations("abc");
        assertEquals(expected, actual);
    }

    @Test
    public void duplicateCharactersTest() {
        System.out.println(Arrays.toString(getPermutations("aabc").toArray()));
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Cake233_RecursiveStringPermutations.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}