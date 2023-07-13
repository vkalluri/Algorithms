package com.venkat.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The distance between two array values is the number of indices between them. Given a,
 * find the minimum distance between any pair of equal elements in the array. If no such value exists, return -1.
 *
 * Example
 * a = [3,2,1,2,3]
 *
 * There are two matching pairs of values: 3 and 2. The indices of the 3's are i = 0 and j = 4,
 * so their distance is d[i, j] = |j - i| = 4. The indices of the 2's are i = 1 and j = 3,
 * so their distance is d[i,j] = |j - i| = 2. The minimum distance is 2.
 *
 * Function Description
 *
 * Complete the minimumDistances function in the editor below.
 *
 * minimumDistances has the following parameter(s):
 *
 * int a[n]: an array of integers
 *
 * Returns
 * int: the minimum distance found or -1 if there are no matching elements
 *
 * Input Format
 * The first line contains an integer n, the size of array a.
 * The second line contains n space-separated integers a[i].
 *
 * Constraints
 * 1 <= n <= 10^3
 * 1 <= a[i] <= 10^5
 */
public class MinimumDistance {

    /**
     * To find the minimum distance between any pair of equal elements in the array a,
     * we can use a HashMap to store the last seen index of each element. We iterate through
     * the array and update the minimum distance if we find a pair of equal elements with a smaller distance.
     *
     * We use a HashMap called lastIndexMap to store the last seen index of each element.
     * We initialize minDistance as Integer.MAX_VALUE.
     *
     * We iterate through the array a and for each element, we check if it already exists in the lastIndexMap.
     * If it does, we calculate the distance between the current index and the last seen index of that element.
     * If this distance is smaller than the current minDistance, we update minDistance accordingly.
     *
     * After iterating through the entire array, if minDistance remains unchanged (still Integer.MAX_VALUE),
     * it means no matching elements were found, so we return -1. Otherwise, we return the minimum distance.
     *
     * In the main method, we initialize a with the given array and call minimumDistances to get
     * the minimum distance. Finally, we print the minimum distance.
     *
     * Note: This solution assumes that the input array a will always contain integers in the given constraints.
     * Make sure to handle potential exceptions and edge cases in a production-level implementation.
     * @param a
     * @return
     */
    static int minimumDistances(int[] a) {
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            int currentElement = a[i];
            if (lastIndexMap.containsKey(currentElement)) {
                int lastSeenIndex = lastIndexMap.get(currentElement);
                int distance = i - lastSeenIndex;
                minDistance = Math.min(minDistance, distance);
            }
            lastIndexMap.put(currentElement, i);
        }

        if (minDistance == Integer.MAX_VALUE) {
            return -1; // No matching elements found
        } else {
            return minDistance;
        }
    }

    static int minimumDistances(List<Integer> a) {
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

//        for (int i = 0; i < a.size(); i++) {
//            int currentElement = a.get(i);
//            if (lastIndexMap.containsKey(currentElement)) {
//                int lastSeenIndex = lastIndexMap.get(currentElement);
//                int distance = i - lastSeenIndex;
//                minDistance = Math.min(minDistance, distance);
//            }
//            lastIndexMap.put(currentElement, i);
//        }
        int j = 1;
        for (int i : a) {
            int currentElement = i;
            if (lastIndexMap.containsKey(currentElement)) {
                int lastSeenIndex = lastIndexMap.get(currentElement);
                int distance = j - lastSeenIndex;
                minDistance = Math.min(minDistance, distance);
            }
            lastIndexMap.put(currentElement, j);
            j++;
        }

        if (minDistance == Integer.MAX_VALUE) {
            return -1; // No matching elements found
        } else {
            return minDistance;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 2, 3};
        int minDistance = minimumDistances(a);
        System.out.println("Minimum Distance: " + minDistance);
        List list =  Arrays.asList(3, 2, 1, 2, 3);
        System.out.println("Min distance : " +minimumDistances(list));
    }
}
