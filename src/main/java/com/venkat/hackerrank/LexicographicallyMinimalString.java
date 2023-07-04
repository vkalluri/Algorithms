package com.venkat.hackerrank;

import java.util.Stack;

public class LexicographicallyMinimalString {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.print("Enter Jack's collection of letters: ");
//		String jackLetters = scanner.nextLine();
//
//		System.out.print("Enter Daniel's collection of letters: ");
//		String danielLetters = scanner.nextLine();

		String minimalString = findLexicographicallyMinimalString("ABACABA", "ABACABA");
		System.out.println("Lexicographically minimal string: " + minimalString);
		System.out.println("got the answer");
	}

	private static String findLexicographicallyMinimalString(String jackLetters, String danielLetters) {
		Stack<Character> jackStack = new Stack<>();
		Stack<Character> danielStack = new Stack<>();

		// Push the letters of Jack's collection onto the stack in reverse order
		for (int i = jackLetters.length() - 1; i >= 0; i--) {
			jackStack.push(jackLetters.charAt(i));
		}

		// Push the letters of Daniel's collection onto the stack in reverse order
		for (int i = danielLetters.length() - 1; i >= 0; i--) {
			danielStack.push(danielLetters.charAt(i));
		}

		StringBuilder minimalString = new StringBuilder();

		// Compare the top letters of the stacks and choose the lexicographically
		// smaller one
		while (!jackStack.isEmpty() && !danielStack.isEmpty()) {
			char jackTop = jackStack.peek();
			char danielTop = danielStack.peek();

			if (jackTop <= danielTop) {
				minimalString.append(jackStack.pop());
			} else {
				minimalString.append(danielStack.pop());
			}
		}

		// Append the remaining letters from the non-empty stack
		while (!jackStack.isEmpty()) {
			minimalString.append(jackStack.pop());
		}

		while (!danielStack.isEmpty()) {
			minimalString.append(danielStack.pop());
		}

		// Reverse the minimalString because we appended the letters in reverse order
		return minimalString.reverse().toString();
	}
}
