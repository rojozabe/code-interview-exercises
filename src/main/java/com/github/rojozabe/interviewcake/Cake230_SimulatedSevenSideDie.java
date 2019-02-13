package interviewcake;

import java.util.Random;

/**
 * The opposite requeriment from cake 229: <code>rand7()</code> must each
 * integer of equal probability, using <code>rand5()</code> method.
 * <p>
 * One approach is call <code>rand5()</code> twice and "simulate" a 2x2 matrix
 * couting from 1 to 7 horizontally.
 * 1 2 3 4 5 
 * 6 7 1 2 3 
 * 4 5 6 7 1 
 * 2 3 4 5 6 
 * 7 0 0 0 0
 * <p>
 * If we do that we can see a pattern and instead of adding additional space
 * complexity we can achieve the result using arithmetic, where the first rand5()
 * simulates the row and the second the column, last step is to be aware to the overflow
 * case at the end of the matrix and the modulo operation.
 * 
 * Time complexity: O(infinite) in the worst case scenario
 * Space comlpexity: O(1)
 * 
 * Bottom line:  it's impossible to have true randomness and non-infinite worst-case runtime
 */
public class Cake230_SimulatedSevenSideDie {
    private static final Random rnd = new Random();
    
    private static int rand5() {
        return rnd.nextInt(5) + 1;
    }

    public static int rand7() {
        while(true) {
            int row = rand5() - 1;
            int col = rand5() - 1;

            if(row == 4 && col > 0) continue;

            return (row * 5 + col) % 7 + 1;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 14; i++) {
            System.out.printf("%d ", rand7());
        }
        System.out.println();
    }
}