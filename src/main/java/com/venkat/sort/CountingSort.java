package com.venkat.sort;

import java.util.Arrays;

/**
 * Counting Sort is an integer sorting algorithm that works by counting the number
 * of occurrences of each distinct element in the input array and using this
 * information to determine the sorted order. It requires knowledge of the range
 * of input values and uses additional memory to store the counts.
 */
public class CountingSort {
    public static void countingSort(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];

        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
