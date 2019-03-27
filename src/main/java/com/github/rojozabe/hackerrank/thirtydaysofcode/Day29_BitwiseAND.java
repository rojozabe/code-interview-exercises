package hackerrank.thirtydaysofcode;

//import java.io.BufferedReader;
//import java.io.IOException;

//import utils.FileHelper;

/**
 * Day 29: Bitwise AND (I think it is worthy to document the solution)
 * https://www.hackerrank.com/challenges/30-bitwise-and/problem
 * <p>
 * Explanation of the problem:
 * Solution based from: https://www.geeksforgeeks.org/maximum-value-pair-array/
 * Most significant bit: https://en.wikipedia.org/wiki/Bit_numbering
 * <p>
 * We start from the MSB and check whether we have minimum of two elements of array 
 * having set value. If yes then that MSB will be part of our solution and be added 
 * to result otherwise we will discard that bit. Similary, iterating from MSB to LSB 
 * (32 to 1) for bit position we can easily check which bit will be part of our solution 
 * and will keep adding all such bits to our solution.
 * <p>
 * We just need to make a little tweak: As we have a boundary K that is the maximum
 * allowed number we just have to check that the result don't overflow the boundary.
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Day29_BitwiseAND {
    private static int maximumBitwiseAND(int n, int k) {
        int result = 0;
        
        for (int bit = 31; bit >= 0; bit--) {
            int count = checkMSB(result | 1 << bit, n);

            if (count >= 2 && (result | 1 << bit) < k) {
                result |= 1 << bit;
            }
        }

        return result;
    }

    private static int checkMSB(int pattern, int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & pattern) == pattern) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        //BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day28_Regex_Patterns_Databases.txt");
        int T = 3; //Integer.parseInt(br.readLine().trim());
        String[] input = { "5 2", "8 5", "2 2" };
        for (int i = 0; i < T; i++) {
            String[] nk = input[i].split("\\s+");//br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            System.out.println(maximumBitwiseAND(n, k));
        }
        
        //br.close();
    }
}