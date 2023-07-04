package com.venkat.codility;

public class FrogJump {
	public static int solution(int X, int[] A) {
		boolean[] leaves = new boolean[X + 1];
		int remainingLeaves = X;

		for (int i = 0; i < A.length; i++) {
			if (!leaves[A[i]]) {
				leaves[A[i]] = true;
				remainingLeaves--;

				if (remainingLeaves == 0) {
					return i;
				}
			}
		}

		return -1; // Frog can't cross the river
	}

	public static void main(String[] args) {
//	        int X = 5;
//	        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
//
//	        int minJumps = solution(X, A);
//	        System.out.println("Minimum number of jumps: " + minJumps);

	}

	public static int solution(int X, int Y, int D) {
		int distance = Y - X;
		int jumps = distance / D;

		if (distance % D != 0) {
			jumps++; // Add an extra jump if there is a remainder
		}

		return jumps;
	}
}
