package com.venkat.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * . Longest Substring Without Repeating Characters
 * Medium
 * 35.3K
 * 1.6K
 * Companies
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubString {

    /**
     * In this implementation, we use a sliding window approach to find the longest
     * substring without repeating characters. We maintain two pointers, start and end, which define the current window.
     *
     * We iterate through the string from left to right, and for each character c,
     * we check if it is already present in the current window. If c is already in the window,
     * it means we have a repeating character. In that case, we update the start pointer to
     * the position just after the last occurrence of c in the window.
     *
     * We also update the charMap with the current character c and its corresponding index end.
     * The charMap is used to store the most recent occurrence of each character encountered so far.
     *
     * After each iteration, we calculate the length of the current substring by subtracting
     * the start pointer from the end pointer, and update the maxLength if necessary.
     *
     * Finally, we return the maxLength as the length of the longest substring without repeating characters.
     *
     * You can use this solution by creating an instance of the Solution class and calling
     * the lengthOfLongestSubstring method with the input string s. The method will return the length of the longest substring without repeating characters.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (charMap.containsKey(c)) {
                start = Math.max(start, charMap.get(c) + 1);
            }

            charMap.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
