package com.venkat.hackerrank;

import java.util.List;

/**
 * A video player plays a game in which the character competes in a hurdle race. Hurdles are of varying heights,
 * and the characters have a maximum height they can jump. There is a magic potion they can take that will
 * increase their maximum jump height by 1 unit for each dose. How many doses of the potion must the character
 * take to be able to jump all of the hurdles. If the character can already clear all of the hurdles, return 0.
 *
 * Example
 * height = [1,2,3,3,2]
 * k = 1
 *
 * The character can jump 1 unit high initially and must take 3 - 1 = 2 doses of potion to be able to jump all of the hurdles.
 *
 * Function Description
 *
 * Complete the hurdleRace function in the editor below.
 *
 * hurdleRace has the following parameter(s):
 *
 * int k: the height the character can jump naturally
 * int height[n]: the heights of each hurdle
 * Returns
 *
 * int: the minimum number of doses required, always 0 or more
 * Input Format
 *
 * The first line contains two space-separated integers n and k, the number of hurdles and the maximum height the character can jump naturally.
 * The second line contains n space-separated integers heights[i] where 0 <= i <= n.
 *
 * Constraints
 * 1 <= n, k <= 100
 * 1 <= height[i] <= 100
 */
public class HurdleRace {

    /**
     * To determine the minimum number of doses of the potion the character must take to be able
     * to jump all the hurdles, we can iterate through the heights of the hurdles and calculate
     * the maximum height among them. If the maximum height is greater than the character's natural
     * jump height, we subtract the natural jump height from the maximum height and return the result
     * as the number of doses required. Otherwise, we return 0 indicating that no doses are needed.
     * @param k
     * @param height
     * @return
     */
    static int hurdleRace(int k, int[] height) {
        int maxHurdleHeight = 0;
        for (int h : height) {
            if (h > maxHurdleHeight) {
                maxHurdleHeight = h;
            }
        }

        int dosesNeeded = maxHurdleHeight - k;
        if (dosesNeeded > 0) {
            return dosesNeeded;
        } else {
            return 0;
        }
    }

    static int hurdleRace(int k, List<Integer> height) {
        int maxHurdleHeight = 0;
        for (int h : height) {
            if (h > maxHurdleHeight) {
                maxHurdleHeight = h;
            }
        }

        int dosesNeeded = maxHurdleHeight - k;
        if (dosesNeeded > 0) {
            return dosesNeeded;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int k = 1;
        int[] height = {1, 2, 3, 3, 2};

        int doses = hurdleRace(k, height);
        System.out.println("Minimum Doses: " + doses);
    }
}
