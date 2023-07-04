package com.venkat.hackerrank;

import java.util.Arrays;

public class AlternateSequence {

	public AlternateSequence() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] result = arrangeSequence(arr);

		System.out.println("Original Array: " + Arrays.toString(arr));
		System.out.println("Arranged Sequence: " + Arrays.toString(result));
	}

	/**
	 * To arrange the elements of a sorted array arr[] into a sequence such that the
	 * resulting sequence alternates between greater-than and less-than comparisons,
	 * you can follow the below approach:
	 * 
	 * Create an auxiliary array result[] of the same size as arr[]. Initialize two
	 * pointers: left pointing to the first element of arr[] and right pointing to
	 * the last element of arr[]. Iterate over the arr[] in ascending order: Assign
	 * the element at left index of arr[] to result[] and increment left by 1.
	 * Assign the element at right index of arr[] to result[] and decrement right by
	 * 1. If the size of arr[] is odd, there will be one element left in the middle.
	 * Assign this element to result[]. The result[] array now contains the arranged
	 * sequence.
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] arrangeSequence(int[] arr) {
		int[] result = new int[arr.length];
		int left = 0;
		int right = arr.length - 1;

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				result[i] = arr[left];
				left++;
			} else {
				result[i] = arr[right];
				right--;
			}
		}

		return result;
	}

}
