package com.venkat.hackerrank;

public class PermutationSequence {

	public PermutationSequence() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * To find a permutation of the first n positive integers that satisfies the
	 * given input string, we can use the concept of a "peak-valley" pattern.
	 * 
	 * Here's an approach to solve the problem:
	 * 
	 * Initialize two pointers, low and high, with low = 0 and high = n. Iterate
	 * through the input string s: If the current character is 'I', append low to
	 * the result and increment low by 1. If the current character is 'D', append
	 * high to the result and decrement high by 1. After iterating through the input
	 * string, append the value of low to the result since low and high will be
	 * equal. Return the resulting permutation.
	 * 
	 * @param n
	 * @param s
	 * @return
	 */
	public static int[] findPermutation(int n, String s) {
		int[] permutation = new int[n];
		int low = 0;
		int high = n;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'I') {
				permutation[i] = low;
				low++;
			} else if (s.charAt(i) == 'D') {
				permutation[i] = high;
				high--;
			}
		}

		// Append the remaining value
		permutation[n - 1] = low;

		return permutation;
	}

	public static void main(String[] args) {
		int n = 5;
		String s = "IDID";
		int[] permutation = findPermutation(n, s);

		System.out.println("Permutation: ");
		for (int num : permutation) {
			System.out.print(num + " ");
		}
	}
}
