package com.venkat.hackerrank;

public class BeautifulDays {
    public static int countBeautifulDays(int i, int j, int k) {
        int beautifulDays = 0;

        for (int day = i; day <= j; day++) {
            int reverse = reverseNumber(day);
            int difference = Math.abs(day - reverse);

            if (difference % k == 0) {
                beautifulDays++;
            }
        }

        return beautifulDays;
    }

    // Helper method to reverse a number
    private static int reverseNumber(int num) {
        int reverse = 0;

        while (num != 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }

        return reverse;
    }

    public static void main(String[] args) {
        int i = 20;
        int j = 23;
        int k = 6;

        int beautifulDayCount = countBeautifulDays(i, j, k);
        System.out.println("Number of beautiful days: " + beautifulDayCount);
    }
}
