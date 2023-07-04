package com.venkat.leetcode.challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums, return the number of good pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 *
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class GoodPairs {
    /**
     * To count the number of good pairs in an array, we can use a hashmap to keep track of the frequency of each number.
     *
     * In this code, we use a hashmap frequencyMap to store the frequency of each number in the array nums.
     * We iterate through nums and update the frequency of each number in the map.
     *
     * After counting the frequency of each number, we iterate through the values in the frequencyMap
     * and calculate the number of good pairs. For each frequency f, the number of good pairs is
     * given by f * (f - 1) / 2. We add the count of good pairs to the goodPairs variable.
     *
     * Finally, we return the goodPairs count, which represents the number of good pairs in the array.
     *
     * In the example code, we count the number of good pairs in the array [1, 2, 3, 1, 1, 3].
     * The output will be 4, indicating that there are four good pairs: (0, 3), (0, 4), (3, 4), and (2, 5).
     * @param nums
     * @return
     */
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int goodPairs = 0;

        // Count the frequency of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Count the good pairs
        for (int frequency : frequencyMap.values()) {
            // If the frequency is f, the number of good pairs is f * (f - 1) / 2
            goodPairs += frequency * (frequency - 1) / 2;
        }

        return goodPairs;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        int count = numIdenticalPairs(nums);
        System.out.println("Number of good pairs: " + count);
    }
}
