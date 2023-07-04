package com.venkat.leetcode.challenges;

import java.util.HashMap;

public class PatternMatching {
	public static boolean isPatternMatch(String pattern, String s) {
		String[] words = s.split(" ");

		if (pattern.length() != words.length) {
			return false; // Different pattern and word count
		}

		HashMap<Character, String> patternMap = new HashMap<>();
		HashMap<String, Character> wordMap = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			String word = words[i];

			if (patternMap.containsKey(c)) {
				if (!patternMap.get(c).equals(word)) {
					return false; // Mismatch in pattern to word mapping
				}
			} else {
				patternMap.put(c, word);
			}

			if (wordMap.containsKey(word)) {
				if (wordMap.get(word) != c) {
					return false; // Mismatch in word to pattern mapping
				}
			} else {
				wordMap.put(word, c);
			}
		}

		return true; // All pattern to word mappings are consistent
	}

	public static void main(String[] args) {
		String pattern = "abba";
		String s = "dog cat cat dog";
		boolean isMatch = isPatternMatch(pattern, s);
		System.out.println("Pattern and String Match? " + isMatch);
	}
}
