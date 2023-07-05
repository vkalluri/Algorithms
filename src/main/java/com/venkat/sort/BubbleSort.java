package com.venkat.sort;

import java.util.Arrays;

/**
 * Bubble Sort is a simple comparison-based sorting algorithm. It repeatedly compares adjacent
 * elements and swaps them if they are in the wrong order. The pass-through the array is
 * repeated until the array is sorted. It is called "Bubble Sort" because smaller elements
 * "bubble" to the top of the array in each iteration.
 */
public class BubbleSort {

	public BubbleSort() {
		// TODO Auto-generated constructor stub
	}
	 public static void bubbleSort(int[] arr) {
	        int n = arr.length;
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                if (arr[j] > arr[j + 1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {64, 34, 25, 12, 22, 11, 90};
	        bubbleSort(arr);
	        System.out.println("Sorted array: " + Arrays.toString(arr));
	    }
}
