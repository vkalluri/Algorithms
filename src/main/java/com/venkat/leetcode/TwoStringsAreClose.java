package com.venkat.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 *


 Example 1:

 Input: word1 = "abc", word2 = "bca"
 Output: true
 Explanation: You can attain word2 from word1 in 2 operations.
 Apply Operation 1: "abc" -> "acb"
 Apply Operation 1: "acb" -> "bca"
 Example 2:

 Input: word1 = "a", word2 = "aa"
 Output: false
 Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 Example 3:

 Input: word1 = "cabbba", word2 = "abbccc"
 Output: true
 Explanation: You can attain word2 from word1 in 3 operations.
 Apply Operation 1: "cabbba" -> "caabbb"
 Apply Operation 2: "caabbb" -> "baaccc"
 Apply Operation 2: "baaccc" -> "abbccc"


 Constraints:

 1 <= word1.length, word2.length <= 105
 word1 and word2 contain only lowercase English letters.
 */
public class TwoStringsAreClose {

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        // Count character frequencies in word1
        for (char ch : word1.toCharArray()) {
            freq1.put(ch, freq1.getOrDefault(ch, 0) + 1);
        }

        // Count character frequencies in word2
        for (char ch : word2.toCharArray()) {
            freq2.put(ch, freq2.getOrDefault(ch, 0) + 1);
        }

        // Check if character frequencies are the same
        if (!freq1.keySet().equals(freq2.keySet())) {
            return false;
        }

        // Check if character frequencies counts are the same
        if (!freq1.values().equals(freq2.values())) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "bca";
        boolean areClose = closeStrings(word1, word2);
        System.out.println(areClose);  // Output: true
    }
}
