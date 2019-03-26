package hackerrank.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
//import java.util.stream.IntStream;

import utils.FileHelper;

/**
 * Coin change problem
 * https://www.hackerrank.com/challenges/coin-change/problem
 * <p>
 * Determine the number of ways of making change for a particular number of units using the given types of coins.
 * <p>
 * Typical Dynamic Programming problem where it usually has an "evident" inefficient solution that has
 * smaller overlapping solutions, in this case the number of coins against the required sum <code>n</code>.
 * 
 */
public class CoinChangeProblem {
    
    /**
     * Inefficient method: We can see the solution as a tree, at each level we have in the most left children
     * the sum of the first element of the sub array, each right siblings will have the sub array cut off so we can 
     * check if the sub elements can sum the target and thus count it.
     * Time complexity: 0(2^n) For every coin we have 2 options, either we include it or exclude it so if we think in terms of binary
     * Space complexity: O(h) where h is the height of the tree or maximum depth of recursion
     */
    /*
    private static long getWays(long sum, long[] c) {
        if (sum < 0 || c.length == 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }

        long countTotal = 0l;
        //System.out.printf("sum:%d, c[i]:%d, c:%s\n", sum, c[0], Arrays.toString(c));
        long count = getWays(sum - c[0], c) + getWays(sum, IntStream.range(1, c.length).mapToLong(k -> c[k]).toArray());
        countTotal += count;
        return countTotal;
    }
    */

    /**
     * Memoization method: Based on the inefficient we can determine that the solution tree has overlapping solutions
     * that we can store in a 2D array
     * Time complexity: O(n * m) sum times number of coins denominations
     * Space complexity: O(n * m) The extra space required for memoization
     */
    /*
    private static long[][] memo;
    private static long getWays(long sum, long[] c) {
        int nCoins = c.length;
        memo = new long[(int) sum + 1][nCoins + 1];
        for (int row = 0; row <= sum; row++)
            for (int col = 0; col <= nCoins; col++)
                memo[row][col] = -1l;
        return getWays(sum, c, c.length);
    }

    private static long getWays(long sum, long[] c, int nCoins) {
        if (sum < 0 || nCoins == 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        if (memo[(int)sum][nCoins] != -1)
            return memo[(int)sum][nCoins];

        memo[(int)sum][nCoins] = getWays(sum - c[nCoins - 1], c, nCoins) + getWays(sum, c, nCoins - 1);
        return memo[(int) sum][nCoins];
    }
    */
    
    /**
     * Tabulation method: Before calculation f(i) we have to compute all minimum counts for i
     * https://algorithms.tutorialhorizon.com/dynamic-programming-coin-change-problem/
     * Time complexity: O(n * m)
     * Space complexity: O(n * m)
     */
    private static long getWays(long sum, long[] c) {
        long[][] dp = new long[(int) sum + 1][c.length + 1];

        for (int i = 0; i <= c.length; i++) {
            dp[0][i] = 1l;
        }

        for (int i = 1; i <= (int) sum; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= (int) sum; i++) {
            for (int j = 1; j <= c.length; j++) {
                // check if the coin value is less than the amount needed
                if (c[j - 1] <= i) {
                    // reduce the amount by coin value and
					// use the subproblem solution (amount-v[i]) and
                    // add the solution from the top to it
                    dp[i][j] = dp[i][j - 1] + dp[i - (int) c[j - 1]][j];
                } else {
                    //copy previous value from top
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[(int) sum][c.length];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/dynamic_programming/CoinChangeProblem.txt");
        String[] nm = br.readLine().split("\\s+");
        int n = Integer.parseInt(nm[0]);
        @SuppressWarnings("unused")
        int m = Integer.parseInt(nm[1]);
        long[] c = Arrays.stream(br.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        long ways = getWays(n, c);
        System.out.println(ways);
        br.close();
    }
}