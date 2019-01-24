package hackerrank.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

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
     * Count the notifications after d days, taking into account that the previous <i>median</i> will be calculated by
     * the d trailing expenditures. To achieve this we need to keep a Queue and a ordered data structure, the contrainst
     * of the problems says <code>0 <= expenditure[i] <= 200</code> so an array of length 201 will suffice, otherwise
     * calculation time will be too much for more complex data structures time TreeMap.
     * <p>
     * Time complexity: 
     * <p>
     * Space complexity: 
     * 
     * @param expenditure input array
     * @param d lookback days for median spending
     * @param n size of the input array
     * @return number of notifications the client will receive according to his/her expenses from d day
     */
    private static int activityNotifications(int[] expenditure, int d, int n) {
        int notifications = 0;
        Deque<Integer> trailExpenditure = new LinkedList<Integer>();
        int[] freq = new int[201];

        for (int i = 0; i < n; i++) {
            System.out.println("expenditure[i]:" + expenditure[i]);
            trailExpenditure.addLast(expenditure[i]);
            freq[expenditure[i]]++;

            if(i >= d) {
                int discardedExpense = trailExpenditure.removeFirst();
                freq[discardedExpense]--;
                double m = median(trailExpenditure, freq);
                if(m * 2 <= expenditure[i])
                    notifications++;
            }            
        }
        
        return notifications;
    }

    private static double median(Deque<Integer> trailExpenditure, int[] freq) {
        int a = trailExpenditure.size() / 2, b = a + 1;
        int mid1 = -1, mid2 = -1, rs = 0;
        System.out.printf("  a:%d", a);
        for (int i = 0; i < freq.length; i++) {
            rs += freq[i];
            System.out.printf("    i:%d, rs:%d, mid1:%d, mid2:%d\n", i, rs, mid1, mid2);
            if(rs > a && mid1 == -1)
                mid1 = i;
            if(rs >= b) {
                mid2 = i;
                break;
            }                
        }
        System.out.printf("        rs:%d, mid1:%d, mid2:%d\n", rs, mid1, mid2);
        if(freq.length % 2 == 0)
            return ((double) mid1 + (double) mid2) / 2;
        else
            return (double) mid2;            
    }    
}