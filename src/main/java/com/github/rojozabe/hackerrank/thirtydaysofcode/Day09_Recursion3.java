package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

public class Day09_Recursion3 {
    private static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    
    public static void main(String[] main) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day9_Recursion3.txt");
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(factorial(n));
        br.close();
    }
}