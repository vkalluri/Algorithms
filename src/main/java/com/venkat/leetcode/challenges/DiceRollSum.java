package com.venkat.leetcode.challenges;

/**
 * You have n dice, and each die has k faces numbered from 1 to k.
 *
 * Given three integers n, k, and target, return the number of possible ways (out of the kn total ways)
 * to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1, k = 6, target = 3
 * Output: 1
 * Explanation: You throw one die with 6 faces.
 * There is only one way to get a sum of 3.
 * Example 2:
 *
 * Input: n = 2, k = 6, target = 7
 * Output: 6
 * Explanation: You throw two dice, each with 6 faces.
 * There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 * Example 3:
 *
 * Input: n = 30, k = 30, target = 500
 * Output: 222616187
 * Explanation: The answer must be returned modulo 109 + 7.
 *
 *
 * Constraints:
 *
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 */
public class DiceRollSum {
    /**
     * To solve this problem, we can use dynamic programming. Let's create a Java program that calculates the number of possible ways to roll the dice and get a target sum.
     *
     * In this program, the numRollsToTarget method takes three integers n, k, and target as input and returns the number of possible
     * ways to roll the dice and get the target sum. It uses a 2D array dp to store the number of ways for each number of dice and target sum.
     * The base case is initialized with dp[0][0] = 1. Then, it iterates over the number of dice and the target sum, calculating the number
     * of ways by considering all possible face values for the current dice. The modulo operation is performed to keep the result within the range.
     * Finally, the program prints the number of possible ways to get the target sum.
     *
     * @param n
     * @param k
     * @param target
     * @return
     */
    public static int numRollsToTarget(int n, int k, int target) {
        int MOD = 1000000007;

        // Create a 2D array to store the number of ways to reach a target sum
        int[][] dp = new int[n + 1][target + 1];

        // Initialize the base case where there are no dice
        dp[0][0] = 1;

        // Calculate the number of ways for each number of dice and target sum
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // Calculate the number of ways using the current dice
                for (int face = 1; face <= k; face++) {
                    if (j >= face) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - face]) % MOD;
                    } else {
                        // If the target is less than the face value, break the loop
                        break;
                    }
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int n = 2;
        int k = 6;
        int target = 7;
        int result = numRollsToTarget(n, k, target);
        System.out.println("Number of possible ways: " + result);
    }
}
