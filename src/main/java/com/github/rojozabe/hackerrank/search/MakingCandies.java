package hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

/**
 * Making Candies
 * https://www.hackerrank.com/challenges/making-candies/problem
 * <p>
 * Tricky problem statement. We just not only need the minimum iterations will be required if 
 * we increase workforce required but also get estimation for the case when we first increase 
 * workfoce and then increase candies (for example sample case #1).
 * <p>
 * If it is better not to increase workforce, return estimation + number of already taken steps.
 * <p>
 * Time complexity: O(sqrt(n)) Observe that it's more efficient to keep the number of workers 
 *                  and machines equal. Then the number of candies you buy after k purchases is 
 *                  quadratic in k. Thus after O(sqrt(n)) purchases the number of candies you're 
 *                  gonna make in one pass is Omega(n) and you're gonna make the rest of required 
 *                  candies in a constant number of passes.
 * Space complexity: O(1)
 */
public class MakingCandies {
    private static long minimumPasses(long m, long w, long p, long n) {
        long passes = 0l, candies = 0l;

        if (m < w) {
            long temp = w;
            w = m;
            m = temp;
        }

        while (true) {
            // estimate how much iterations are required to purchase new candies with current resources
            long estimateIterations = getMinIterations(m, w, n - candies);
            if (estimateIterations <= 1) 
                return passes + estimateIterations;
                        
            // first get amount of iterations required to increase resources
            long minIterations = (p - candies) / m / w;
            if(minIterations * m * w + minIterations < p)
                minIterations++;

            long resourcesToAdd = (candies + m * w * minIterations) / p, newM = 0l, newW = 0l;
            // get new number of machines and workers, taking into account that m always > w
            if (m - w >= resourcesToAdd) {
                newM = m;
                newW = w + resourcesToAdd;                
            } else {                
                newM = (m + w + resourcesToAdd) / 2 + (m + w + resourcesToAdd) % 2;
                newW = (m + w + resourcesToAdd) / 2;                
            }

            long candiesAfterIncrement = candies + minIterations * m * w - resourcesToAdd * p;

            // get estimation for the case when we first increase workfoce and then purchase candies
            long estimateIncrease = getMinIterations(newM, newW, n - candiesAfterIncrement) + minIterations;

            // if it is better not to increase current resources, return estimation + number of already taken passes
            if(estimateIterations < estimateIncrease)
                return passes + estimateIterations;

            passes += minIterations;
            candies = candiesAfterIncrement;
            m = newM;
            w = newW;
        }
    }

    private static long getMinIterations(long m, long w, long candiesRequired) {
        long nIterations = 1l;
        if (w < (double) candiesRequired / m) {
            nIterations = candiesRequired / m / w;
            if (nIterations * m * w < candiesRequired)
                nIterations++;
        }

        return nIterations;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/search/MakingCandies.txt");
        String[] s = br.readLine().trim().split("\\s+");
        long m = Long.parseLong(s[0]);
        long w = Long.parseLong(s[1]);
        long p = Long.parseLong(s[2]);
        long n = Long.parseLong(s[3]);
        System.out.println(minimumPasses(m, w, p, n));
        br.close();
    }
}