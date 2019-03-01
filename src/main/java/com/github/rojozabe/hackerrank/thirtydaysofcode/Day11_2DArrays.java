package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

public class Day11_2DArrays {
    private static int largestHourglass(int[][] a) {
        int maxHourglass = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                maxHourglass = Math.max(maxHourglass, getHourglass(a, i, j));
            }
        }
        return maxHourglass;
    }

    private static int getHourglass(int[][] a, int i, int j) {
        int hourglass = 0;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                if (k == i + 1 && (l == j || l == j + 2)) continue;
                hourglass += a[k][l];
            }
        }
        
        return hourglass;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day11_2DArrays.txt");
        int[][] a = new int[6][6];
        for (int i = 0; i < 6; i++) {
            a[i] = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(largestHourglass(a));
        br.close();;
    }
}