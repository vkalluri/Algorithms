package com.venkat.hackerrank;

import java.util.HashSet;
import java.util.Set;

public class LongestAlternatingString {
	 public static void main(String[] args) {
	        String input = "asvkugfiugsalddlasguifgukvsa";

	        int longestLength = findLongestAlternatingString(input);
	        System.out.println("Longest alternating string length: " + longestLength);
	    }

	    private static int findLongestAlternatingString(String input) {
	        int longestLength = 0;

	        // Create a set to store unique characters
	        Set<Character> characters = new HashSet<>();

	        // Iterate over all possible pairs of distinct characters
	        for (int i = 0; i < input.length() - 1; i++) {
	            char firstChar = input.charAt(i);

	            for (int j = i + 1; j < input.length(); j++) {
	                char secondChar = input.charAt(j);

	                characters.add(firstChar);
	                characters.add(secondChar);

	                // Remove all characters other than the chosen pair
	                String alternateString = input.replaceAll("[^" + firstChar + secondChar + "]", "");

	                // Check if the resulting string contains only two alternating characters
	                if (isAlternatingString(alternateString)) {
	                    longestLength = Math.max(longestLength, alternateString.length());
	                }

	                characters.clear();
	            }
	        }

	        return longestLength;
	    }

	    private static boolean isAlternatingString(String str) {
	        for (int i = 2; i < str.length(); i++) {
	            if (str.charAt(i) != str.charAt(i - 2)) {
	                return false;
	            }
	        }
	        return true;
	    }
}
