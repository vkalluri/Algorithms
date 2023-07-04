package com.venkat.hackerrank;

public class MaximumSubarraySum {

	public MaximumSubarraySum() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = findMaxSubarraySum(arr);
        
        System.out.println("Maximum Subarray Sum: " + maxSum);
    }
    
    public static int findMaxSubarraySum(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], arr[i] + maxEndingHere);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
}
