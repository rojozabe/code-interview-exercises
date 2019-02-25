package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

public class Day5_Loops {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day5_Loops.txt");
        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", n, i, n * i);
        }
        br.close();
    }
}