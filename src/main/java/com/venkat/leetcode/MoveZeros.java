package com.venkat.leetcode;


/**
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeros {

    /**
     * To move all the zeros to the end of the array while maintaining the relative order of the
     * non-zero elements, we can use a two-pointer approach. We'll maintain two pointers: write
     * and read. The write pointer indicates the next position to write a non-zero element,
     * and the read pointer iterates through the array to find non-zero elements.
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int write = 0; // Pointer to write non-zero elements

        // Write all the non-zero elements to the beginning of the array
        for (int read = 0; read < n; read++) {
            if (nums[read] != 0) {
                nums[write++] = nums[read];
            }
        }

        // Fill the remaining positions with zeros
        while (write < n) {
            nums[write++] = 0;
        }
    }

    /**
     * In the example above, the output is 1 3 12 0 0, which represents the array after
     * moving all the zeros to the end while maintaining the relative order of the non-zero elements.
     * The algorithm performs the operation in place without making a copy of the array.
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");  // Output: 1 3 12 0 0
        }
    }
}
