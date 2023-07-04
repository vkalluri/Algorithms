package com.venkat.codility;

public class PassingCars {
	public static int solution(int[] A) {
		int countZeros = 0;
		int countPairs = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				countZeros++;
			} else {
				countPairs += countZeros;
			}

			if (countPairs > 1_000_000_000) {
				return -1;
			}
		}

		return countPairs;
	}

	public static void main(String[] args) {
		int[] A = { 0, 1, 0, 1, 1 };

		int passingCars = solution(A);
		System.out.println("Number of passing cars: " + passingCars);
	}
}
