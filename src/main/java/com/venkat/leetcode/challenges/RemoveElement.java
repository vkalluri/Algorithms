package com.venkat.leetcode.challenges;

import java.util.Arrays;

public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
        int count = 0; // Count of elements not equal to val

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 5};
        int val = 3;
        int remainingElements = removeElement(nums, val);
        
        System.out.println(Arrays.toString(nums));
        
        // Print the updated array and the count of remaining elements
        System.out.println("Updated Array:");
        for (int i = 0; i < remainingElements; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println("Remaining Elements: " + remainingElements);
    }
}
