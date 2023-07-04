package com.venkat.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * Harold is a kidnapper who wrote a ransom note, but now he is worried it will
 * be traced back to him through his handwriting. He found a magazine and wants
 * to know if he can cut out whole words from it and use them to create an
 * untraceable replica of his ransom note. The words in his note are
 * case-sensitive and he must use only whole words available in the magazine. He
 * cannot use substrings or concatenation to create the words he needs.
 * 
 * Given the words in the magazine and the words in the ransom note, print Yes
 * if he can replicate his ransom note exactly using whole words from the
 * magazine; otherwise, print No.
 * 
 * Example = "attack at dawn" = "Attack at dawn"
 * 
 * The magazine has all the right words, but there is a case mismatch. The
 * answer is .
 * 
 * Function Description
 * 
 * Complete the checkMagazine function in the editor below. It must print if the
 * note can be formed using the magazine, or .
 * 
 * checkMagazine has the following parameters:
 * 
 * string magazine[m]: the words in the magazine string note[n]: the words in
 * the ransom note Prints
 * 
 * string: either or , no return value is expected Input Format
 * 
 * The first line contains two space-separated integers, and , the numbers of
 * words in the and the , respectively. The second line contains space-separated
 * strings, each . The third line contains space-separated strings, each .
 * 
 * @author vkall
 *
 */
public class RansomeNote {
	/**
	 * In this code, the canReplicateRansomNote method takes two arrays of strings,
	 * magazine and ransomNote, as input and returns a boolean indicating whether
	 * Harold can replicate his ransom note or not.
	 * 
	 * The method creates a frequency map called wordFreq to track the count of each
	 * word in the magazine. It iterates over the magazine array, increments the
	 * count of each word in the map, and stores the frequency.
	 * 
	 * Then, it checks each word in the ransomNote array. If a word is not found in
	 * the wordFreq map or its frequency is already zero, it means the word cannot
	 * be formed from the magazine words, and the method returns false. Otherwise,
	 * it decrements the frequency of the used word in the map.
	 * 
	 * If all words in the ransom note can be formed from the magazine words, the
	 * method returns true.
	 * 
	 * In the main method, we provide example arrays magazine and ransomNote. The
	 * canReplicateRansomNote method is called to check if Harold can replicate his
	 * ransom note, and the result is printed accordingly.
	 * 
	 * @param magazine
	 * @param ransomNote
	 * @return
	 */
	public static boolean canReplicateRansomNote(String[] magazine, String[] ransomNote) {
		// Create a frequency map of words in the magazine
		Map<String, Integer> wordFreq = new HashMap<>();
		for (String word : magazine) {
			wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
		}

		// Check if each word in the ransom note can be formed from the magazine words
		for (String word : ransomNote) {
			if (!wordFreq.containsKey(word) || wordFreq.get(word) <= 0) {
				return false; // Word not found or not enough occurrences
			}
			wordFreq.put(word, wordFreq.get(word) - 1); // Decrement the frequency of the used word
		}

		return true; // All words in the ransom note can be formed from the magazine
	}

	public static void main(String[] args) {
		String[] magazine = { "two", "times",  "three",  "is",  "not", "four" };
		String[] ransomNote = { "two", "times", "two", "is", "four"};
		boolean canReplicate = canReplicateRansomNote(magazine, ransomNote);

		if (canReplicate) {
			System.out.println("Yes, Harold can replicate his ransom note.");
		} else {
			System.out.println("No, Harold cannot replicate his ransom note.");
		}
	}
}
