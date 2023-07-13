package com.venkat.hackerrank;

public class LoveLetterPalindrome {

    public static int minOperationsToPalindrome(String s) {
        int operations = 0;
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char leftChar = s.charAt(i);
            char rightChar = s.charAt(j);

            if (leftChar != rightChar) {
                // Calculate the absolute difference between the characters
                int diff = Math.abs(leftChar - rightChar);
                operations += diff;
            }

            i++;
            j--;
        }

        return operations;
    }

    public static void main(String[] args) {
        String s = "abcd";

        int minOperations = minOperationsToPalindrome(s);
        System.out.println("Minimum operations required: " + minOperations);
    }
}
