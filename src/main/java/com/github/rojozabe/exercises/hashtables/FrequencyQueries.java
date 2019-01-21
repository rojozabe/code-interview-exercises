package hashtables;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.FileHelper;

/**
 * Frequency Queries
 * https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * <p>
 * It must return an array of integers where each element is a 1 if there is at
 * least one element value with the queried number of occurrences in the current
 * array, or 0 if there is not.
 */
public class FrequencyQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/exercises/hashtables/FrequencyQueries.txt");
        int q = Integer.parseInt(br.readLine().trim());
        int[][] queries = new int[q][2]; 
        for (int i = 0; i < q; i++) {
            String[] input = br.readLine().trim().split("\\s+");
            queries[i][0] = Integer.parseInt(input[0]);
            queries[i][1] = Integer.parseInt(input[1]);
        }

        freqQuery(queries, q).forEach(f -> {
            System.out.println(f);
        });
        br.close();
    }

    /**
     * We can use two hashmaps. One to store the frequencies and the other to store the frequency of the frequencies.
     * <p>
     * Time complexity: O(q log(q)) - log(q) because when checking frequencies
     * <p>
     * Space complexity: O(q + R + f) where q is the number of queries, R 10^9 possible numbers and f number of
     * distint possible frequencies
     * 
     * @param queries data structure with the queries
     * @param q number of queries to do
     * @return List of frequencies requested by query
     */
    private static List<Integer> freqQuery(int[][] queries, int q) {
        Map<Integer, Integer> countNumber = new HashMap<Integer, Integer>();
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        List<Integer> output = new ArrayList<Integer>();

        for (int i = 0; i < q; i++) {
            int count = 0;
            int value = queries[i][1];

            switch (queries[i][0]) {
                case 1:
                    count = countNumber.getOrDefault(value, 0);
                    checkFrequency(freq, count);
                    freq.put(count + 1, freq.getOrDefault(count + 1, 0) + 1);
                    countNumber.put(value, ++count);
                    break;
                case 2:                    
                    count = countNumber.getOrDefault(value, 0);
                    checkFrequency(freq, count);
                    if(count > 1){
                        freq.put(count - 1, freq.getOrDefault(count - 1, 0) + 1);
                        countNumber.put(value, --count);
                    } else {
                        countNumber.remove(value);
                    }
                    break;                
                case 3:
                    output.add((freq.getOrDefault(value, 0) > 0) ? 1 : 0);
                    break;
            }
        }
        
        return output;
    }    

    private static void checkFrequency(Map<Integer, Integer> freq, int count) {
        if(freq.containsKey(count)) {
            freq.put(count, freq.get(count) - 1);
            if(freq.get(count) == 0)
                freq.remove(count);
        }
        
    }
}