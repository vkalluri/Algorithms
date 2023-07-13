package com.venkat.leetcode;

public class LongestPalindrome {

    /**
     * In this implementation, we use dynamic programming to find the longest
     * palindromic substring. We create a 2D boolean array dp of size n x n,
     * where dp[i][j] represents whether the substring from index i to index j is a palindrome.
     *
     * We start by marking all substrings of length 1 as palindromes.
     * Then, we check for substrings of length 2 and update dp accordingly.
     *
     * Next, we iterate over all substrings of length greater than 2. For each substring,
     * we check if the first and last characters are the same, and if the substring within
     * them is a palindrome. If both conditions are true, we mark dp[i][j] as true.
     *
     * During the iteration, we keep track of the starting index and length of the longest palindromic substring found so far.
     *
     * Finally, we return the substring of the original string s from the starting index to the starting index plus the maximum length.
     *
     * You can use this solution by creating an instance of the Solution class and calling
     * the longestPalindrome method with the input string s. The method will return the longest palindromic substring in s.
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        int start = 0;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for substrings of length greater than 2
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = length;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("ccc"));
    }
}
