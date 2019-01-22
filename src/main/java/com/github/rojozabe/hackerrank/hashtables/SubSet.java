package hackerrank.hashtables;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import utils.FileHelper;

/**
 * Ransom note
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * <p>
 * Given two arrays of String, magazine and note, check if the note can be formed using the magazine
 * 
 * @author rzapata
 */
public class SubSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/hashtables/SubSet.txt");
        String[] input = br.readLine().trim().split("\\s+");
        @SuppressWarnings("unused")
        int m = Integer.parseInt(input[0]);
        @SuppressWarnings("unused")
        int n = Integer.parseInt(input[1]);
        String[] magazine = br.readLine().trim().split("\\s+");
        String[] note = br.readLine().trim().split("\\s+");
        isSubSet(magazine, note);

        br.close();
    }

    /**
     * Checks if the note can be formed using the magazine
     * <p>
     * One easy way to do it is store the magazine array of words in a hashmap
     * (because in magazine we can have repeated words so we need to count each word), 
     * for each note word look it up in the magazine set, if the word exist in the magazine
     * remove it and continue until all note words have been checked.
     * <p>
     * Time complexity: O(m + n).
     * <p>
     * Space complexity: O(m).
     * 
     * @param magazine
     * @param note
     * @return if the note can be formed using the magazine
     */
    private static void isSubSet(String[] magazine, String[] note) {
        HashMap<String, Integer> magazineMap = new HashMap<String, Integer>();

        for(String m : magazine) {
            if(magazineMap.containsKey(m)){
                magazineMap.put(m, magazineMap.get(m) + 1);
            } else {
                magazineMap.put(m, 1);
            }
        }

        for(String n : note) {
            if(!magazineMap.containsKey(n)) {
                System.out.println("No");
                return;
            } else if(magazineMap.get(n) == 1){
                magazineMap.remove(n);
            } else {
                magazineMap.put(n, magazineMap.get(n) - 1);
            }
        }

        System.out.println("Yes");
    }
}