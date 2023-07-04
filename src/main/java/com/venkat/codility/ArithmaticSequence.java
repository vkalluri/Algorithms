package com.venkat.codility;

public class ArithmaticSequence {

	public static void main(String[] args) {
		int L[] = { 1, 3, 5, 6, 7, 8 };
		int N = L.length;

		// Function to find arithmetic sequences
		System.out.print(numberOfArithmeticSequences(L, N));

	}

	static int numberOfArithmeticSequences(int L[], int N) {

		if (N <= 2)
			return 0;

		int count = 0;

		int res = 0;

		for (int i = 2; i < N; ++i) {

			if (L[i] - L[i - 1] == L[i - 1] - L[i - 2]) {
				++count;
			}else {
				count = 0;
			}

			res += count;
		}

		return res;
	}

}
