package com.venkat.sort;

import java.util.Arrays;

/**
 * Selection Sort is an in-place comparison-based sorting algorithm.
 * It divides the input array into two parts: the subarray of sorted elements
 * and the subarray of unsorted elements. It repeatedly selects the smallest
 * (or largest) element from the unsorted part and swaps it with the first element of the unsorted part.
 */
public class SelectionSort {

	public SelectionSort() {
		// TODO Auto-generated constructor stub
	}
	public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
