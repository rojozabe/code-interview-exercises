package hackerrank.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * Max Array Sum
 * https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
 * <p>
 * Before approaching this solution read first:
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * <p>
 * Or this one with better explanation:
 * http://blog.gainlo.co/index.php/2016/12/02/uber-interview-question-maximum-sum-non-adjacent-elements/
 * <p>
 * First try to get the inefficient solution to the problem that will be:
 * <ul>
 * <li>When visited index 0, compare 0 with a[0] as there could be negative numbers</li>
 * <li>When index 1, compare a[1] with the comparison at index 0, again negative numbers</li>
 * <li>Else, as we need compare non-adjacent numbers we can approach the solution as 
 * <code>max(a[i - 1], a[i] + a[i - 2])</code>, <code>{a[i - 1], a[i] and a[i - 2]}</code> 
 * are non-adjacent numbers of index i</li>
 * </ul>
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaxArraySum {
    
    private static int maxSubsetSum(int[] a, int n) {
        int previousOne = 0, previousTwo = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans = Math.max(0, a[0]);
            } else if (i == 1) {
                ans = Math.max(ans, a[1]);
            } else {
                ans = Math.max(previousOne, a[i] + previousTwo);
            }
            
            previousTwo = previousOne;
            previousOne = ans;
        }
        return ans;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/dynamic_programming/MaxArraySum.txt");
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(maxSubsetSum(a, n));
        br.close();
    }
}