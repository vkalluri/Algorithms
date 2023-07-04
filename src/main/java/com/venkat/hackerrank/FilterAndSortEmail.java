package com.venkat.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterAndSortEmail {

	public FilterAndSortEmail() {
		// TODO Auto-generated constructor stub
	}

	public static String filterAndSortEmail(String email) {
		List<Character> alphabets = new ArrayList<>();
		StringBuilder filteredEmail = new StringBuilder();

		// Iterate through each character in the email address
		for (char ch : email.toCharArray()) {
			// Check if the character is an alphabet
			if (Character.isLetter(ch)) {
				alphabets.add(ch);
			}
			filteredEmail.append(ch);
		}

		// Sort the alphabets in ascending order
		Collections.sort(alphabets);

		// Replace the alphabets in the filtered email with the sorted alphabets
		int index = 0;
		for (int i = 0; i < filteredEmail.length(); i++) {
			if (Character.isLetter(filteredEmail.charAt(i))) {
				filteredEmail.setCharAt(i, alphabets.get(index));
				index++;
			}
		}

		return filteredEmail.toString();
	}

	public static void main(String[] args) {
		String email = "exam5ple@domain.com";
		String filteredEmail = filterAndSortEmail(email);
		System.out.println("Filtered and sorted email address: " + filteredEmail);
	}
}
