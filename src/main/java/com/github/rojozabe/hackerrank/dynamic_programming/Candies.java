package hackerrank.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * Candies
 * https://www.hackerrank.com/challenges/candies
 * <p>
 * DISCLAIMER: This is a greedy problem basically.
 * <p>
 * Essentially, as we need to distribute the candies at least as possible (minimum optimal) and
 * each child has a fixed position thus we mustn't sort them then we can make 2 passes:
 * <ul>
 * <li>Traverse the ratings left to right, every time we find a greater number at index <code>i</code>
 * we can add and aditional candy to give to the next child, otherwise if we find the next child to
 * have an equal or lower rating we reset the candy distribution to 1 so we guarantee the minimum
 * optimal distribution of candies.</li>
 * <li>Now, traverse from right to left, making sure that the if the next child has a greater rating
 * it receives the proper amount of candies that would be <code>distribution[i + 1] + 1</code>.</li>
 * </ul>
 * <p>
 * Time complexity: O(3 * n) -> O(n)
 * Space complexity: O(n)
 */
public class Candies {
    private static long candies(int n, int[] a) {
        long[] candies = new long[n];
        long distribution = 1l;
        candies[0] = distribution;

        for (int i = 1; i < n; i++) {
            distribution = (a[i] > a[i - 1]) ? distribution + 1 : 1l;
            candies[i] = distribution;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > a[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1l;
            }
        }
        
        return Arrays.stream(candies).sum();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/dynamic_programming/Candies.txt");
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }
        System.out.println(candies(n, a));
        br.close();
    }
}