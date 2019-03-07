package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

class Calculator {
    public static int power(int n, int p) {
        if (n < 0 || p < 0) throw new NumberFormatException("n and p should be non-negative");
        
        return (int) Math.pow(n, p);
    }
}

public class Day17_MoreExceptions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day17_MoreExceptions.txt");
        int T = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s[0]);
            int p = Integer.parseInt(s[1]);
            try {
                System.out.println(Calculator.power(n, p));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            
        }
        br.close();
    }
}