package hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import utils.FileHelper;

/**
 * Pairs
 * https://www.hackerrank.com/challenges/pairs/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
 * <p>
 * Double pointer problem just need to traverse the array and look for those pairs who satisfies 2 conditions:
 * <ul>
 * <li><code>i = k + j</code></li>
 * <li><code>j = i - k</code></li>
 * </ul>
 * We can pre store the values in a hash set as the problem implies the values will be unique and iterate thru the array
 * looking for a value in the set.
 * <p>
 * Time complexity: O(n) -> 1 method one pass, 2 method 2 passes thru the array.
 * Space complexity: O(n) -> hash set of the array
 */
public class Pairs {
    private static int pairs(int k, int[] arr, int n) {
        /**
         * Method 1: using a hash set iterating through the array
        */ 
        /*int pairs = 0;
        Set<Integer> arrSet = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            int complement = k + arr[i];
            if (arrSet.contains(complement)) {
                pairs++;
            }

            complement = arr[i] - k;
            if (arrSet.contains(complement)) {
                pairs++;
            }
            
            arrSet.add(arr[i]);    
        }

        return pairs;*/

        /**
         * Method 2: Java 8 - 2 lines code
         */
        Set<Integer> arrSet = new HashSet<Integer>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        return (int) arrSet.stream().filter(x -> arrSet.contains(x + k)).count();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/search/Pairs.txt");
        String[] s = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(pairs(k, arr, n));
        br.close();
    }
}