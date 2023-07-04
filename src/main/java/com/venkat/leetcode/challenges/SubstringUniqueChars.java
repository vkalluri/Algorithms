package com.venkat.leetcode.challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Let's define a function countUniqueChars(s) that returns the number of unique characters on s.
 *
 * For example, calling countUniqueChars(s) if s = "LEETCODE" then "L", "T", "C", "O", "D" are the unique characters since they appear only once in s, therefore countUniqueChars(s) = 5.
 * Given a string s, return the sum of countUniqueChars(t) where t is a substring of s. The test cases are generated such that the answer fits in a 32-bit integer.
 *
 * Notice that some substrings can be repeated so in this case you have to count the repeated ones too.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABC"
 * Output: 10
 * Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
 * Every substring is composed with only unique letters.
 * Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
 * Example 2:
 *
 * Input: s = "ABA"
 * Output: 8
 * Explanation: The same as example 1, except countUniqueChars("ABA") = 1.
 * Example 3:
 *
 * Input: s = "LEETCODE"
 * Output: 92
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of uppercase English letters only.
 */
public class SubstringUniqueChars {

    /**
     * To solve this problem, we can use a sliding window approach along with a hashmap to count the unique characters in each substring.
     *
     * In this code, the countUniqueChars function takes a string s as input and counts the number of unique characters in it.
     * We use a hashmap charCount to store the frequency of each character. We iterate through each character in the string
     * and update the frequency in the hashmap. If the frequency of a character is 1, it means it is unique, so we increment the uniqueChars count.
     *
     * The sumOfUniqueCharsSubstring function calculates the sum of countUniqueChars(t) for all substrings t of the given
     * string s. We use a sliding window approach where we start with the substring containing the first character of s,
     * then move the right end of the window one step at a time until the end of s. For each substring,
     * we calculate the count of unique characters using the countUniqueChars function and add it to the sum.
     *
     * In the example code, we calculate the sum of countUniqueChars(t) for all substrings of the string "LEETCODE".
     * The output will be the sum of unique characters in all substrings, which in this case is 5.
     * @param s
     * @return
     */
    public static int countUniqueChars(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        int uniqueChars = 0;

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            if (charCount.get(c) == 1) {
                uniqueChars++;
            }
        }

        return uniqueChars;
    }

    public static int sumOfUniqueCharsSubstring(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> charCount = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                if (charCount.get(c) == 1) {
                    sum += 1;
                } else {
                    break;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String s = "ABC";
        int result = sumOfUniqueCharsSubstring(s);
        System.out.println("Sum of countUniqueChars(t): " + result);
    }
}
