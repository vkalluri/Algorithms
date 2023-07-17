package com.venkat.leetcode;


import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces,
 * square brackets are well-formed, etc. Furthermore, you may assume that the original
 * data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
public class DecodeString {

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(ch);
            } else {
                // Retrieve the encoded string
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    sb.insert(0, stack.pop());
                }
                stack.pop();  // Pop the '['

                // Retrieve the repeat count
                StringBuilder countBuilder = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    countBuilder.insert(0, stack.pop());
                }
                int count = Integer.parseInt(countBuilder.toString());

                // Repeat the decoded string and push it back onto the stack
                String decodedString = sb.toString().repeat(count);
                for (char decodedCh : decodedString.toCharArray()) {
                    stack.push(decodedCh);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String encodedString = "3[a]2[bc]";
        String decodedString = decodeString(encodedString);
        System.out.println(decodedString);  // Output: "aaabcbc"
    }
}
