package com.venkat.hackerrank;

public class KangarooJump {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Check if the second kangaroo is ahead and has a greater velocity
        if (x2 > x1 && v2 > v1) {
            return "NO";
        }

        // Check if the velocities are different
        if (v1 != v2) {
            // Calculate the number of jumps required for the kangaroos to meet
            if ((x2 - x1) % (v1 - v2) == 0) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        int x1 = 2;
        int v1 = 1;
        int x2 = 1;
        int v2 = 2;

        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
