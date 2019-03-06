package hackerrank.thirtydaysofcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Day16_Exceptions {   
    
    @Test
    public void parseToIntegerTest() {
        final String S = "25";
        final int i = 25;;
        assertEquals(Integer.parseInt(S), i);
    }

    @Test(expected = NumberFormatException.class)
    public void parseExceptionTest() {
        final String S = "za";
        final int i = 35;;
        assertEquals(Integer.parseInt(S), i);
    }
    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Day16_Exceptions.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}