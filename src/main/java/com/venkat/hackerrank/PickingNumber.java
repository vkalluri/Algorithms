package com.venkat.hackerrank;


import java.util.List;

/**
 * Given an array of integers, find the longest subarray where the
 * absolute difference between any two elements is less than or equal to 1.
 *
 * Example
 * a = [1,1,2,2,4,4,5,5,5]
 *
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
 * 0 <= a[i] <= 100
 * The answer will be >=2.
 */
public class PickingNumber {

    /**
     * To find the length of the longest subarray where the absolute difference between
     * any two elements is less than or equal to 1, we can use a frequency count approach.
     *
     * First, we'll create a frequency array to count the occurrences of each element
     * in the input array a. We'll iterate through a and increment the count for each element in the frequency array.
     *
     * Next, we'll iterate through the frequency array and calculate the length of the
     * longest subarray satisfying the given criterion. For each element in the frequency array,
     * we'll check the counts of the current element and its adjacent element (i.e., current element - 1
     * and current element + 1). We'll keep track of the maximum length found so far.
     *
     *
     * @param a
     * @return
     */
    public static int pickingNumbers(int[] a) {
        int[] frequency = new int[101];

        // Count the occurrences of each element
        for (int num : a) {
            frequency[num]++;
        }

        int maxLength = 0;

        // Calculate the length of the longest subarray
        for (int i = 1; i <= 100; i++) {
            maxLength = Math.max(maxLength, frequency[i] + frequency[i - 1]);
        }

        return maxLength;
    }

    public static int pickingNumbers(List<Integer> a) {
        int[] frequency = new int[101];

        // Count the occurrences of each element
        for (int num : a) {
            frequency[num]++;
        }

        int maxLength = 0;

        // Calculate the length of the longest subarray
        for (int i = 1; i <= 100; i++) {
            maxLength = Math.max(maxLength, frequency[i] + frequency[i - 1]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 4, 4, 5, 5, 5};
        int maxLength = pickingNumbers(a);
        System.out.println(maxLength);

        System.out.println(pickingNumbers(List.of(1, 1, 2, 2, 4, 4, 5, 5, 5)));
        // Output: 5
    }
}
