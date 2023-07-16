package com.venkat.leetcode;


/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 *
 *
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
 * and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class Subsequence {

    /**
     * To determine if string s is a subsequence of string t, we can use a two-pointer approach.
     * We'll maintain two pointers, i and j, to iterate through s and t respectively. We'll compare
     * the characters at each position, and if they match, we'll advance both pointers.
     * If they don't match, we'll only advance the j pointer.
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int i = 0; // Pointer for string s
        int j = 0; // Pointer for string t

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // Advance the pointer for s
            }
            j++; // Always advance the pointer for t
        }

        return i == s.length(); // Return true if all characters in s have been matched
    }

    /**
     * In the example above, the first call to isSubsequence returns true because
     * string "abc" is a subsequence of "ahbgdc". The second call returns false because string "axc" is not a subsequence of "ahbgdc".
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "abc";
        String t1 = "ahbgdc";
        boolean result1 = isSubsequence(s1, t1);
        System.out.println(result1);  // Output: true

        String s2 = "axc";
        String t2 = "ahbgdc";
        boolean result2 = isSubsequence(s2, t2);
        System.out.println(result2);  // Output: false
    }
}
