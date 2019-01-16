package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * HackerRank New Year Chaos
 * https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * <p>
 * Given an array q, determine the min number of swaps.
 * 
 * @author rzapata
 */
public class MinSwaps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/exercises/arrays/MinSwaps.txt");
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] q = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            calculateSwaps(q, n);
        }
		br.close();
    }

    /**
     * Calculates the minimum swaps done for each element of the array according to its number.
     * If the element has more than 2 swaps from its initial place it will be return an invalid state.
     * <p>
     * Hint: The problem says has bribed is equal to the number of people on the right of that person.
     * All you need to do is to count the number of people who overtake a person (to the right).
     * <p>
     * Time complexity: O(n)
     * Space complexity:  O(1)
     * 
     * @param q Array of integers
     * @param n Size of the array
     * @return minimum swaps
     */
    private static void calculateSwaps(int[] q, int n) {
        int swaps = 0;

        for (int i = n - 1; i >= 0; i--) {
            if(q[i] - (i + 1) > 2){
                System.out.println("Too chaotic");
                return;
            }                
            
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if(q[j] > q[i])
                    swaps++;
            }            
        }
        System.out.println(swaps);
    }
}
