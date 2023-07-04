package com.venkat.codility;

import java.util.Arrays;

public class CyclicRotation {
	public static int[] solution(int[] A, int K) {
		int[] rotatedA = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			// rotated index needs to "wrap" around end of array
			int rotatedIndex = (i + K) % A.length;

			rotatedA[rotatedIndex] = A[i];
		}
		return rotatedA;
	}

	public static void main(String[] args) {
//		int[] i = {3, 8, 9, 7, 6};
//		System.out.println(solution(i, 3));
//		
		int[] nums = { 1, 2, 3, 4, 5 };
		int k = 3;

		int[] rotatedArray = rotateArray(nums, k);
		System.out.println("Original Array: " + Arrays.toString(nums));
		System.out.println("Rotated Array: " + Arrays.toString(rotatedArray));

	}

	public static int[] rotateArray(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) {
			return nums;
		}

		int[] result = new int[nums.length];
		int rotate = k % nums.length; // Get the effective number of rotations

		for (int i = 0; i < nums.length; i++) {
			int newIndex = (i + rotate) % nums.length; // Calculate the new index after rotation
			result[newIndex] = nums[i]; // Place the element at the new index
		}

		return result;
	}
}
