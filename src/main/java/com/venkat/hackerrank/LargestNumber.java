package com.venkat.hackerrank;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public LargestNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] nums = { 3, 30, 34, 5, 9 };
		String largestNumber = largestNumber(nums);

		System.out.println("Largest Number: " + largestNumber);
	}

	/**
	 * To arrange a list of nonnegative integers in a way that forms the largest
	 * possible number, you can implement a custom sorting algorithm based on a
	 * comparison function. The comparison function will compare two numbers based
	 * on their concatenated representation to determine their order in the sorted
	 * list.
	 * 
	 * Here's the step-by-step approach:
	 * 
	 * Convert each integer in the list to a string. Implement a custom comparison
	 * function that compares two strings by concatenating them in different orders
	 * and determining which order results in a larger combined number. Sort the
	 * list using the custom comparison function. You can use any sorting algorithm,
	 * such as quicksort or mergesort. Concatenate the sorted list of strings to
	 * form the largest possible number.
	 * 
	 * @param nums
	 * @return
	 */

	public static String largestNumber(int[] nums) {
		// Convert integers to strings
		String[] strNums = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strNums[i] = String.valueOf(nums[i]);
		}

		// Sort the strings using custom comparison
		Arrays.sort(strNums, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				String order1 = a + b;
				String order2 = b + a;
				return order2.compareTo(order1);
			}
		});

		// Handle leading zeros
		if (strNums[0].equals("0")) {
			return "0";
		}

		// Concatenate the sorted strings
		StringBuilder result = new StringBuilder();
		for (String str : strNums) {
			result.append(str);
		}

		return result.toString();
	}
}
