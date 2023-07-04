package com.venkat.hackerrank;

/**
 * There is a string, , of lowercase English letters that is repeated infinitely
 * many times. Given an integer, , find and print the number of letter a's in
 * the first letters of the infinite string.
 * 
 * Example
 * 
 * 
 * The substring we consider is , the first characters of the infinite string.
 * There are occurrences of a in the substring.
 * 
 * Function Description
 * 
 * Complete the repeatedString function in the editor below.
 * 
 * repeatedString has the following parameter(s):
 * 
 * s: a string to repeat n: the number of characters to consider Returns
 * 
 * int: the frequency of a in the substring Input Format
 * 
 * The first line contains a single string, . The second line contains an
 * integer, .
 * 
 * Constraints
 * 
 * For of the test cases, . Sample Input
 * 
 * Sample Input 0
 * 
 * @author vkall
 *
 */
public class InfiniteString {
	/**
	 * In this code, the countLetterA method takes a string s and a long integer n
	 * as input. It calculates the number of occurrences of the letter 'a' in the
	 * first n letters of the infinite string.
	 * 
	 * The method first calculates the number of complete repetitions of the string
	 * (completeRepetitions) and the number of remaining letters (remainingLetters)
	 * after the complete repetitions.
	 * 
	 * Then, it iterates over the characters of the string to count the number of
	 * 'a' occurrences in the complete repetitions. For each 'a' in the string, the
	 * number of complete repetitions is added to the occurrences count.
	 * 
	 * Finally, it iterates over the remaining letters and counts the number of 'a'
	 * occurrences.
	 * 
	 * The method returns the final occurrences count as the number of 'a'
	 * occurrences in the first n letters of the infinite string.
	 * 
	 * In the main method, we provide an example string s and the number of letters
	 * n as inputs. The countLetterA method is called to find the number of 'a'
	 * occurrences, and the result is printed.
	 * 
	 * @param s
	 * @param n
	 * @return
	 */
	public static long countLetterA(String s, long n) {
		long occurrences = 0;
		long completeRepetitions = n / s.length();
		long remainingLetters = n % s.length();

		// Count the number of 'a' occurrences in complete repetitions of the string
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				occurrences += completeRepetitions;
			}
		}

		// Count the number of 'a' occurrences in the remaining letters
		for (int i = 0; i < remainingLetters; i++) {
			if (s.charAt(i) == 'a') {
				occurrences++;
			}
		}

		return occurrences;
	}

	public static void main(String[] args) {
		String s = "aba";
		long n = 10;

		long occurrences = countLetterA(s, n);
		System.out.println("Number of letter 'a' occurrences: " + occurrences);
	}
}
