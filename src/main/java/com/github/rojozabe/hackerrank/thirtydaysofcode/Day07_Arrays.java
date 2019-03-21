package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

public class Day07_Arrays {
    private static void reverseArray(int[] a, int n) {
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            swap(a, i, n - 1 - i );
        }
    }

    private static void swap(int[] a, int indexa, int indexb) {
        int temp = a[indexa];
        a[indexa] = a[indexb];
        a[indexb] = temp;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day7_Arrays.txt");
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        reverseArray(a, n);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d%s", a[i], i < n - 1 ? " " : "");
        }
        System.out.println();
        br.close();
    }    
}