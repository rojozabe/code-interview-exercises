package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

public class Day14_Scope {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day14_Scope.txt");
        @SuppressWarnings("unused")
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Difference difference = new Difference(a);
        difference.computeDifference();
        System.out.print(difference.maximumDifference);
        br.close();
    }
}

class Difference {
    private int[] elements;
    public int maximumDifference;

    Difference(int[] a) {
        elements = a;
    }

    public void computeDifference() {
        if (elements.length == 1) {
            maximumDifference = elements[0];
            return;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < elements.length; i++) {
            min = Math.min(min, elements[i]);
            max = Math.max(max, elements[i]);
        }
        maximumDifference = max - min;
    }
} 