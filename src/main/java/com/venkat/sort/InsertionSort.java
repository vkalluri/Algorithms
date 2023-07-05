package com.venkat.sort;

import java.util.Arrays;

/**
 * Insertion Sort is a simple comparison-based sorting algorithm.
 * It builds the final sorted array one item at a time. It iterates
 * through the array and for each element, it finds the correct position
 * in the sorted subarray and inserts it there by shifting the elements.
 */
public class InsertionSort {

	public InsertionSort() {
		// TODO Auto-generated constructor stub
	}
	public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
