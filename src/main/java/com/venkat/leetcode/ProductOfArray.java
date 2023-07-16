package com.venkat.leetcode;


/**
 * 238. Product of Array Except Self
 * Medium
 * 18.6K
 * 1K
 * Companies
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity?
 * (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductOfArray {

    /**
     * To solve this problem without using division, we can use the concept of prefix and suffix products.
     * We will iterate through the array twice: first from left to right to calculate the prefix products,
     * and then from right to left to calculate the suffix products. The product at each index
     * will be the product of the prefix product and the suffix product.
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // Calculate the prefix products
        int[] prefixProducts = new int[n];
        prefixProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }

        // Calculate the suffix products and multiply with the prefix products
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            prefixProducts[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return prefixProducts;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");  // Output: 24 12 8 6
        }
    }
}
