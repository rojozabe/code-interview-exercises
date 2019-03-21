package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

public class Day06_LetsReview {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day6_LetsReview.txt");
        int t = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < t; i++) {
            String s = br.readLine().trim();
            //evens
            for (int j = 0; j < s.length(); j++) {
                if (j % 2 == 0) System.out.printf("%c", s.charAt(j));                
            }
            System.out.print(" ");
            //odds
            for (int j = 0; j < s.length(); j++) {
                if ((j + 1) % 2 == 0) System.out.printf("%c", s.charAt(j));                
            }
            System.out.println();
        }
        br.close();
    }
}