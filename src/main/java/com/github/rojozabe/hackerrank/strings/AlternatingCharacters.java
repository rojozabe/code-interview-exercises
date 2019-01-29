package hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

/**
 * Alternating Characters
 * https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 * <p>
 * You are given a string containing characters A and B only.
 * Your task is to change it into a string such that there are no matching adjacent characters.
 * To do this, you are allowed to delete zero or more characters in the string.
 * Your task is to find the minimum number of required deletions.
 */
public class AlternatingCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/strings/AlternatingCharacters.txt");
        int q = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < q; i++) {
            System.out.println(alternatingCharacters(br.readLine().trim()));
        }
        br.close();
    }

    /**
     * As we only have two different characters in the string A or B we can have a previous character variable,
     * if <code>current == previous</code> then current should be deleted
     * <p>
     * Time complexity: O(s) per q
     * <p>
     * Space complexity: O(1)
     * @param s
     * @return number of deletions needed to have alternating characters
     */
    private static int alternatingCharacters(String s) {
        int deletions = 0;
        char prevCharacter = '\0';
        for (char c : s.toCharArray()) {
            if(prevCharacter == c) {
                deletions++;
            }
            prevCharacter = c;
        }
        return deletions;
    }
}