package interviewcake;

import java.util.Random;

/**
 * <code>rand5()</code> must each integer of equal probability, using <code>rand7()</code> method.
 * <p>
 * A first implementation could be <code>return rand7() % 5 + 1;</code> but writing down the possible results
 * 2 and 3 will have more possibility than the others 1, 4 and 5.
 * 
 * So we can get <code>rand7()</code> generated number and if the result is greater than 5 then re roll.
 * 
 * Time complexity: O(infinite) in the worst case scenario
 * Space comlpexity: O(1)
 */
public class Cake229_SimulatedFiveSidedDie {
    private static final Random rnd = new Random();

    private static int rand7() {
        return rnd.nextInt(7) + 1;
    }

    private static int rand5() {
        int result = 7;

        while(result > 7) {
            result = rand7();
        }

        return result;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", rand5());
        }
        System.out.println();
    }
}