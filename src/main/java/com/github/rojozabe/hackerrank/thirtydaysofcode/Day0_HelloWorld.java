package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

public class Day0_HelloWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day0_HelloWorld.txt");
        String s = br.readLine().trim();
        System.out.printf("Hello, World.\n%s", s);
        br.close();
    }
}