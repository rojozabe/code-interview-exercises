package hackerrank.thirtydaysofcode;

public class Day20_Sorting {
    public static void sort(int n, int[] a) {
        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {
            int numberOfSwaps = 0;
            
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    numberOfSwaps++;
                }
            }
            
            totalSwaps += numberOfSwaps;
            if (numberOfSwaps == 0) {
                break;
            }
        }

        System.out.printf("Array is sorted in %d swaps.\n", totalSwaps);
        System.out.printf("First Element: %d\n", a[0]);
        System.out.printf("Last Element: %d", a[n - 1]);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void main(String[] args) {
        //BufferedReader br = FileHelper.readFile(System.in);
        int n = 3;//Integer.parseInt(br.readLine().trim());
        int[] a = {1, 2, 3}; //Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        sort(n, a);
        //br.close();
    }
}