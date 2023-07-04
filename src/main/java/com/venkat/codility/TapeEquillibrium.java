package com.venkat.codility;

public class TapeEquillibrium {
	public static int solution(int[] A) {
		int totalSum = 0;
		int leftSum = 0;
		int rightSum;
		int minDifference = Integer.MAX_VALUE;

		// Calculate the total sum of the array
		for (int num : A) {
			totalSum += num;
		}

		for (int i = 0; i < A.length - 1; i++) {
			leftSum += A[i];
			rightSum = totalSum - leftSum;
			int difference = Math.abs(leftSum - rightSum);

			if (difference < minDifference) {
				minDifference = difference;
			}
		}

		return minDifference;
	}

	public static void main(String[] args) {
		int[] A = { 3, 1, 2, 4, 3 };

		int minDifference = solution(A);
		System.out.println("Minimum difference: " + minDifference);
	}
}
