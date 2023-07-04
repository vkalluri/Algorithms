package com.venkat.leetcode.challenges;

/**
 * Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.
 *
 * Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color,
 * so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given
 * a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.
 *
 * Return the minimum time Bob needs to make the rope colorful.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: colors = "abaac", neededTime = [1,2,3,4,5]
 * Output: 3
 * Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
 * Bob can remove the blue balloon at index 2. This takes 3 seconds.
 * There are no longer two consecutive balloons of the same color. Total time = 3.
 * Example 2:
 *
 *
 * Input: colors = "abc", neededTime = [1,2,3]
 * Output: 0
 * Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.
 * Example 3:
 *
 *
 * Input: colors = "aabaa", neededTime = [1,2,3,4,1]
 * Output: 2
 * Explanation: Bob will remove the ballons at indices 0 and 4. Each ballon takes 1 second to remove.
 * There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
 *
 *
 * Constraints:
 *
 * n == colors.length == neededTime.length
 * 1 <= n <= 105
 * 1 <= neededTime[i] <= 104
 * colors contains only lowercase English letters.
 */
public class ColourfulRope {
    /**
     * To make the rope colorful by removing balloons, we can use a dynamic programming approach.
     * We'll create two arrays, dp1 and dp2, to store the minimum time needed to make the rope colorful
     * up to the ith balloon, considering two cases: removing the ith balloon or keeping it.
     *
     * In this code, we iterate through the balloons starting from the second balloon (index 1).
     * For each balloon, we consider two cases:
     *
     * If the current balloon color is the same as the previous one, we have two options:
     * either remove the current balloon or keep it and remove the previous balloon. We choose the option that minimizes the total time.
     *
     * If the current balloon color is different from the previous one, we have to remove the current balloon to maintain colorfulness.
     *
     * We update the dp1 and dp2 arrays accordingly. At the end, we return the minimum time needed to make the rope colorful,
     * which is the minimum of the last balloon removed (dp1[n-1]) or the last balloon kept (dp2[n-1]).
     *
     * In the example code, we calculate the minimum time needed to make the rope colorful for the given colors
     * and neededTime arrays. The output will be the minimum time, in seconds, required to achieve the desired colorfulness.
     *
     * @param colors
     * @param neededTime
     * @return
     */
    public static int minTimeToColorfulRope(String colors, int[] neededTime) {
        int n = colors.length();
        int[] dp1 = new int[n]; // Minimum time if we remove the ith balloon
        int[] dp2 = new int[n]; // Minimum time if we keep the ith balloon

        // Base case
        dp1[0] = neededTime[0];

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // If the current balloon color is the same as the previous one,
                // we can either remove the current balloon or keep it and remove the previous balloon.
                dp1[i] = Math.min(dp1[i - 1], dp2[i - 1] + neededTime[i]);
                dp2[i] = Math.min(dp1[i - 1], dp2[i - 1]);
            } else {
                // If the current balloon color is different from the previous one,
                // we have to remove the current balloon to maintain the colorfulness.
                dp1[i] = dp1[i - 1] + neededTime[i];
                dp2[i] = dp2[i - 1];
            }
        }

        // The minimum time needed to make the rope colorful will be the minimum of
        // the last balloon removed or the last balloon kept.
        return Math.min(dp1[n - 1], dp2[n - 1]);
    }

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = { 1, 2, 3, 4, 5 };
        int minTime = minTimeToColorfulRope(colors, neededTime);
        System.out.println("Minimum time to make the rope colorful: " + minTime + " seconds");
    }
}
