package com.venkat.hackerrank;

/**
 * 
 * Example
 * 
 * 
 * Perform the following steps:
 * 
 * i arr swap (indices) 0 [7, 1, 3, 2, 4, 5, 6] swap (0,3) 1 [2, 1, 3, 7, 4, 5,
 * 6] swap (0,1) 2 [1, 2, 3, 7, 4, 5, 6] swap (3,4) 3 [1, 2, 3, 4, 7, 5, 6] swap
 * (4,5) 4 [1, 2, 3, 4, 5, 7, 6] swap (5,6) 5 [1, 2, 3, 4, 5, 6, 7] It took
 * swaps to sort the array.
 * 
 * Function Description
 * 
 * Complete the function minimumSwaps in the editor below.
 * 
 * minimumSwaps has the following parameter(s):
 * 
 * int arr[n]: an unordered array of integers Returns
 * 
 * int: the minimum number of swaps to sort the array Input Format
 * 
 * The first line contains an integer, , the size of . The second line contains
 * space-separated integers .
 * 
 * Constraints
 * 
 * 
 * @author vkall
 *
 */
public class MinimumSwaps {
	/**
	 * In this code, the minimumSwaps method takes an integer array arr as input and
	 * calculates the minimum number of swaps required to sort the array in
	 * ascending order.
	 * 
	 * The method uses a while loop to iterate over the array. For each element at
	 * index i, it checks if the element is in its correct position (i + 1). If not,
	 * it swaps the element with the element at the correct position and increments
	 * the swaps counter.
	 * 
	 * If the element is already in its correct position, the method simply moves to
	 * the next element by incrementing i.
	 * 
	 * Finally, the method returns the number of swaps.
	 * 
	 * In the main method, we provide an example array arr as input. The
	 * minimumSwaps method is called to calculate the minimum number of swaps and
	 * print the result.
	 * 
	 * @param arr
	 * @return
	 */
	public static int minimumSwaps(int[] arr) {
		int swaps = 0;
		int i = 0;

		// Iterate over the array
		while (i < arr.length) {
			// If the current element is not in its correct position
			if (arr[i] != i + 1) {
				// Swap the element to its correct position
				int temp = arr[i];
				arr[i] = arr[temp - 1];
				arr[temp - 1] = temp;
				swaps++;
			} else {
				i++;
			}
		}

		return swaps;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 1, 3, 2, 4, 5, 6 };
		int minimumSwaps = minimumSwaps(arr);
		System.out.println("Minimum number of swaps: " + minimumSwaps);
	}

}
