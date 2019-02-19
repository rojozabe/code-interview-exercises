package hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import utils.FileHelper;

/**
 * Hash Tables: Ice Cream Parlor
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
 * <p>
 * Two Sum problem: https://leetcode.com/articles/two-sum
 * We can use a hash map to store the values and the index of that value 
 * and make one pass to the input array. When it's found the value
 * <code>money - cost[i]</code> then return the current index and the index
 * beloging to the value found in the hash map.
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(n)
 * <p>
 * DISCLAIMER: There is another approach to solve this using binary search
 * but takes nlogn time and it's more verbose.
 */
public class IceCreamParlor {

    private static void whatFlavors(int[] cost, int money, int n) {
        int firstIndex = -1, secondIndex = -1;
        Map<Integer, Integer> distinctCosts = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (distinctCosts.containsKey(money - cost[i])) {
                firstIndex = i;
                secondIndex = distinctCosts.get(money - cost[i]);
            }
            distinctCosts.put(cost[i], i);
        }
        
        System.out.printf("%d %d\n", Math.min(firstIndex, secondIndex) + 1, Math.max(firstIndex, secondIndex) + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/search/IceCreamParlor.txt");
        int t = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < t; i++) {
            int money = Integer.parseInt(br.readLine().trim());
            int n = Integer.parseInt(br.readLine().trim());
            int[] cost = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            whatFlavors(cost, money, n);
        }
        br.close();
    }
}