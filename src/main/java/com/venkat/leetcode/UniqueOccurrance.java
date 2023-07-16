package com.venkat.leetcode;


import java.util.*;

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class UniqueOccurrance {

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> occurrenceSet = new HashSet<>(frequencyMap.values());

        // Check if the number of occurrences is unique
        return occurrenceSet.size() == frequencyMap.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        boolean isUnique = uniqueOccurrences(arr);
        System.out.println(isUnique);  // Output: true
    }
}
