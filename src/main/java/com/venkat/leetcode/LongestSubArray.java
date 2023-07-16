package com.venkat.leetcode;


/**
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only
 * 1's in the resulting array. Return 0 if there is no such subarray.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 * Example 2:
 *
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * Example 3:
 *
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
public class LongestSubArray {

    public static int longestSubArray(int[] nums){
        int longestSize = 0;
        int temp = 0; int zero = 0; int j = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                if((zero ==0 || zero == 1)) {
                    temp++;
                }else{
                   j = temp;
                   temp = 0;
                }
            }else if(i != 0 && nums[i] == 0){
               // if(nums[0] != 0)
                zero++;
            }
            j = Math.max(j, temp);
            longestSize = Math.max(longestSize, j);
        }

        return longestSize;
    }

    public static int longestSubarray(int[] nums) {
        int maxLength = 0;
        int leftCount = 0; // Count of consecutive 1's on the left side of 0
        int rightCount = 0; // Count of consecutive 1's on the right side of 0
        int zeroCount = 0; // Count of zeros encountered

        for (int num : nums) {
            if (num == 1) {
                // Increment the count on the left side of 0
                leftCount++;
                // Increment the count on the right side of 0 only if a zero has not been encountered
                rightCount = (zeroCount == 0) ? rightCount + 1 : rightCount;
                maxLength = Math.max(maxLength, (zeroCount == 0) ? rightCount : leftCount + rightCount);
            } else {
                // Reset the counts on both sides of 0
                leftCount = rightCount;
                rightCount = 0;
                zeroCount++;
            }
        }

        // Return maxLength only if at least one zero has been encountered
        return (zeroCount > 0) ? maxLength : maxLength - 1;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1};
        System.out.println(longestSubarray(nums));

        int[] nums1 = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums1));
    }

}
