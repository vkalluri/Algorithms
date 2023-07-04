package com.venkat.leetcode;

public class TappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println(trap(i));
	}
	
	public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        
        return totalWater;
    }

}
