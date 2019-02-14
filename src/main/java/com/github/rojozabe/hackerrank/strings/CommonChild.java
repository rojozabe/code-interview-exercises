package hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

/**
 * Common Child
 * https://www.hackerrank.com/challenges/common-child/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 * <p>
 * A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string.
 * Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both?
 * <p>
 * For example, ABCD and ABDC have two children with maximum length 3, ABC and ABD.
 * They can be formed by eliminating either the D or C from both strings.
 * Note that we will not consider ABCD as a common child because we can't rearrange characters and ABCD != ABDC.
 * <p>
 * Longest common subsequence problem, this is one of a classical dynamic programming problem: 
 * <ul>
 * <li>Wikipedia formal definition: https://en.wikipedia.org/wiki/Longest_common_subsequence_problem</li>
 * <li>Geeksforgeeks implementation: https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/</li>
 * </ul>
 * 
 * Time complexity:
 * Using recursive naive method, time: O(2^x), space: O(x) being x = min(m, n)
 * Using DP optimzed method, time: O(m * n), space: O(m * n)
 */
public class CommonChild {
    private static int commonChild(String s1, String s2) {
        return lcs(s1, s2, s1.length(), s2.length());
    }

    private static int lcs(String s1, String s2, int m, int n) {
        int[][] LCS = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    LCS[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    LCS[i][j] = 1 + LCS[i - 1][j - 1];
                else
                    LCS[i][j] = Math.max(LCS[i][j - 1], LCS[i - 1][j]);
            }
        }

        return LCS[m][n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/strings/CommonChild.txt");
        String s1 = br.readLine();
        String s2 = br.readLine();
        int result = commonChild(s1, s2);
        System.out.println(result);
        br.close();
    }
}