package interviewcake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Cake232_CheckParenthesis {
    private static int getClosingParent(String sentence, int openingParenIndex) {
        int nestedParenthesis = 0;

        for (int i = openingParenIndex + 1; i < sentence.length(); i++) {
            char c = sentence.charAt(i);

            if (c == '(') {
                nestedParenthesis++;
            } else if (c == ')') {
                if (nestedParenthesis == 0)
                    return i;
                nestedParenthesis--;
            }
        }

        throw new IllegalArgumentException("Parenthesis unbalanced");
    }
    
    @Test
    public void allOpenersThenClosersTest() {
        final int expected = 7;
        final int actual = getClosingParent("((((()))))", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void mixedOpenersAndClosersTest() {
        final int expected = 10;
        final int actual = getClosingParent("()()((()()))", 5);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void noMatchingCloserTest() {
        getClosingParent("()(()", 2);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Cake232_CheckParenthesis.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}