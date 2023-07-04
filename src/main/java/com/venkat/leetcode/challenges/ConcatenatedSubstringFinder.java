package com.venkat.leetcode.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string s and an array of strings words. All the strings of
 * words are of the same length.
 * 
 * A concatenated substring in s is a substring that contains all the strings of
 * any permutation of words concatenated.
 * 
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef",
 * "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is
 * not a concatenated substring because it is not the concatenation of any
 * permutation of words. Return the starting indices of all the concatenated
 * substrings in s. You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
 * Explanation: Since words.length == 2 and words[i].length == 3, the
 * concatenated substring has to be of length 6. The substring starting at 0 is
 * "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of
 * words. The substring starting at 9 is "foobar". It is the concatenation of
 * ["foo","bar"] which is a permutation of words. The output order does not
 * matter. Returning [9,0] is fine too. Example 2:
 * 
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: [] Explanation: Since words.length == 4 and words[i].length == 4, the
 * concatenated substring has to be of length 16. There is no substring of
 * length 16 is s that is equal to the concatenation of any permutation of
 * words. We return an empty array. Example 3:
 * 
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"] Output:
 * [6,9,12] Explanation: Since words.length == 3 and words[i].length == 3, the
 * concatenated substring has to be of length 9. The substring starting at 6 is
 * "foobarthe". It is the concatenation of ["foo","bar","the"] which is a
 * permutation of words. The substring starting at 9 is "barthefoo". It is the
 * concatenation of ["bar","the","foo"] which is a permutation of words. The
 * substring starting at 12 is "thefoobar". It is the concatenation of
 * ["the","foo","bar"] which is a permutation of words.
 * 
 * @author vkall
 *
 */
public class ConcatenatedSubstringFinder {
	/**
	 * To find concatenated substrings in a given string s, we can use a sliding
	 * window approach along with a frequency count. Here's a step-by-step algorithm
	 * to solve the problem:
	 * 
	 * Initialize an empty list result to store the indices of the concatenated
	 * substrings found. If the words array is empty or the length of s is less than
	 * the combined length of all the strings in words, return an empty list. Create
	 * a dictionary word_count to store the frequency of each word in words.
	 * Determine the length of a single word in words. Let's call it word_length.
	 * Iterate over each possible starting index, start, of the window in s up to
	 * len(s) - (len(words) * word_length) + 1: 6. Create a copy of the word_count
	 * dictionary, called seen_count, to keep track of the frequency of words seen
	 * in the current window. Initialize a variable matched to 0, which counts the
	 * number of words matched so far. Iterate over each possible word index, i,
	 * within the current window: 9. Extract the substring from s starting at start
	 * + i * word_length with a length of word_length. Let's call it current_word.
	 * If current_word is not present in word_count, break the loop since it is not
	 * a valid word. Increment the frequency count of current_word in seen_count and
	 * check if its frequency exceeds the expected count in word_count. If it does,
	 * break the loop. Increment matched by 1. If matched is equal to the length of
	 * words, it means we have found a concatenated substring. Add the starting
	 * index, start, to the result list. Return the result list containing the
	 * starting indices of all concatenated substrings.
	 * 
	 * @param s
	 * @param words
	 * @return
	 */
	public static List<Integer> findConcatenatedSubstrings(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if (words == null || words.length == 0 || s.length() < words.length * words[0].length()) {
			return result;
		}

		Map<String, Integer> wordCount = new HashMap<>();
		for (String word : words) {
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}

		int wordLength = words[0].length();
		int totalLength = words.length * wordLength;

		for (int start = 0; start <= s.length() - totalLength; start++) {
			Map<String, Integer> seenCount = new HashMap<>(wordCount);
			int matched = 0;

			for (int i = 0; i < words.length; i++) {
				String currentWord = s.substring(start + i * wordLength, start + (i + 1) * wordLength);

				if (!wordCount.containsKey(currentWord) || seenCount.getOrDefault(currentWord, 0) == 0) {
					break;
				}

				seenCount.put(currentWord, seenCount.get(currentWord) - 1);
				matched++;

				if (matched == words.length) {
					result.add(start);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = { "foo", "bar" };
		List<Integer> indices = findConcatenatedSubstrings(s, words);

		if (indices.isEmpty()) {
			System.out.println("No concatenated substrings found.");
		} else {
			System.out.println("Concatenated substrings found at indices: " + indices);
		}
	}
}
