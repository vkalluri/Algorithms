package com.venkat.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * There will be two arrays of integers. Determine all integers that satisfy the following two conditions:
 *
 * The elements of the first array are all factors of the integer being considered
 * The integer being considered is a factor of all elements of the second array
 * These numbers are referred to as being between the two arrays. Determine how many such numbers exist.
 *
 * Example
 * a = [2, 6]
 * b = [24, 36]
 *
 *
 * There are two numbers between the arrays: 6 and 12.
 * 6%2 = 0, 6%6 = 0, 24%6 =0 and 36%6 = 0 for the first value.
 * 12%2 = 0, 12%6 = 0 and 24%12 = 0, 36%12 = 0 for the second value. Return 2.
 *
 * Function Description
 *
 * Complete the getTotalX function in the editor below. It should return the number of integers that are betwen the sets.
 *
 * getTotalX has the following parameter(s):
 *
 * int a[n]: an array of integers
 * int b[m]: an array of integers
 * Returns
 *
 * int: the number of integers that are between the sets
 * Input Format
 *
 * The first line contains two space-separated integers,  and , the number of elements in arrays  and .
 * The second line contains  distinct space-separated integers a[i] where 0 <= i <= n.
 * The third line contains  distinct space-separated integers b[i] where 0 <= j <= m.
 */
public class BetweenTwoSets {
    /**
     * To solve this problem, we can follow the steps below:
     *
     * Find the maximum value (maxA) in array a and the minimum value (minB) in array b.
     * Initialize a counter variable count to 0.
     * Iterate from maxA to minB.
     * For each integer num in the range, check if it satisfies the conditions:
     * All elements in array a are factors of num (num % a[i] == 0 for all a[i] in array a).
     * num is a factor of all elements in array b (b[i] % num == 0 for all b[i] in array b).
     * If num satisfies both conditions, increment the count variable.
     * Return the value of count.
     * Here's the Java implementation of the getTotalX function:
     * @param a
     * @param b
     * @return
     */
    static int getTotalX(int[] a, int[] b) {
        int maxA = Arrays.stream(a).max().getAsInt();
        int minB = Arrays.stream(b).min().getAsInt();

        int count = 0;
        for (int num = maxA; num <= minB; num++) {
            boolean isFactorOfA = true;
            for (int aVal : a) {
                if (num % aVal != 0) {
                    isFactorOfA = false;
                    break;
                }
            }

            boolean isFactorOfB = true;
            for (int bVal : b) {
                if (bVal % num != 0) {
                    isFactorOfB = false;
                    break;
                }
            }

            if (isFactorOfA && isFactorOfB) {
                count++;
            }
        }

        return count;
    }

    static int getTotalX(List<Integer> a, List<Integer> b) {
        int maxA = Collections.max(a);
        int minB = Collections.max(b);

        int count = 0;
        for (int num = maxA; num <= minB; num++) {
            boolean isFactorOfA = true;
            for (int aVal : a) {
                if (num % aVal != 0) {
                    isFactorOfA = false;
                    break;
                }
            }

            boolean isFactorOfB = true;
            for (int bVal : b) {
                if (bVal % num != 0) {
                    isFactorOfB = false;
                    break;
                }
            }

            if (isFactorOfA && isFactorOfB) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {2, 6};
        int[] b = {24, 36};

        int result = getTotalX(a, b);
        System.out.println(result);
    }
}
