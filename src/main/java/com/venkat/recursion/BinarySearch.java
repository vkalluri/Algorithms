package com.venkat.recursion;

public class BinarySearch {

	public BinarySearch() {
		// TODO Auto-generated constructor stub
	}
	public static int binarySearch(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, low, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
        int target = 10;
        int result = binarySearch(arr, target, 0, arr.length - 1);
        System.out.println("Element " + target + " found at index: " + result);
    }
}
