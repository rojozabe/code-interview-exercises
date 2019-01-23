package hackerrank.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.FileHelper;

/**
 * Fraudulent Activity Notifications
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 * <p>
 * Given the number of trailing days d and a client's total daily expenditures for a period of n days,
 * find and print the number of times the client will receive a notification over all n days.
 */
public class ActivityNotifications {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/sorting/ActivityNotifications.txt");
        String[] s = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        int[] expenditure = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(activityNotifications(expenditure, d, n));
        br.close();
    }

    /**
     * To achieve iterate through the array once we need a way to keep the iterated amount sorted in another array,
     * that way we can determine the median more efficiently.
     * <p>
     * Time complexity: O(n logn)
     * <p>
     * Space complexity: O(a)
     * 
     * @param expenditure input array
     * @param d lookback days for median spending
     * @param n size of the input array
     * @return number of notifications the client will receive according to his/her expenses from d day
     */
    private static int activityNotifications(int[] expenditure, int d, int n) {
        int notifications = 0;
        List<Integer> sortedExpenses = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if(i > d) {
                double m = median(sortedExpenses);
                if(m * 2 >= expenditure[i])
                    notifications++;
            }
            insertionSort(sortedExpenses, expenditure[i]);
        }

        return notifications;
    }

    private static double median(List<Integer> sortedExpenses) {
        int n = sortedExpenses.size();
        
        if(n % 2 == 0)
            return ((double) sortedExpenses.get(n / 2 - 1) + (double) sortedExpenses.get(n / 2)) / 2;
        else
            return (double) sortedExpenses.get(n / 2);
            
    }

    /**
     * Insert an eleemnt to the list keeping the list sorted.
     * Using "binary search" to look for the right place.
     * Time complexity: O(logn) because it "divides" the array by 2 each iteration to see where the element should go.
     * @param sortedExpenses List of expenses
     * @param exp element to insert sortly
     */
    private static void insertionSort(List<Integer> sortedExpenses, int exp) {
        int left = 0, right = sortedExpenses.size(), mid = 0;
        
        while(left < right) {
            mid = (left + right) / 2;
            if(sortedExpenses.get(mid) > exp)
                right = mid;
            else
                left = mid + 1;
        }

        sortedExpenses.add(left, exp);;
    }
}