package hackerrank.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * Bubble Sort
 * https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 * <p>
 * Use bubble sort algorithm to sort elements in the input array
 */
public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/sorting/BubbleSort.txt");
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        br.close();
        countSwaps(a, n);
    }

    private static void countSwaps(int[] a, int n) {
        int numSwaps = 0;
        int lastElement = n - 1;
        boolean isSorted = false;

        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastElement; i++) {
                if(a[i] > a[i + 1]) {
                    isSorted = false;
                    swap(a, i, i + 1);
                    numSwaps++;
                }
            }
            lastElement--;
        }

        System.out.printf("Array is sorted in %d swaps.\n", numSwaps);
        System.out.printf("First Element: %d\nLast Element: %d", a[0], a[n - 1]);
    }

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}