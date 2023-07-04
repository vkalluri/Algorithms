package com.venkat.hackerrank;

/**
 * Given two strings, determine if they share a common substring. A substring
 * may be as small as one character.
 * 
 * Example
 * 
 * 
 * These share the common substring .
 * 
 * 
 * 
 * These do not share a substring.
 * 
 * Function Description
 * 
 * Complete the function twoStrings in the editor below.
 * 
 * twoStrings has the following parameter(s):
 * 
 * string s1: a string string s2: another string Returns
 * 
 * string: either YES or NO Input Format
 * 
 * The first line contains a single integer , the number of test cases.
 * 
 * The following pairs of lines are as follows:
 * 
 * The first line contains string . The second line contains string .
 * 
 * @author vkall
 *
 */
public class CommonSubstring {
	/**
	 * In this code, the shareCommonSubstring method takes two strings, s1 and s2,
	 * as input and returns a boolean indicating whether they share a common
	 * substring or not.
	 * 
	 * The method creates a boolean array called present of size 26 (assuming
	 * lowercase English letters). It initializes all elements of the array to
	 * false.
	 * 
	 * Next, it iterates over each character in s1 and marks the corresponding index
	 * in the present array as true.
	 * 
	 * Then, it checks each character in s2 and compares it with the present array.
	 * If a character from s2 is found in s1, it means there is a common substring,
	 * and the method returns true.
	 * 
	 * If no common substring is found after checking all characters in s2, the
	 * method returns false.
	 * 
	 * In the main method, we provide example strings s1 and s2. The
	 * shareCommonSubstring method is called to check if they share a common
	 * substring, and the result is printed accordingly.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean shareCommonSubstring(String s1, String s2) {
		// Create a boolean array to track characters present in s1
		boolean[] present = new boolean[26]; // Assuming lowercase English letters

		// Mark characters from s1 as present
		for (int i = 0; i < s1.length(); i++) {
			present[s1.charAt(i) - 'a'] = true;
		}

		// Check if any character from s2 is present in s1
		for (int i = 0; i < s2.length(); i++) {
			if (present[s2.charAt(i) - 'a']) {
				return true; // Found a common substring
			}
		}

		return false; // No common substring found
	}

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "world";
		boolean hasCommonSubstring = shareCommonSubstring(s1, s2);

		if (hasCommonSubstring) {
			System.out.println("Strings share a common substring.");
		} else {
			System.out.println("Strings do not share a common substring.");
		}
	}
}
