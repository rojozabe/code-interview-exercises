package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * HackerRank Minimum Swaps 2
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * <p>
 * Given an array arr, calculate minimum swaps
 * 
 * @author rzapata
 */
public class MinSwaps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/exercises/arrays/MinSwaps.txt");        
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        
        //System.out.println(minSwaps(arr, n));
        System.out.println(minSwapsOpt(arr, n));
        br.close();
    }

    /**
     * Calculate minimum swaps needed to order an array. To avoid extra space complaxity like having a hashtable with the values
     * and the place they should be we can have an ordered array copied from the original, loop through the arr and compare if the
     * current value is where it should be, if it's not look for where it is and swap it.
     * <p>
     * Time complexity: O(nlog(n)) + O(n*(n - 1)) => O(n^2)
     * <p>
     * Space complexity: O(n)
     * 
     * @param arr Array of integer
     * @param n Size of the array
     * @return min swaps need to order the array
     */
    @SuppressWarnings("unused")
    private static int minSwaps(int[] arr, int n) {
        int nSwaps = 0;
        int[] arrOrd = Arrays.copyOf(arr, n);
        Arrays.sort(arrOrd);

        for (int i = 0; i < n; i++) {
            if(arr[i] != arrOrd[i]) {
                for(int j = i + 1; j < n; j++){
                    if(arr[j] == arrOrd[i]) {
                        swap(arr, i, j);
                        nSwaps++;
                        break;
                    }
                }
            }
        }

        return nSwaps;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * Calculate minimum swaps (Optimization proposition):
     * <p>
     * If a occupies b then b occupies c and finally x occupies a thus it forms a cycle, the most efficient way
     * to discover a cycle in a data structure is to use Depth First Search (dfs). So the ordering will need 
     * cycle length - 1 to rearrange the elements of the cycle into their correct positions.
     * <p>
     * This solution is tied of what was the constraints <code>1 <= arr[i] <= n</code>
     * <p>
     * Time complexity: O(nlog(n) + n) => O(nlog(n))
     * <p>
     * Space complexity: O(n)
     * 
     * @param arr Array of integer
     * @param n Size of the array
     * @return min swaps need to order the array
     */
    private static int minSwapsOpt(int[] arr, int n) {
        boolean[] visited = new boolean[n];
        int c = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i])
                c += dfs(arr, visited, i) - 1;
        }

        return c;
    }

    private static int dfs(int[] arr, boolean[] visited, int i) {
        visited[i] = true;
        int z = 1;

        if(!visited[arr[i] - 1])
            z += dfs(arr, visited, arr[i] - 1);

        return z;
    }
}