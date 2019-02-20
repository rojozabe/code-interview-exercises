package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import utils.FileHelper;

public class Day1_DataTypes {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day1_DataTypes.txt"));
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
        System.out.println(i + scan.nextInt());
        System.out.println(d + scan.nextDouble());
        scan.nextLine();
        System.out.println(s + scan.nextLine());

        scan.close();
    }
}