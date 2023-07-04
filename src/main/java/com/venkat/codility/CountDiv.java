package com.venkat.codility;

public class CountDiv {
	public static int solution(int A, int B, int K) {
		int count = 0;

		if (A % K == 0) {
			count++;
		}

		count += B / K - A / K;

		return count;
	}

	public static void main(String[] args) {
		int A = 6;
		int B = 11;
		int K = 2;

		int divisibleCount = solution(A, B, K);
		System.out.println("Count of numbers divisible by " + K + ": " + divisibleCount);
	}
	
	
	
}
