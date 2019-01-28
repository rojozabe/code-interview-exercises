package hackerrank.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import utils.FileHelper;

/**
 * Fraudulent Activity Notifications
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 * <p>
 * Given the number of trailing days d and a client's total daily expenditures for a period of n days,
 * find and print the number of times the client will receive a notification over all n days.
 * 
 * This is a data structures problem of finding running median from streamed data using Heaps
 * This can also be found using Insertion sort but it takes O(n^2) time to sort n elements and then add the new element
 * 
 * Binary Heaps take o(log n) for heap insertions/deletions. This problem can be solved with using min and max heaps.
 */
public class ActivityNotifications {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/sorting/ActivityNotifications.txt");
        String[] s = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        int[] expenditure = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(activityNotificationsDynamic(expenditure, d, n));
        br.close();
    }

    /**
     * Count the notifications after d days, taking into account that the previous <i>median</i> will be calculated by
     * the d trailing expenditures. To achieve this we need to keep a Queue and a ordered data structure, the constraint
     * of the problems says <code>0 <= expenditure[i] <= 200</code> so an array of length 201 with the frequencies of each
     * expense in the trail expenditure will suffice, this array is called <b>counting sort</b>, otherwise
     * calculation time will be too much for more complex data structures time TreeMap.
     * <p>
     * DISCLAIMER: CAREFUL WITH THE MEDIAN DIVISION!!! when d is odd
     * <p>
     * Time complexity: O(n * freq array) => O(n)
     * <p>
     * Space complexity: O(d + 201) => O(d) 
     * 
     * @param expenditure input array
     * @param d lookback days for median spending
     * @param n size of the input array
     * @return number of notifications the client will receive according to his/her expenses from d day
     */
    @SuppressWarnings("unused")
    private static int activityNotifications(int[] expenditure, int d, int n) {
        int notifications = 0;
        Deque<Integer> trailExpenditure = new LinkedList<Integer>();
        int[] freq = new int[201];

        for (int i = 0; i < n; i++) {
            if(i >= d) {                
                int m = median(trailExpenditure, d, freq);
                if(m * (d % 2 > 0 ? 2 : 1) <= expenditure[i])
                    notifications++;
            }
            
            trailExpenditure.add(expenditure[i]);
            freq[expenditure[i]]++;
            if(i >= d) 
                freq[trailExpenditure.remove()]--;            
        }
        
        return notifications;
    }

    /**
     * Based on the frequencies of the trail expenditure we look for when the frequencies
     * cumulative sum equalizes or surpasses d / 2, the result index will be our median
     * <p>
     * Time complexity: O(201) => O(1)
     * <p>
     * Space complexity: O(1)
     * 
     * @param trailExpenditure queue with the current trail expenditures
     * @param d lookback days for median spending
     * @param freq array with the frequencies of each expenditure in the current trail
     * @return median based on the frequencies
     */
    private static int median(Deque<Integer> trailExpenditure, int d, int[] freq) {
        int a = d / 2, b = a + 1;
        int mid1 = -1, mid2 = -1, rs = 0;
        
        for (int i = 0; i < freq.length; i++) {
            rs += freq[i];
            
            if(rs >= a && mid1 == -1)
                mid1 = i;
            if(rs >= b) {
                mid2 = i;
                break;
            }
        }
        
        if(d % 2 == 0)
            return mid1 + mid2;
        else
            return mid2;            
    }

    /**
     * Count the notifications after d days, this approach will differenciate with the previous one as we can store two set of 
     * Binary Heaps or Priority Queues in Java: One below the current median and another with above.
     * If the <i>buckets</i> have the same size average lower.max and higher.min, on the contrary if they
     * have different sizes lower.max or higher.min depending which is bigger. The data structure appropiate here is <b>HEAP</b>
     * storing lower.max and higher.min at the top of each heap.
     * 
     * For each trailExpense will look for the median with the PriorityQueues, this will give us nlogd time but if d = n then worst
     * case scenario will be nlogn time.
     * 
     * Time complexity: O(n * logn), in this particular case as I use PriorityQueue.remove(Object) total time cost goes to O(n ^ 2)
     * Space complexity: O(3 * n) As we need to store d expenses in the priority queues, worst case scenario d = n
     * 
     * @param expenditure input array
     * @param d lookback days for median spending
     * @param n size of the input array
     * @return number of notifications the client will receive according to his/her expenses from d day
     */
    private static int activityNotificationsDynamic(int[] expenditure, int d, int n) {
        int notifications = 0;
        Deque<Integer> trailExpenditure = new LinkedList<Integer>();
        Queue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
        Queue<Integer> highers = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            int cExpense = expenditure[i];
            if(i >= d) {                
                double m = getMedian(lowers, highers);                
                double exp = (double) cExpense;
                if(m * 2.0d <= exp)
                    notifications++;
            }
                        
            trailExpenditure.add(cExpense);
            addExpenseToQueue(lowers, highers, cExpense);
            if(i >= d) {
                int rExpense = trailExpenditure.remove();
                if(!lowers.remove(rExpense))
                    highers.remove(rExpense);
            } 
            rebalanceQueues(lowers, highers);     
        }
        return notifications;
    }

    /**
     * Add expense to any of the queues
     * @param lowers
     * @param highers
     * @param expense
     */
    private static void addExpenseToQueue(Queue<Integer> lowers, Queue<Integer> highers, int expense) {
        if(lowers.size() == 0 || lowers.peek() > expense)
            lowers.add(expense);
        else
            highers.add(expense);
    }

    /**
     * Util function to rebalance queues, their sizes differences must be no more than 1
     * @param lowers
     * @param highers
     */
    private static void rebalanceQueues(Queue<Integer> lowers, Queue<Integer> highers) {
        Queue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        Queue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        while(biggerHeap.size() - smallerHeap.size() > 1) {
            smallerHeap.add(biggerHeap.remove());
        }
    }

    /**
     * The median for the current iteration will be the head of the bigger queue, if the queues
     * have the same size then it will be the average of both of their heads.
     * @param lowers
     * @param highers
     * @return median for the current iteration
     */
    private static double getMedian(Queue<Integer> lowers, Queue<Integer> highers) {
        if(lowers.size() > highers.size())
            return (double) lowers.peek();
        else if(lowers.size() < highers.size())
            return (double) highers.peek();
        else
            return ((double) lowers.peek() + highers.peek()) / 2.0d;
    }
}