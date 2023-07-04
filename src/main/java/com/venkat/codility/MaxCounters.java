package com.venkat.codility;

import java.util.Arrays;

public class MaxCounters {
	public static int[] solution(int N, int[] A) {
		int[] counters = new int[N];
		int maxCounter = 0;
		int base = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] >= 1 && A[i] <= N) {
				int counterIndex = A[i] - 1;

				if (counters[counterIndex] < base) {
					counters[counterIndex] = base;
				}

				counters[counterIndex]++;
				maxCounter = Math.max(maxCounter, counters[counterIndex]);
			} else if (A[i] == N + 1) {
				base = maxCounter;
			}
		}

		for (int i = 0; i < counters.length; i++) {
			if (counters[i] < base) {
				counters[i] = base;
			}
		}

		return counters;
	}

	public static void main(String[] args) {
		int N = 5;
		int[] A = { 3, 4, 4, 6, 1, 4, 4 };

		int[] counters = solution(N, A);
		System.out.println("Counter values: " + Arrays.toString(counters));
	}
}
