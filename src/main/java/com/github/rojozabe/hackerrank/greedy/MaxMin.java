package hackerrank.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * Max Min
 * https://www.hackerrank.com/challenges/angry-children/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 * <p>
 * Very similar solution approach as Greedy Florist problem. The solution goes as follows:
 * <ol>
 * <li>sort: The reason is we are trying to calculate the smallest value for max-min.
 * That means that the smallest value for max-min will always have to be between consecutive array values.
 * for k = 2 (groups of 2 numbers), taking 8 and 2 would yield 6, while taking 3 and 2 would yield 1, so, 
 * as you can see, the best and most efficient way to find the smallest max-min is to do it with consecutive numbers.</li>
 * <li>Find the max-min of each subgroup</li>
 * <li>compare the result of each subgroup with the fairness, keep the minimum found</li>
 * </ol>
 */
public class MaxMin {
    private static int maxMin(int k, int[] arr, int n) {
        int unfairness = Integer.MAX_VALUE;
        Arrays.sort(arr);
        
        for (int i = 0; i < n - (k - 1); i++) {
            unfairness = Math.min(unfairness, arr[i + (k - 1)] - arr[i]);
            if (unfairness == 0) break;
        }

        return unfairness;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/greedy/MaxMin.txt");
        int n = Integer.parseInt(br.readLine().trim());
        int k = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine().trim());
        
        System.out.println(maxMin(k, arr, n));
        br.close();
    }
}