package utils;

import java.util.List;

/**
 * This class provides several implementations and solutions to problems related to Lists
 * @author rzapata
 */
public class ListHelper {

    /**
     * Insert an eleemnt to the list keeping the list sorted.
     * Using "binary search" to look for the right place.
     * Time complexity: O(logn) because it "divides" the array by 2 each iteration to see where the element should go.
     * @param sortedList List of expenses
     * @param exp element to insert sortly
     */
    public static <T extends Comparable<? super T>> void insertionSort(List<T> sortedList, T e) {
        int left = 0, right = sortedList.size(), mid = 0;
        
        while(left < right) {
            mid = (left + right) / 2;
            if(sortedList.get(mid).compareTo(e) > 0)
                right = mid;
            else
                left = mid + 1;
        }

        sortedList.add(left, e);
    }    
}