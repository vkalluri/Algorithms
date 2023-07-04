package com.venkat.codility;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
	public static int solution(int[] A) {
		Set<Integer> set = new HashSet<>();

		for (int num : A) {
			if (num > 0) {
				set.add(num);
			}
		}

		int smallestMissing = 1;

		while (set.contains(smallestMissing)) {
			smallestMissing++;
		}

		return smallestMissing;
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 6, 4, 1, 2 };

		int smallestMissing = solution(A);
		System.out.println("Smallest missing integer: " + smallestMissing);
	}
}
