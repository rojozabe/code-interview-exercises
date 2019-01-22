package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * Mark and Toys
 * https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 * <p>
 * Given a list of prices and an amount to spend, what is the maximum number of toys Mark can buy?
 */
public class MaximumToys {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/exercises/sorting/MaxToys.txt");
        String[] input = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] prices = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(maximumToys(prices, k, n));
        br.close();
    }

    /**
     * The hint every Greedy problem is looking for the maximum or minimum number of something to achieve a goal.
     * As every Greedy problem is to look for optimally local it usually requires sort set of elements first.
     * <p>
     * Time complexity: O(nlogn + n) => O(nlogn)
     * <p>
     * Space complexity: O(1)
     */
    private static int maximumToys(int[] prices, int k, int n) {
        int toys = 0, spent = 0;
        Arrays.sort(prices);
        for (int i = 0; i < n; i++) {
            spent += prices[i];
            if(spent > k) break;
            toys++;
        }
        return toys;
    }
}