package com.venkat.other;

import java.util.Scanner;

public class PatternOfAlphabets {
	public static void main(String[] args) {

		Scanner commandReader = new Scanner(System.in);
		System.out.println("Welcome to Java Program for printing pattern of alphabets");
		System.out.println("Enter number of rows : ");
		int rows = commandReader.nextInt();
		System.out.println("Do you want pattern to be displayed in upper case? ");
		boolean isUpperCase = commandReader.nextBoolean();

		printPatternOfAlphabets(rows, isUpperCase);

		commandReader.close();

	}

	/**
	 * A Java method to print pattern of alphabets
	 * 
	 * @param rows      - number of rows in pattern
	 * @param isCapital - if true, pattern will contain upper case alphabets
	 */
	public static void printPatternOfAlphabets(int rows, boolean isCapital) {
		char start = 'a' - 1;
		if (isCapital) {
			start = 'A' - 1;
		}
		for (int i = 1; i <= rows; i++) {

			for (int j = 1; j <= i; j++) {
				char ch = (char) (start + j);
				System.out.print(ch);
			}
			System.out.println();
		}
	}

}
