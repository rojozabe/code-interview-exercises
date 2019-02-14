package hackerrank.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * Minimum Absolute Difference in an Array
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 * 
 * <p>
 * As every other greedy algorithm we need to look for the local optimum solution:
 * <ol>
 * <li>Sort the input array</li>
 * <li>Calculate |arr[i] - arr[i+1]| and check if it's the minimum</li>
 * <li>Iterate the array checking step 2</li>
 * </ol>
 * 
 * The values that are closest to one another are the ones that will have the least difference.
 * After sorting I know that for any value i, the values at i - 1 and i + 1 are closest to i.
 * Therefore, I don't have to consider all pairs that contain i, I can just consider the ones that 
 * are going to yield the least difference, i's neighbors. Everyone else is farther away.
 * 
 * Time complexity: O(n logn)
 * Space complexity: O(1)
 */
public class MinimumAbsoluteDifference {
    private static int minimumAbsoluteDifference(int[] arr, int n) {
        int minDiff = Integer.MAX_VALUE;
        
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[i + 1]));
        }

        return minDiff;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/greedy/MinimumAbsoluteDifference.txt");
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(minimumAbsoluteDifference(arr, n));
        br.close();
    }
}