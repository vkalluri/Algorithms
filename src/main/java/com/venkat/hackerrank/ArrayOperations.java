package com.venkat.hackerrank;

import java.util.List;

/**
 * Starting with a 1-indexed array of zeros and a list of operations, for each
 * operation add a value to each the array element between two given indices,
 * inclusive. Once all operations have been performed, return the maximum value
 * in the array.
 * 
 * Example
 * 
 * 
 * Queries are interpreted as follows:
 * 
 * a b k 1 5 3 4 8 7 6 9 1 Add the values of between the indices and inclusive:
 * 
 * index-> 1 2 3 4 5 6 7 8 9 10 [0,0,0, 0, 0,0,0,0,0, 0] [3,3,3, 3, 3,0,0,0,0,
 * 0] [3,3,3,10,10,7,7,7,0, 0] [3,3,3,10,10,8,8,8,1, 0] The largest value is
 * after all operations are performed.
 * 
 * Function Description
 * 
 * Complete the function arrayManipulation in the editor below.
 * 
 * arrayManipulation has the following parameters:
 * 
 * int n - the number of elements in the array int queries[q][3] - a two
 * dimensional array of queries where each queries[i] contains three integers,
 * a, b, and k. Returns
 * 
 * int - the maximum value in the resultant array Input Format
 * 
 * The first line contains two space-separated integers and , the size of the
 * array and the number of operations. Each of the next lines contains three
 * space-separated integers , and , the left index, right index and summand.
 * 
 * Constraints
 * 
 * 
 * @author vkall
 *
 */
public class ArrayOperations {
	/**
	 * In this code, the arrayManipulation method takes an integer n representing
	 * the size of the array and a 2D integer array queries representing the list of
	 * operations. It returns the maximum value in the array after performing the
	 * operations.
	 * 
	 * The method initializes an array arr of size n with all zeros.
	 * 
	 * It then iterates over each query in queries and performs the operation on the
	 * array. For each query, it adds the value to the element at the start index
	 * (query[0] - 1) and subtracts the value from the element at the end index plus
	 * one (query[1] - 1 + 1). This is done to keep track of the cumulative effect
	 * of the operations.
	 * 
	 * After performing all the operations, the method computes the prefix sum of
	 * the array. The prefix sum represents the actual values in the array after all
	 * the operations. During this computation, it keeps track of the maximum value
	 * encountered.
	 * 
	 * Finally, the method returns the maximum value.
	 * 
	 * In the main method, we provide an example n and queries as input. The
	 * arrayManipulation method is called to perform the operations and find the
	 * maximum value, which is then printed.
	 * 
	 * @param n
	 * @param queries
	 * @return
	 */
	public static int arrayManipulation(int n, int[][] queries) {
		int[] arr = new int[n];

		// Perform the operations on the array
		for (int[] query : queries) {
			int startIdx = query[0] - 1;
			int endIdx = query[1] - 1;
			int value = query[2];

			arr[startIdx] += value;

			if (endIdx + 1 < n) {
				arr[endIdx + 1] -= value;
			}
		}

		// Compute the prefix sum to get the actual values in the array
		int max = 0;
		int prefixSum = 0;
		for (int i = 0; i < n; i++) {
			prefixSum += arr[i];
			max = Math.max(max, prefixSum);
		}

		return max;
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] queries = { { 1, 2, 100 }, { 2, 5, 100 }, { 3, 4, 100 } };
		int max = arrayManipulation(n, queries);
		System.out.println("Maximum value: " + max);
	}

	/**
	 * In this updated code, the arrayManipulation method now takes an integer n
	 * representing the size of the array and a List<List<Integer>> called queries
	 * representing the list of operations.
	 * 
	 * The rest of the code remains the same. The method iterates over each query in
	 * queries, performs the operations on the array arr, computes the prefix sum,
	 * and returns the maximum value.
	 * 
	 * In the main method, we provide an example n and queries using the List.of
	 * method to create a list of lists.
	 * 
	 * When you run this code, it will output the same result as before:
	 * 
	 * @param n
	 * @param queries
	 * @return
	 */
	public static int arrayManipulation(int n, List<List<Integer>> queries) {
		int[] arr = new int[n];

		// Perform the operations on the array
		for (List<Integer> query : queries) {
			int startIdx = query.get(0) - 1;
			int endIdx = query.get(1) - 1;
			int value = query.get(2);

			arr[startIdx] += value;

			if (endIdx + 1 < n) {
				arr[endIdx + 1] -= value;
			}
		}

		// Compute the prefix sum to get the actual values in the array
		int max = 0;
		int prefixSum = 0;
		for (int i = 0; i < n; i++) {
			prefixSum += arr[i];
			max = Math.max(max, prefixSum);
		}

		return max;
	}

}
