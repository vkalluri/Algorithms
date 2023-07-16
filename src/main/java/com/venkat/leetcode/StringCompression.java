package com.venkat.leetcode;

import java.util.HashMap;
import java.util.Map;;

/**
 * 443. String Compression
 * Medium
 * 4K
 * 6.3K
 * Companies
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 *
 * After you are done modifying the input array, return the new length of the array.
 *
 * You must write an algorithm that uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 * Example 2:
 *
 * Input: chars = ["a"]
 * Output: Return 1, and the first character of the input array should be: ["a"]
 * Explanation: The only group is "a", which remains uncompressed since it's a single character.
 * Example 3:
 *
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 *
 *
 * Constraints:
 *
 * 1 <= chars.length <= 2000
 * chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
 */

public class StringCompression {
    public static int compress(char[] chars) {

//        Map<Character, Integer> charMap = new HashMap<>();
//
//        for(char c : chars){
//            charMap.put(c, charMap.getOrDefault(c, 1) );
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
//            sb.append(entry.getKey());
//            sb.append(entry.getValue());
//        }
//        System.out.println(sb);
//        return sb.length();
//
////        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
//
////        return

        int write = 0; // Pointer to write the compressed string
        int anchor = 0; // Pointer to mark the start of a group

        for (int read = 0; read < chars.length; read++) {
            // Check if we've reached the end of the group or the end of the array
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor]; // Write the character

                if (read > anchor) {
                    // Write the group length (if it's greater than 1)
                    String count = String.valueOf(read - anchor + 1);
                    for (char c : count.toCharArray()) {
                        chars[write++] = c;
                    }
                }

                anchor = read + 1; // Move the anchor to the next group
            }
        }

        return write; // Return the new length of the array
    }

    public static int compress1(char[] chars) {
        int n = chars.length;
        int write = 0; // Pointer to write the compressed array
        int count = 0; // Counter for consecutive repeating characters

        for (int read = 0; read < n; read++) {
            count++;

            // Check if the next character is different or we've reached the end of the array
            if (read + 1 == n || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read]; // Write the character

                // Write the count if it's greater than 1
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[write++] = c;
                    }
                }

                count = 0; // Reset the count for the next group
            }
        }

        return write; // Return the new length of the array
    }

    public static void main(String[] arggs){
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress1(chars));

        char[] chars1 = {'a'};
        System.out.println(compress1(chars1));

        char[] chars2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress1(chars2));
    }
}
