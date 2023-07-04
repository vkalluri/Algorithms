package com.venkat.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * Two strings are anagrams of each other if the letters of one string can be
 * rearranged to form the other string. Given a string, find the number of pairs
 * of substrings of the string that are anagrams of each other.
 * 
 * Example
 * 
 * The list of all anagrammatic pairs is at positions respectively.
 * 
 * Function Description
 * 
 * Complete the function sherlockAndAnagrams in the editor below.
 * 
 * sherlockAndAnagrams has the following parameter(s):
 * 
 * string s: a string Returns
 * 
 * int: the number of unordered anagrammatic pairs of substrings in Input Format
 * 
 * The first line contains an integer , the number of queries. Each of the next
 * lines contains a string to analyze.
 * 
 * @author vkall
 *
 */
public class ShelockAndAnagrams {

	/**
	 * In this code, the countAnagramSubstringPairs method takes a string s as input
	 * and returns the number of pairs of substrings that are anagrams of each
	 * other.
	 * 
	 * The method uses two nested loops to iterate through all possible substrings
	 * of s. For each substring, it creates a map called freqMap to store the
	 * frequency of characters in that substring.
	 * 
	 * The code checks if the freqMap has occurred before as an anagram substring by
	 * checking if it exists in the substrFreq map. If it does, the count of anagram
	 * pairs is incremented by the value associated with that freqMap in substrFreq.
	 * 
	 * Finally, the count of anagram substring pairs is updated by incrementing the
	 * value associated with the current freqMap in substrFreq.
	 * 
	 * In the main method, we provide an example string s. The
	 * countAnagramSubstringPairs method is called to calculate the number of
	 * anagram substring pairs, and the result is printed.
	 * 
	 * @param s
	 * @return
	 */
	public static int countAnagramSubstringPairs(String s) {
		// Create a map to store the frequency of each substring's characters
		Map<Map<Character, Integer>, Integer> substrFreq = new HashMap<>();

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			// Create a map to store the frequency of characters in the current substring
			Map<Character, Integer> freqMap = new HashMap<>();

			for (int j = i; j < s.length(); j++) {
				// Add each character to the frequency map
				char c = s.charAt(j);
				freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

				// Check if the same substring has occurred before as an anagram
				if (substrFreq.containsKey(freqMap)) {
					count += substrFreq.get(freqMap);
				}

				// Increment the count for the current substring's anagrams
				substrFreq.put(freqMap, substrFreq.getOrDefault(freqMap, 0) + 1);
			}
		}

		return count;
	}

	public static void main(String[] args) {
		String s = "ifailuhkqq";
		int pairCount = countAnagramSubstringPairs(s);
		System.out.println("Number of anagram substring pairs: " + pairCount);
	}

}
