package hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * Minimum Time Required
 * https://www.hackerrank.com/challenges/minimum-time-required/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
 * <p>
 * This is a tricky problem where can be solved as the following approach: We might look for
 * the <code>lowestRate</code> and <code>highestRate</code> which are those machines that 
 * can produce the more and the least respectively. The we can calculate the <code>lowestBound</code>
 * and <code>highestBound</code>: The numerator is clearly the number of items we want to produce.
 * The denominator represents the number of machines at the given rate.
 * So if we divide the number of items we want with the rate at which we get items, we would get 
 * a bound of how many days it would take to reach our goal.
 * <p>
 * Now, at every iteration we check if we can complete our task in days by traversing the array 
 * and summing up the total items produced by each machine. 
 * If yes, then we move towards left else we move towards right.
 * <p>
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
public class MinimumTimeRequired {
    private static long minTime(long[] machines, long goal, int n) {
        long lowestRate = Integer.MAX_VALUE, highestRate = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            lowestRate = Math.min(lowestRate, machines[i]);
            highestRate = Math.max(highestRate, machines[i]);
        }
        
        long lowerBound = Double.valueOf(Math.ceil(goal / ((double) n / lowestRate))).longValue();
        long upperBound = Double.valueOf(Math.ceil(goal / ((double) n / highestRate))).longValue();
        
        while (lowerBound < upperBound) {
            long numDays = (lowerBound + upperBound) / 2;
            long total = getNumItems(machines, numDays);
            
            if (total >= goal) {
                upperBound = numDays;
            } else {
                lowerBound = numDays + 1;
            }
        }

        return lowerBound;
    }

    private static long getNumItems(long[] machines, long numDays) {
        long total = 0l;
        for (long machine : machines) {
            total += numDays / machine;
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/search/MinimumTimeRequired.txt");
        String[] s = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(s[0]);
        long goal = Long.parseLong(s[1]);
        long[] machines = Arrays.stream(br.readLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
        System.out.println(minTime(machines, goal, n));
        br.close();
    }
}