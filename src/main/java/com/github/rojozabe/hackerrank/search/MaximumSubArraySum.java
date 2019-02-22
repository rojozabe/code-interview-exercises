package hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * Maximum Subarray Sum
 * https://www.hackerrank.com/challenges/maximum-subarray-sum/problem
 * <p>
 * https://www.quora.com/What-is-the-logic-used-in-the-HackerRank-Maximise-Sum-problem
 */

public class MaximumSubArraySum {
    private static long maximumSum(long[] a, long m, int n) {
        
        return 0l;
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