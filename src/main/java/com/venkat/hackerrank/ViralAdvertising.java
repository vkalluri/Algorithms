package com.venkat.hackerrank;


/**
 * HackerLand Enterprise is adopting a new viral advertising strategy. When they launch a new product,
 * they advertise it to exactly 5 people on social media.
 *
 * On the first day, half of those  people (i.e., floor(5/2) = 2) like the advertisement and each
 * shares it with 3 of their friends. At the beginning of the second day, floor(5/2)*3 = 2*3 = 6
 * people receive the advertisement.
 *
 * Each day, floor(recipients/2) of the recipients like the advertisement and will share it with
 * 3 friends on the following day. Assuming nobody receives the advertisement twice, determine
 * how many people have liked the ad by the end of a given day, beginning with launch day as day 1.
 *
 * Example
 * n = 5.
 *
 * Day Shared Liked Cumulative
 * 1      5     2       2
 * 2      6     3       5
 * 3      9     4       9
 * 4     12     6      15
 * 5     18     9      24
 * The progression is shown above. The cumulative number of likes on the 5th day is 24.
 *
 * Function Description
 * Complete the viralAdvertising function in the editor below.
 *
 * viralAdvertising has the following parameter(s):
 * int n: the day number to report
 *
 * Returns
 * int: the cumulative likes at that day
 *
 * Input Format
 * A single integer, n, the day number.
 *
 * Constraints
 * 1 <= n <= 50
 */
public class ViralAdvertising {


    /**
     * To calculate the cumulative number of likes on a given day, we can use a loop
     * to simulate the viral advertising strategy for each day. We start with 5 people
     * on the first day, and then for each subsequent day, we calculate the number
     * of people who will like the advertisement and share it with their friends.
     *
     * The viralAdvertising method calculates the cumulative number of likes on the
     * given day n. The main method calls this function with n = 5 and prints the output,
     * which should be 24, as shown in the example. The function can be used with
     * any value of n in the range from 1 to 50.
     *
     *
     * @param n
     * @return
     */
    public static int viralAdvertising(int n) {
        int shared = 5;
        int cumulativeLikes = 0;

        for (int day = 1; day <= n; day++) {
            int liked = shared / 2;
            cumulativeLikes += liked;
            shared = liked * 3;
        }

        return cumulativeLikes;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(viralAdvertising(n)); // Output: 24
    }
}
