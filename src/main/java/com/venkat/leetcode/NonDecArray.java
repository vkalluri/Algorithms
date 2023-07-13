package com.venkat.leetcode;


/**
 *  Steps to Make Array Non-decreasing
 * Medium
 * 1.1K
 * 116
 * Companies
 * You are given a 0-indexed integer array nums. In one step, remove all elements nums[i] where nums[i - 1] > nums[i] for all 0 < i < nums.length.
 *
 * Return the number of steps performed until nums becomes a non-decreasing array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,3,4,4,7,3,6,11,8,5,11]
 * Output: 3
 * Explanation: The following are the steps performed:
 * - Step 1: [5,3,4,4,7,3,6,11,8,5,11] becomes [5,4,4,7,6,11,11]
 * - Step 2: [5,4,4,7,6,11,11] becomes [5,4,7,11,11]
 * - Step 3: [5,4,7,11,11] becomes [5,7,11,11]
 * [5,7,11,11] is a non-decreasing array. Therefore, we return 3.
 * Example 2:
 *
 * Input: nums = [4,5,7,7,13]
 * Output: 0
 * Explanation: nums is already a non-decreasing array. Therefore, we return 0.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
public class NonDecArray {

    /**
     * The removeSteps function takes an input array nums and performs the required steps
     * to make it a non-decreasing array. It uses a loop to iterate through the array starting
     * from the second element. If a number at index i is smaller than the previous number
     * at index i - 1, it means the elements are out of order. In this case, it calculates the
     * difference between the previous number and the current number and adds it to the steps variable.
     * Then, it updates the current number to be equal to the previous number to make the array non-decreasing.
     *
     * Finally, the function returns the total number of steps performed.
     *
     * You can use this function by creating an instance of the Solution class and calling removeSteps(nums)
     * on that instance, where nums is the input array. It will return the number of steps performed until the array becomes non-decreasing.
     * @param nums
     * @return
     */
    public static int removeSteps(int[] nums) {
        int steps = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                nums[i] = nums[i - 1];
                steps++;
            }
        }

        return steps;
    }

}
