package com.venkat.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 1679. Max Number of K-Sum Pairs
 *
 * You are given an integer array nums and an integer k.
 *
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 *
 * Return the maximum number of operations you can perform on the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * Example 2:
 *
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 */
public class MaxNumber {

    /**
     * To find the maximum number of operations that can be performed on an integer array nums
     * such that the sum of the two numbers equals k, we can use a hashmap to store the
     * frequencies of each number in the array. We'll iterate through the array and
     * for each number num, we'll check if k - num exists in the hashmap.
     * If it exists, we can perform an operation by removing both numbers from the array.
     *
     * In the example above, the output is 2, which represents the maximum number of
     * operations that can be performed on the array [1, 2, 3, 4, 5] such
     * that the sum of the two numbers equals 5. The algorithm uses a hashmap
     * to keep track of the frequency of each number and performs the operations in linear time complexity.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            int complement = k - num;
            if (frequency.containsKey(complement) && frequency.get(complement) > 0) {
                operations++;
                frequency.put(complement, frequency.get(complement) - 1);
            } else {
                frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;
        int maxOperations = maxOperations(nums, k);
        System.out.println(maxOperations);  // Output: 2
    }
}
