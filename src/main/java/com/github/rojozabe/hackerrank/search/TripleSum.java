package hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import utils.FileHelper;

/**
 * Triple Sum
 * https://www.hackerrank.com/challenges/triple-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
 * <p>
 * There are some tweaks we need to do in this problem before solving it: 
 * <ol>
 * <li>Arrays a and c must be ordered and get distinct numbers.</li>
 * <li>When iterating through b get distinct numbers as well.</li>
 * <li>Each iteration in b we need to look for the lower or equal closest number in a and c.
 * We can use <code>Arrays.binarySearch for that taking care of insertion point when the exact b[i]
 * is not found in any of the arrays.</code></li>
 * <li>We finally sum index of <code>closest index a + 1 times closest index b + 1</code> 
 * which are the permutations of triplets allowed based on b[i]</li>
 * </ol>
 * <p>
 * Time complexity: O(aloga + a + clogc + c + b * (loga + logc)) -> O(nlogn) which n = max(a,b,c)
 * Space complexity: O(a + b + c)
 */
public class TripleSum {
    private static long triplets(int[] a, int[] b, int[] c) {
        long triplets = 0l;
        Set<Integer> distinctb = new HashSet<Integer>();
        Arrays.sort(a);
        int[] distincta = Arrays.stream(a).distinct().toArray();
        Arrays.sort(c);
        int[] distinctc = Arrays.stream(c).distinct().toArray();

        for (int i = 0; i < b.length; i++) {
            if (!distinctb.add(b[i])) {
                continue;
            }
            int indexa = findLowerClosestIndex(distincta, b[i]);
            int indexc = findLowerClosestIndex(distinctc, b[i]);            
            triplets += ((long) indexa + 1) * ((long) indexc + 1);            
        }

        return triplets;
    }

    /**
     * Find the left (lower) closest index from the specified target if the target is not found
     * in the array. As Java doc implies when the element is not found in the array it will return
     * (-(insertion point) - 1). The insertion point is defined as the point at which the key 
     * would be inserted into the array, so we return -index - 2 which will be the lower closest.
     * @param a
     * @param target
     * @return left (lower) closest index
     */
    private static int findLowerClosestIndex(int[] a, int target) {
        int index = Arrays.binarySearch(a, target);
        
        if (index >= 0) {
            return index;
        } else {
            return -index - 2;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/search/TripleSum.txt");
        String[] s = br.readLine().trim().split("\\s+");
        @SuppressWarnings("unused")
        int lena = Integer.parseInt(s[0]);
        @SuppressWarnings("unused")
        int lenb = Integer.parseInt(s[1]);
        @SuppressWarnings("unused")
        int lenc = Integer.parseInt(s[2]);
        int[] a = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] c = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println(triplets(a, b, c));
        br.close();
    }
}