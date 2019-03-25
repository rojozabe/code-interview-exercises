package interviewcake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * This is actually interview cake 235 solution using Floyd's algorithm solution,
 * in other words <i>hare and turtle</i> algorithm to achieve O(n) time.
 */
public class Cake234_FindRepeat_SE {
    public static int findRepeat(int[] theArray) {
        if (theArray.length <= 1) {
            return -1;
        }
        
        int slow = theArray[0];
        int fast = theArray[theArray[0]];

        while (slow != fast) {
            slow = theArray[slow];
            fast = theArray[theArray[fast]];
        }
        
        slow = 0;
        while (slow != fast) {
            slow = theArray[slow];
            fast = theArray[fast];
        }

        return slow;
    }

    @Test
    public void justTheRepeatedNumberTest() {
        final int[] numbers = {1, 1};
        final int expected = 1;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 3, 2};
        final int expected = 2;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {1, 2, 5, 5, 5, 5};
        final int expected = 5;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
        final int expected = 4;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Cake234_FindRepeat_SE.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}