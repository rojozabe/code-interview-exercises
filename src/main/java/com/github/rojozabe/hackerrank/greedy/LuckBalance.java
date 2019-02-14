package hackerrank.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * Luck Balance
 * https://www.hackerrank.com/challenges/luck-balance/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 * <p>
 * Maximize the luck counter based on the <code>k</code> important contests that can be discarded.
 * We can sort the matrix by luck and have a counter to count the current important contests lost,
 * when the counter reaches <code>k</code> we're forced to lose luck (win contest). At least we're
 * losing the least luck.
 * 
 * Time complexity: O(n logn)
 * Space complexity: O(1)
 */
public class LuckBalance {
    private static int luckBalance(int k, int[][] contests, int n) {
        int importantContestsCounter = 0, luck = 0;
        
        Arrays.sort(contests, (a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {
            if (contests[i][1] == 1) {
                if (importantContestsCounter >= k) {
                    luck -= contests[i][0];
                } else {
                    luck += contests[i][0];
                    importantContestsCounter++;
                }
            } else {
                luck += contests[i][0];
            }
        }

        return luck;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/greedy/LuckBalance.txt");
        String[] s = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            s = br.readLine().trim().split("\\s+");
            contests[i][0] = Integer.parseInt(s[0]);
            contests[i][1] = Integer.parseInt(s[1]);
        }
        System.out.println(luckBalance(k, contests, n));
        br.close();
    }
}