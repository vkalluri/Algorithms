package com.venkat.leetcode;


/**
 * 334. Increasing Triplet Subsequence
 * Medium
 * 6.8K
 * 311
 * Companies
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * Example 2:
 *
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 * Example 3:
 *
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
 */
public class IncreasingTriplets {

    public static boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= smallest) {
                smallest = num;
            } else if (num <= middle) {
                middle = num;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        boolean result = increasingTriplet(nums);
        System.out.println(result);  // Output: true

        int[] nums2 = {5, 4, 3, 2, 1};
        boolean result2 = increasingTriplet(nums2);
        System.out.println(result2);  // Output: false

        int[] nums3 = {2,1,5,0,4,6};
        boolean result3 = increasingTriplet(nums3);
        System.out.println(result3);  // Output: false
    }
}
