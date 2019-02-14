package hackerrank.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import utils.FileHelper;

/**
 * Greedy Florist
 * https://www.hackerrank.com/challenges/greedy-florist/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 * <p>
 * Given the size of the group of friends,the number of flowers they want to purchase and the original prices of the flowers, 
 * determine the minimum cost to purchase all of the flowers.
 * <p>
 * This problem is a bit tricky to see but easy to implement just write an example down in paper.
 * We first sort in descending order the input array and then we optimize the order in which we 
 * distribute the flowers. E.g.: If we have 5 flowers and 3 friends then then we can distribute 
 * the most 3 expensives flowers and then the other 2 remaining flowers will be multiplied by 2.
 * <p>
 * Time complexity: O(n logn)
 * Space complexity: O(1)
 */
public class GreedyFlorist {
    private static int getMinimumCost(int k, Integer[] prices, int n) {
        int cost = 0;
        Arrays.sort(prices, Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            cost += prices[i] * (i / k + 1);    
        }

        return cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/greedy/GreedyFlorist.txt");
        String[] s = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        Integer[] prices = Arrays.stream(br.readLine().trim().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList()).toArray(new Integer[n]);
        
        System.out.println(getMinimumCost(k, prices, n));
        br.close();
    }
}