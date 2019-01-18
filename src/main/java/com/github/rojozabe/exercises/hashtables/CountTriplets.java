package hashtables;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import utils.FileHelper;

/**
 * Count Triplets
 * https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * <p>
 * You are given an array and you need to find number of tripets of indices <i>(i, j, k)</i>
 * such that the elements at those indices are in geometric progression 
 * for a given common ratio <i>r</i> and <i>(i < j< k)</i>. 
 */
public class CountTriplets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/exercises/hashtables/CountTriplets.txt");
        String[] input = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(input[0]);
        long r = Long.parseLong(input[1]);
        long[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
        System.out.println(countTriplets(arr, r, n));

        br.close();
    }

    /**
     * To count triplets as we know r for each number in the array we can store it in a Map and check if <code>i - r^2</code>
     * and <code>i - (r^2 + r)</code> already exist in the map because a contrainst says <i>i < j < k</i> so one count would be
     * enoungh
     * <p>
     * Time complexity: O(n)
     * <p>
     * Space complexity: O(a)
     * 
     * @param arr input array
     * @param r triplets ratio
     * @param n size of the array
     * @return number of triplets counted
     */
    private static long countTriplets(long[] arr, long r, int n) {
        long triplets = 0l;
        HashMap<Long, Integer> countMap = new HashMap<Long, Integer>();

        // for (int i = 0; i < n; i++) {
        //     long third = arr[i];
        //     int thirdCount = countMap.getOrDefault(third, 0);
        //     //int secondCount = countMap.getOrDefault(Math.sqrt(third, 2), 0);
        //     //int firstCount = countMap.getOrDefault(Math.pow(third, 2) - third, 0);
        //     System.out.printf("thirdCount:%d, secondCount:%d, firstCount:%d\n", thirdCount, secondCount, firstCount);
        //     triplets += (thirdCount + 1) * secondCount * firstCount;

        //     countMap.put(third, ++thirdCount);

        //     for (Long number : countMap.keySet()){                
        //         int value = countMap.get(number);  
        //         System.out.println(number + " " + value);  
        //     } 
            
        // }

        return triplets;
    }
}