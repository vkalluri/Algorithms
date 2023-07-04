package com.venkat.codility;

import java.util.HashSet;
import java.util.Set;

public class MinAvgTwoSlice {
	public int solution(int[] A) {
		int minAvgIndex = 0;
		double minAvgValue = Double.MAX_VALUE;

		// Check for slices of length 2
		for (int i = 0; i < A.length - 1; i++) {
			double avg = (A[i] + A[i + 1]) / 2.0;
			if (avg < minAvgValue) {
				minAvgValue = avg;
				minAvgIndex = i;
			}
		}

		// Check for slices of length 3
		for (int i = 0; i < A.length - 2; i++) {
			double avg = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
			if (avg < minAvgValue) {
				minAvgValue = avg;
				minAvgIndex = i;
			}
		}

		return minAvgIndex;
	}

	public static void main(String[] args) {
		MinAvgTwoSlice slice = new MinAvgTwoSlice();
		int[] A = { 4, 2, 2, 5, 1, 5, 8 };
		int result = slice.solution(A);
		System.out.println(result);
		
		Set<String> mySet = new HashSet<>();
	}
}
