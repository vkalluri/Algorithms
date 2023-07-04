package com.venkat.leetcode.challenges;

public class PalindromeChecker {
	/**
	 * In this code, the isPalindrome method takes an integer x as input and returns
	 * true if x is a palindrome, and false otherwise. It first checks if the number
	 * is negative because negative numbers cannot be palindromes.
	 * 
	 * Then, it initializes original with the original number and reversed with 0.
	 * It uses a while loop to extract the digits from x one by one using the modulo
	 * operator % and builds the reversed number by multiplying it by 10 and adding
	 * the extracted digit.
	 * 
	 * Finally, it compares the original number with the reversed number and returns
	 * the result.
	 * 
	 * In the main method, an example number 12321 is used to demonstrate the usage
	 * of the isPalindrome method. The result is printed to the console.
	 * 
	 * Feel free to modify the code according to your needs or integrate it into
	 * your existing Java application.
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false; // Negative numbers cannot be palindromes
		}

		int original = x;
		int reversed = 0;

		while (x != 0) {
			int digit = x % 10;
			reversed = reversed * 10 + digit;
			x /= 10;
		}

		return original == reversed;
	}

	public static void main(String[] args) {
		int number = 12321;
		boolean isPalin = isPalindrome(number);
		System.out.println(number + " is a palindrome? " + isPalin);
	}
}
