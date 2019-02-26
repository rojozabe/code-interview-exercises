package hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

import utils.FileHelper;

/**
 * Maximum Subarray Sum
 * https://www.hackerrank.com/challenges/maximum-subarray-sum/problem
 * <p>
 * Some mathematical pre reading and solutions pre readings
 * https://www.quora.com/What-is-the-logic-used-in-the-HackerRank-Maximise-Sum-problem
 * https://stackoverflow.com/questions/31113993/maximum-subarray-sum-modulo-m
 * <p>
 * After reading I will try summary everything, this problem is based on Modular arithmetic:
 * <ul>
 * <li><code>(a + b) % m</code></li>
 * <li><code>(a - b) % m</code></li>
 * </ul>
 * where <code>a = arr[i]</code> and <code>b = prefix[i - 1]</code> (previously calculated prefix),
 * starting at <code>prefix = arr[0]</code> when calculated all prefixes we can use Brute Force to
 * calculated the maximum possible sum but this will give us n^2 time complexity.
 * <p>
 * Using <code>TreeSet</code> that internally is composed by a red-black tree we can compare the prefix
 * just calculated with his <b>succesor</b> in the TreeSet using the function <code>(a - b) % m</code> 
 * to get the maximum result and store the ordered prefix just calculated. We need the successor because:
 * <code>(prefix[i] - prefix[j] + m) % m = prefix[i] - prefix[j] <= prefix[i]</code>.
 */

public class MaximumSubArraySum {
    private static long maximumSum(long[] a, long m, int n) {
        long[] prefixes = new long[n];
        TreeSet<Long> sortedPrefixes = new TreeSet<Long>();
        
        prefixes[0] = a[0] % m;
        sortedPrefixes.add(prefixes[0]);
        long result = prefixes[0];

        for (int i = 1; i < n; i++) {
            prefixes[i] = (a[i] + prefixes[i - 1]) % m;
            Long successor = sortedPrefixes.higher(prefixes[i]);
            if (successor != null) {
                result = Math.max(result, (prefixes[i] - successor + m) % m);
            } else {
                result = Math.max(result, prefixes[i]);
            }
            sortedPrefixes.add(prefixes[i]);
        }        

        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/search/MaximumSubArraySum.txt");
        int q = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < q; i++) {
            String[] s = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s[0]);
            long m = Long.parseLong(s[1]);
            long[] a = Arrays.stream(br.readLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            System.out.println(maximumSum(a, m, n));
        }
        br.close();
    }
}