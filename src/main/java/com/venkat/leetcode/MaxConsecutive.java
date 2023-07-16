package com.venkat.leetcode;


/**
 * Given a binary array nums and an integer k, return the maximum number
 * of consecutive 1's in the array if you can flip at most k 0's.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 */
public class MaxConsecutive {


    /**
     * To find the maximum number of consecutive 1's in a binary array nums if we can
     * flip at most k 0's, we can use a sliding window approach. We'll maintain a window of
     * size k and count the number of zeros in the window. If the number of zeros exceeds k,
     * we'll shrink the window from the left side to maintain the constraint of flipping at most
     * k zeros. We'll keep track of the maximum consecutive ones encountered during this process.
     *
     * In the example above, the output is 6, which represents the maximum number of
     * consecutive ones in the binary array [1, 1, 0, 1, 1, 0, 0, 1] if we can flip at most 2 zeros.
     * The algorithm uses a sliding window to maintain the window size and count the zeros,
     * while updating the maximum consecutive ones in linear time complexity.
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public static int longestOnes(int[] nums, int k) {
        int left = 0; // Left pointer of the window
        int zerosCount = 0; // Count of zeros in the window
        int maxConsecutiveOnes = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zerosCount++;
            }

            // Shrink the window if the number of zeros exceeds k
            while (zerosCount > k) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }

            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left + 1);
        }

        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 0, 0, 1};
        int k = 2;
        int maxConsecutiveOnes = longestOnes(nums, k);
        System.out.println(maxConsecutiveOnes);  // Output: 6
    }
}
