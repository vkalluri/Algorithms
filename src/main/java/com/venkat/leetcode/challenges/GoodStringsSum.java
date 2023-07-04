package com.venkat.leetcode.challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * words[i] and chars consist of lowercase English letters.
 */
public class GoodStringsSum {

    /**
     * In this program, the countCharacters method takes an array of words and a string of characters as input and
     * returns the sum of lengths of all good strings in the given array. It uses a HashMap to count the frequency
     * of characters in chars, and then checks each word in the array to see if it can be formed using the characters in chars.
     * If a word is a good string, its length is added to the sum. Finally, the program prints the sum of lengths of all good strings.
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters(String[] words, String chars) {
        int sum = 0;

        // Count the frequency of characters in chars
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : chars.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check each word if it can be formed using the characters in chars
        for (String word : words) {
            boolean isGoodString = true;
            Map<Character, Integer> wordCount = new HashMap<>();

            // Count the frequency of characters in the current word
            for (char c : word.toCharArray()) {
                wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
            }

            // Check if the characters in the word can be formed using the characters in chars
            for (char c : wordCount.keySet()) {
                if (!charCount.containsKey(c) || wordCount.get(c) > charCount.get(c)) {
                    isGoodString = false;
                    break;
                }
            }

            // If the word is a good string, add its length to the sum
            if (isGoodString) {
                sum += word.length();
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[] words = {"cat", "hat", "rat"};
        String chars = "chatr";
        int result = countCharacters(words, chars);
        System.out.println("Sum of lengths of all good strings: " + result);
    }
}
