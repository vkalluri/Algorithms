package com.venkat.hackerrank;


import java.util.List;

/**
 * Given an array of integers and a positive integer k, determine the number of (i,j) pairs where i<j and ar[i] + ar[j] is divisible by k.
 *
 * Example
 * ar = [1,2,3,4,5,6]
 * k = 5
 *
 *
 * Three pairs meet the criteria: [1,4], [2,3] and [4,6].
 *
 * Function Description
 * Complete the divisibleSumPairs function in the editor below.
 *
 * divisibleSumPairs has the following parameter(s):
 *
 * int n: the length of array ar
 * int ar[n]: an array of integers
 * int k: the integer divisor
 * Returns
 * - int: the number of pairs
 *
 * Input Format
 * The first line contains 2 space-separated integers, n and k.
 * The second line contains n space-separated integers, each a value of arr[i].
 *
 * Constraints
 * 2 <= n <= 100
 * 1 <= k <= 100
 * 1 <= ar[i] <= 100
 */
public class DivisibleSumPairs {

    /**
     * To determine the number of pairs (i, j) where i < j and ar[i] + ar[j] is divisible by k,
     * we can use a nested loop to iterate through all possible pairs and count the pairs that satisfy the given condition.
     *
     * We initialize count as 0 to keep track of the number of pairs that satisfy the condition.
     *
     * We use nested loops to iterate through all possible pairs (i, j), where i < j. For each pair,
     * we check if the sum of ar[i] and ar[j] is divisible by k using the modulo operator. If the condition is satisfied, we increment count by 1.
     *
     * After iterating through all possible pairs, we return the final value of count,
     * which represents the number of pairs that meet the given condition.
     *
     * In the main method, we create an example array ar, length n, and divisor k.
     * We call the divisibleSumPairs method to calculate the number of pairs and print the result.
     *
     * Note: This solution assumes that the input array ar is not null and contains at least two elements.
     * Make sure to handle potential exceptions and edge cases in a production-level implementation.
     *
     * @param n
     * @param ar
     * @param k
     * @return
     */
    static int divisibleSumPairs(int n, int[] ar, int k) {
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar[i] + ar[j]) % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    static int divisibleSumPairs(int n,  int k, List<Integer> ar) {
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar.get(i) + ar.get(j)) % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] ar = {1, 2, 3, 4, 5, 6};
        int k = 5;

        int pairCount = divisibleSumPairs(n, ar, k);
        System.out.println("Number of Pairs: " + pairCount);
        List<Integer> arr = List.of(1,3,2,6,1,2);
        System.out.println(divisibleSumPairs(6, 3, arr));
    }
}
