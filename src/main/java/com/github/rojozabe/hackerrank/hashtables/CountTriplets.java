package hackerrank.hashtables;

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
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/hashtables/CountTriplets.txt");
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
     * enoungh. To achieve O(n) there must be 2 maps: One to hold count of needed values after current to complete and Two
     * to hold count of needed values to complete triplet.
     * <p>
     * Time complexity: O(n)
     * <p>
     * Space complexity: O(2*a)
     * 
     * @param arr input array
     * @param r triplets ratio
     * @param n size of the array
     * @return number of triplets counted
     */
    private static long countTriplets(long[] arr, long r, int n) {
        long triplets = 0l;
        HashMap<Long, Long> mp2 = new HashMap<Long, Long>();
        HashMap<Long, Long> mp3 = new HashMap<Long, Long>();

        for (int i = 0; i < n; i++) {
            triplets += mp3.getOrDefault(arr[i], 0l);
            mp3.put(arr[i] * r, mp3.getOrDefault(arr[i] * r, 0l) + mp2.getOrDefault(arr[i], 0l));
            mp2.put(arr[i] * r, mp2.getOrDefault(arr[i] * r, 0l) + 1);
        }        

        return triplets;
    }
}