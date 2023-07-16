package com.venkat.leetcode;


/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 *
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 */
public class MaxAvgSubarray {

    /**
     * To find a contiguous subarray of length k in an integer array nums that has the maximum average value,
     * we can use a sliding window approach. We'll initialize the window with the first k elements
     * and calculate the sum of the elements in the window. Then, we'll iterate through the remaining
     * elements, adding the next element and removing the previous element from the window.
     * We'll keep track of the maximum average value encountered during this process.
     *
     * In the example above, the output is 12.75, which represents the maximum average value of
     * a contiguous subarray of length 4 in the array [1, 12, -5, -6, 50, 3]. The algorithm uses a
     * sliding window to calculate the sum of each window and update the maximum average value in linear time complexity.
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        // Calculate the sum of the first k elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAverage = (double) sum / k;

        // Calculate the sum of subsequent k-element windows
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k]; // Add the next element and remove the previous element
            maxAverage = Math.max(maxAverage, (double) sum / k);
        }

        return maxAverage;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double maxAverage = findMaxAverage(nums, k);
        System.out.println(maxAverage);  // Output: 12.75
    }
}
