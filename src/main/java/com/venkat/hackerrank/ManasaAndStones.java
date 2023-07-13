package com.venkat.hackerrank;


import java.util.*;

/**
 * Manasa is out on a hike with friends. She finds a trail of stones with numbers on them.
 * She starts following te trail and notices that any two consecutive stones' numbers differ
 * by one of two values. Legend has it that there is a treasure trove at the end of the trail.
 * If Manasa can guess the value of the last stone, the treasure will be hers.
 *
 * Example
 * n = 2
 * a = 2
 * b = 3
 *
 * She finds 2 stones and their differences are  a = 2 or b = 3. We know she starts with a 0
 * stone not included in her count. The permutations of differences for the two stones
 * are [2,2],[2,3],[3,2] or [3,3]. Looking at each scenario, stones might have [2,4],[2,5],[3,5] or [3,6]
 * on them. The last stone might have any of 4,5 or 6 on its face.
 *
 * Compute all possible numbers that might occur on the last stone given a starting stone with a 0 on it,
 * a number of additional stones found, and the possible differences between consecutive stones. Order the list ascending.
 *
 * Function Description
 * Complete the stones function in the editor below.
 *
 * stones has the following parameter(s):
 * int n: the number of non-zero stones
 * int a: one possible integer difference
 * int b: another possible integer difference
 *
 * Returns
 * int[]: all possible values of the last stone, sorted ascending
 * Input Format
 *
 * The first line contains an integer T, the number of test cases.
 *
 * Each test case contains 3 lines:
 * - The first line contains n, the number of non-zero stones found.
 * - The second line contains a, one possible difference
 * - The third line contains b, the other possible difference.
 *
 * Constraints
 * 1 <= T <=10
 * 1 <= n,a,b <= 10^3
 *
 * Sample Input
 *
 * STDIN   Function
 * -----   --------
 * 2       T = 2 (test cases)
 * 3       n = 3 (test case 1)
 * 1       a = 1
 * 2       b = 2
 * 4       n = 4 (test case 2)
 * 10      a = 10
 * 100     b = 100
 * Sample Output
 *
 * 2 3 4
 * 30 120 210 300
 * Explanation
 *
 * With differences 1 and 2, all possible series for the first test case are given below:
 *
 * 0,1,2
 * 0,1,3
 * 0,2,3
 * 0,2,4
 * Hence the answer 2 3 4.
 *
 * With differences 10 and 100, all possible series for the second test case are the following:
 *
 * 0, 10, 20, 30
 * 0, 10, 20, 120
 * 0, 10, 110, 120
 * 0, 10, 110, 210
 * 0, 100, 110, 120
 * 0, 100, 110, 210
 * 0, 100, 200, 210
 * 0, 100, 200, 300
 * Hence the answer 30 120 210 300.
 */
public class ManasaAndStones {

    /**
     * In this implementation, we use a Set to store the possible values of the last stone.
     * We iterate through the stones in the trail, calculating the value of each stone based on
     * the given differences a and b. We add each calculated stone to the set to ensure uniqueness.
     *
     * Finally, we convert the set to an array and sort it in ascending order using Arrays.sort(), and return the sorted array as the result.
     *
     * You can use this stones function in your code to process the test cases and print the sorted list of possible values for the last stone.
     * @param n
     * @param a
     * @param b
     * @return
     */
    public static int[] stones(int n, int a, int b) {
        Set<Integer> lastStones = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int stone = a * (n - 1 - i) + b * i;
            lastStones.add(stone);
        }

        int[] result = new int[lastStones.size()];
        int index = 0;
        for (int stone : lastStones) {
            result[index++] = stone;
        }

        Arrays.sort(result);
        return result;
    }

    public static List<Integer> stones1(int n, int a, int b) {
        Set<Integer> lastStones = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int stone = a * (n - 1 - i) + b * i;
            lastStones.add(stone);
        }

//        Integer[] result = new Integer[lastStones.size()];
//        int index = 0;
//        for (int stone : lastStones) {
//            result[index++] = stone;
//        }

//        Arrays.sort(result);
        List<Integer> resultArray = new ArrayList<>();
        for(int stone : lastStones){
            resultArray.add(stone);
        }
        Collections.sort(resultArray);

        return resultArray;
    }
}
