package hackerrank.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

/**
 * Merge Sort: Counting Inversions
 * https://www.hackerrank.com/challenges/ctci-merge-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 * <p>
 * Return an integer representing the number of inversions required to sort the array.
 * <p>
 * This problem is about using merge sort: Using rescursion to get halves of the array, at each recursion level we sort left half, then right half
 * and merge the two sorted halves together.
 * In the mergeHalves recursion method we can identify an inversion when arr[i] > arr[i+1] and we swap arr[i] <-> arr[i+1] until the condition breaks.
 * The key here is when arr[leftIndex] > arr[rightIndex] we count how many times does the number has to swap to get to the desired sorted position.
 * This indirectly shifts the element to the left by the number of elements remaining in the first array or left side in our solution.
 * <p>
 * Time complexity: O(nlogn) -> We divide the array by 2 for each level of recursion
 * <p>
 * Space complexity: O(n) -> We maintain a temp array
 */
public class CountingInversions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/sorting/CountingInversions.txt");
        int d = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < d; i++) {
            @SuppressWarnings("unused")
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(countInversions(arr));
        }
        br.close();
    }

    private static long countInversions(int[] arr) {
        return mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static long mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd)
            return 0l;

        long sortTimes = 0l;
        int mid = (leftStart + rightEnd) / 2;
        sortTimes += mergeSort(arr, temp, leftStart, mid);
        sortTimes += mergeSort(arr, temp, mid + 1, rightEnd);
        sortTimes += mergeHalves(arr, temp, leftStart, rightEnd);

        return sortTimes;
    }

    private static long mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        long inversions = 0l;
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1; //total values we're copying at this level

        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int index = leftStart; //start index where temp array will start copying elements

        while(leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if(arr[leftIndex] <= arr[rightIndex]) {
                temp[index] = arr[leftIndex++];                
            } else {
                temp[index] = arr[rightIndex++];
                inversions += leftEnd - leftIndex + 1; //how many times does the number has to swap to get to the desired sorted position
            }
            index++;
        }

        //either left or right pointer is at end, so one of these two lines or none will copy remaining elements
        System.arraycopy(arr, leftIndex, temp, index, leftEnd - leftIndex + 1); // copy the remaining elements of the left side
        System.arraycopy(arr, rightIndex, temp, index, rightEnd - rightIndex + 1); // copy the remaining elements of the right side
        System.arraycopy(temp, leftStart, arr, leftStart, size);//We copy temp back to our source arr
        return inversions;
    }
}