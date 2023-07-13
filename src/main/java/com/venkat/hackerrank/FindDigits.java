package com.venkat.hackerrank;

/**
 * An integer d is a divisor of an integer n if the remainder of n/d = 0.
 *
 * Given an integer, for each digit that makes up the integer determine whether it is a divisor. Count the number of divisors occurring within the integer.
 *
 * Example
 * n = 124
 *
 * Check whether 1, 2 and 4 are divisors of 124. All 3 numbers divide evenly into 124 so return 3.
 *
 * n = 111
 * Check whether 1, 1, and 1 are divisors of 111. All 3 numbers divide evenly into 111 so return 3.
 *
 * n = 10
 * Check whether 1 and 0 are divisors of 10. 1 is, but 0 is not. Return 1.
 *
 * Function Description
 *
 * Complete the findDigits function in the editor below.
 *
 * findDigits has the following parameter(s):
 *
 * int n: the value to analyze
 * Returns
 *
 * int: the number of digits in  that are divisors of
 * Input Format
 *
 * The first line is an integer, t, the number of test cases.
 * The t subsequent lines each contain an integer, n.
 * Constraints
 *
 * 1 <= t <= 15
 * 0 < n < 10^9
 */
public class FindDigits {

    /**
     * To count the number of divisors occurring within an integer, we can iterate
     * through each digit of the integer and check if it is a divisor of the given number.
     *
     * Here's a Java implementation of the findDigits function:
     * @param n
     * @return
     */
    static int findDigits(int n) {
        int count = 0;
        int num = n;

        while (num > 0) {
            int digit = num % 10;
            if (digit != 0 && n % digit == 0) {
                count++;
            }
            num /= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        int n1 = 124;
        int n2 = 111;
        int n3 = 10;

        int count1 = findDigits(n1);
        int count2 = findDigits(n2);
        int count3 = findDigits(n3);

        System.out.println("Count 1: " + count1);
        System.out.println("Count 2: " + count2);
        System.out.println("Count 3: " + count3);
    }
}
