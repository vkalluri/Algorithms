package com.venkat.leetcode.challenges;

/**
 * 390. Elimination Game
 * Medium
 * 1.3K
 * 645
 * Companies
 * You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order. Apply the following algorithm on arr:
 *
 * Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.
 * Keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * Given the integer n, return the last number that remains in arr.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 9
 * Output: 6
 * Explanation:
 * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * arr = [2, 4, 6, 8]
 * arr = [2, 6]
 * arr = [6]
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 109
 * Accepted
 * 59.7K
 * Submissions
 * 130.1K
 * Acceptance Rate
 * 45.9%
 * Seen this question in a real interview before?
 * 1/4
 * Yes
 * No
 * Discussion (8)
 * Similar Questions
 * Related Topics
 */
public class LeftRemainingNumber {
    /**
     * To find the last number remaining after applying the described algorithm, we can use a mathematical approach.
     *
     * Observations:
     *
     * After each pass from left to right, the remaining numbers are the odd-indexed numbers.
     * After each pass from right to left, the remaining numbers are the even-indexed numbers.
     * Based on these observations, we can deduce that after each complete left-to-right and right-to-left pass, the remaining numbers are halved.
     *
     * In this code, we start with the entire range [1, n]. We maintain the current remaining numbers in the remaining variable.
     * We also keep track of the current step size (step) and the starting position (start). The boolean leftToRight flag
     * indicates whether the current pass is from left to right or right to left.
     *
     * In each iteration, we update the start value based on the direction and whether the remaining count is odd.
     * We then double the step and halve the remaining count. After each iteration, we toggle the leftToRight flag.
     *
     * The process continues until only one number remains, which is the last remaining number after applying the algorithm.
     *
     * In the example code, we find the last remaining number for n = 9. The output will be 6,
     * indicating that 6 is the last number remaining after applying the algorithm.
     *
     * @param n
     * @return
     */
    public static int lastRemaining(int n) {
        int remaining = n;
        int step = 1;
        int start = 1;
        boolean leftToRight = true;

        while (remaining > 1) {
            if (leftToRight || remaining % 2 == 1) {
                start += step;
            }
            step *= 2;
            remaining /= 2;
            leftToRight = !leftToRight;
        }

        return start;
    }

    public static void main(String[] args) {
        int n = 9;
        int result = lastRemaining(n);
        System.out.println("Last remaining number: " + result);
    }
}
