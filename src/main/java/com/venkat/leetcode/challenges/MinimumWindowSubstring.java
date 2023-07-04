package com.venkat.leetcode.challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window. If there is no such substring, return the empty
 * string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC" Output: "BANC" Explanation: The minimum
 * window substring "BANC" includes 'A', 'B', and 'C' from string t. Example 2:
 * 
 * Input: s = "a", t = "a" Output: "a" Explanation: The entire string s is the
 * minimum window. Example 3:
 * 
 * Input: s = "a", t = "aa" Output: "" Explanation: Both 'a's from t must be
 * included in the window. Since the largest window of s only has one 'a',
 * return empty string.
 * 
 * @author vkall
 *
 */
public class MinimumWindowSubstring {

	/**
	 * In this code, the minWindowSubstring method takes two input strings, s and t,
	 * representing the main string and the target string, respectively. It returns
	 * the minimum window substring that contains all characters from t in s.
	 * 
	 * The algorithm initializes a sliding window defined by the left and right
	 * indices. It uses a targetCount map to keep track of the frequency of
	 * characters in the target string t. The count variable tracks the number of
	 * characters remaining to be found in the current window.
	 * 
	 * The algorithm iterates through the main string s using the right pointer,
	 * updating the targetCount and count as it encounters characters. When the
	 * current window contains all the characters from t, it updates the minimum
	 * window length and moves the left pointer to potentially find a smaller
	 * window. This process continues until the right pointer reaches the end of the
	 * main string.
	 * 
	 * Finally, the algorithm returns the minimum window substring found in s. If no
	 * such substring is found, an empty string is returned.
	 * 
	 * In the main method, an example is provided to demonstrate the usage of the
	 * minWindowSubstring function. It finds the minimum window substring containing
	 * all characters from the target string "ABC" in the main string
	 * "ADOBECODEBANC" and prints the result to the console.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static String minWindowSubstring(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0 || t.length() > s.length()) {
			return "";
		}

		Map<Character, Integer> targetCount = new HashMap<>();
		for (char c : t.toCharArray()) {
			targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
		}

		int left = 0;
		int right = 0;
		int minLength = Integer.MAX_VALUE;
		int minLeft = 0;
		int count = t.length();

		while (right < s.length()) {
			char rightChar = s.charAt(right);
			if (targetCount.containsKey(rightChar)) {
				if (targetCount.get(rightChar) > 0) {
					count--;
				}
				targetCount.put(rightChar, targetCount.get(rightChar) - 1);
			}
			right++;

			while (count == 0) {
				if (right - left < minLength) {
					minLength = right - left;
					minLeft = left;
				}

				char leftChar = s.charAt(left);
				if (targetCount.containsKey(leftChar)) {
					targetCount.put(leftChar, targetCount.get(leftChar) + 1);
					if (targetCount.get(leftChar) > 0) {
						count++;
					}
				}
				left++;
			}
		}

		if (minLength == Integer.MAX_VALUE) {
			return "";
		}

		return s.substring(minLeft, minLeft + minLength);
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String minWindow = minWindowSubstring(s, t);
		System.out.println("Minimum Window Substring: " + minWindow);
	}
}
