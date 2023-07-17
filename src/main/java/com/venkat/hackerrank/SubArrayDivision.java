package com.venkat.hackerrank;


import java.util.Arrays;
import java.util.List;

/**
 * Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.
 *
 * Lily decides to share a contiguous segment of the bar selected such that:
 *
 * The length of the segment matches Ron's birth month, and,
 * The sum of the integers on the squares is equal to his birth day.
 * Determine how many ways she can divide the chocolate.
 *
 * Example
 * S = [2,2,1,3,2]
 * d = 4
 * m = 2
 *
 * Lily wants to find segments summing to Ron's birth day, d = 4 with a length equalling his birth month,
 * m = 2. In this case, there are two segments meeting her criteria: [2,2] and [1,3].
 *
 * Function Description
 *
 * Complete the birthday function in the editor below.
 *
 * birthday has the following parameter(s):
 *
 * int s[n]: the numbers on each of the squares of chocolate
 * int d: Ron's birth day
 * int m: Ron's birth month
 * Returns
 *
 * int: the number of ways the bar can be divided
 * Input Format
 * The first line contains an integer n, the number of squares in the chocolate bar.
 * The second line contains n space-separated integers s[i], the numbers on the chocolate squares where 0 <= i <= n.
 * The third line contains two space-separated integers, d and m, Ron's birth day and his birth month.
 *
 * Constraints
 * 1 <= n <= 100
 * 1 <= s[i] <= 5, where(0 <= i <= n)
 * 1 <= d <= 31
 * 1 <= m <= 12
 */
public class SubArrayDivision {

    /**
     * To determine the number of ways Lily can divide the chocolate bar according
     * to the given criteria, we can use a sliding window approach.
     *
     * We'll maintain a sliding window of length m and move it through the chocolate
     * bar array. For each position of the window, we'll check if the sum of the integers
     * within the window is equal to Ron's birth day. If it is, we'll increment a counter variable.
     *
     *
     * @param s
     * @param d
     * @param m
     * @return
     */
    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int sum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.size(); windowEnd++) {
            sum += s.get(windowEnd);

            if (windowEnd >= m - 1) {
                if (sum == d) {
                    count++;
                }

                sum -= s.get(windowStart);
                windowStart++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(2, 2, 1, 3, 2);
        int d = 4;
        int m = 2;
        int result = birthday(s, d, m);
        System.out.println(result);  // Output: 2
    }
}
