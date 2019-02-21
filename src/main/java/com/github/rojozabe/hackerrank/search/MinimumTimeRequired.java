package hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

public class MinimumTimeRequired {
    private static long minTime(long[] machines, long goal, int n) {
        long timeRequired = 0l;

        return timeRequired;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/search/MinimumTimeRequired.txt");
        String[] s = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(s[0]);
        long goal = Long.parseLong(s[1]);
        long[] machines = Arrays.stream(br.readLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
        System.out.println(minTime(machines, goal, n));
        br.close();
    }
}