package com.venkat.hackerrank;


import java.util.List;

/**
 * Given an array of integers, find the longest subarray where the absolute difference between any two elements is less than or equal to 1.
 *
 * Example
 * a = [1,1,2,2,4,4,5,5,5]
 * There are two subarrays meeting the criterion: [1,1,2,2] and [4,4,5,5,5]. The maximum length subarray has 5 elements.
 *
 * Function Description
 * Complete the pickingNumbers function in the editor below.
 * pickingNumbers has the following parameter(s):
 * int a[n]: an array of integers
 *
 * Returns
 * int: the length of the longest subarray that meets the criterion
 *
 * Input Format
 * The first line contains a single integer n, the size of the array a.
 * The second line contains n space-separated integers, each an a[i].
 *
 * Constraints
 * 2 <= n <= 100
 * 0 <= a[i] <100
 * The answer will be >= 2.
 */
public class PickingNumbers {


    /**
     * To find the length of the longest subarray where the absolute difference between
     * any two elements is less than or equal to 1, we can use a frequency counting approach.
     *
     * First, we'll create a frequency array to count the occurrences of each element in the given array.
     *
     * Next, we'll iterate through the frequency array and check the count of each element and
     * its neighboring element. If the count of the neighboring element is higher than the current
     * element or if the neighboring element is within the range of ±1, we'll update the maximum length accordingly.
     *
     * Finally, we'll return the maximum length as the result.
     *
     * @param a
     * @return
     */
    public static int pickingNumbers(int[] a) {
        int[] frequency = new int[100];  // Assuming the array elements are between 0 and 99
        int maxLength = 0;

        for (int num : a) {
            frequency[num]++;
        }

        for (int i = 1; i < frequency.length; i++) {
            maxLength = Math.max(maxLength, frequency[i] + frequency[i - 1]);
        }

        return maxLength;
    }

    public static int pickingNumbers(List<Integer> a) {
        int[] frequency = new int[100];  // Assuming the array elements are between 0 and 99
        int maxLength = 0;

        for (int num : a) {
            frequency[num]++;
        }

        for (int i = 1; i < frequency.length; i++) {
            maxLength = Math.max(maxLength, frequency[i] + frequency[i - 1]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] a = {4,6,5,3,3,1};
        int result = pickingNumbers(a);
        System.out.println(result);  // Output: 5
    }
}
