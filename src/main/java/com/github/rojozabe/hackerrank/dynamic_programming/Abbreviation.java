package hackerrank.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

/**
 * Abbreviation
 * https://www.hackerrank.com/challenges/abbr/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
 * <p>
 * Problem solved with bottom-up approach:
 * <ul>
 * <li>Base case, if both array is empty we finish traversing both strings <code>return true</code></li>
 * <li>Initializing first row depending if char a is upper case, if it's lower case it can be removed as b is empty</li>
 * <li>Traversing the matrix chain first we check if both characters at index <code>b[i], a[j]</code> are equal</li>
 * <li>Then if <code>b[i] == uppercase(a[j])</code> we can get previous character comparison or just previous a[j],
 * as we can delete a[j] as it is lowercase</li>
 * <li>a[j] is uppercase and there is no more characters in b left or not equals to b, then this comparison is false</li>
 * <li>Eventually, get previous a[j]</li>
 * </ul>
 * The result will be the result traversing both strings, basically the core elements are steps 4 and 5 above where the case 
 * there is no more b's and getting previous a as it handles the corner case that lowercase characters in a can be deleted.
 * <p>
 * Time complexity: O(a * b)
 * Space complexity: O(a * b)
 */
public class Abbreviation {
    private static String abbreviation(String a, String b) {        
        boolean[][] matrixChain = new boolean[b.length() + 1][a.length() + 1];
        matrixChain[0][0] = true;

        for (int i = 0; i < a.length(); i++) {
            matrixChain[0][i + 1] = !Character.isUpperCase(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                char ca = a.charAt(j); char cb = b.charAt(i);

                if (ca == cb) {
                    matrixChain[i + 1][j + 1] = matrixChain[i][j];
                } else if (Character.toUpperCase(ca) == cb) {
                    matrixChain[i + 1][j + 1] = matrixChain[i][j] || matrixChain[i + 1][j];
                } else if (Character.isUpperCase(ca)) {
                    matrixChain[i + 1][j + 1] = false;
                } else {
                    matrixChain[i + 1][j + 1] = matrixChain[i + 1][j];
                }
            }
        }

        return matrixChain[b.length()][a.length()] ? "YES" : "NO";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/dynamic_programming/Abbreviation.txt");
        int q = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < q; i++) {
            String a = br.readLine().trim();
            String b = br.readLine().trim();
            System.out.println(abbreviation(a, b));
        }
        br.close();
    }
}