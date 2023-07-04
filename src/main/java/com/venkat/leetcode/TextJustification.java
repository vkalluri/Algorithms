package com.venkat.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	
	public static void main(String[] args) {
		TextJustification just = new TextJustification();
		
//		words = [], maxWidth = 16
		String[] textArray = {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth = 16;
		System.out.println(just.fullJustify(textArray, maxWidth));
	}
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		int left = 0; // Index of the first word in the current line

		while (left < words.length) {
			int right = findRightWord(left, words, maxWidth); // Index of the last word in the current line
			int lineLength = calculateLineLength(left, right, words); // Length of the current line

			if (right == words.length - 1 || lineLength == maxWidth) {
				result.add(leftJustify(left, right, words, maxWidth));
			} else {
				result.add(justify(left, right, words, maxWidth, lineLength));
			}

			left = right + 1;
		}

		return result;
	}

	// Find the index of the last word that can fit in the current line
	private int findRightWord(int left, String[] words, int maxWidth) {
		int right = left;
		int lineLength = words[right++].length(); // Length of the current line

		while (right < words.length && lineLength + 1 + words[right].length() <= maxWidth) {
			lineLength += 1 + words[right++].length(); // Adding 1 for the space between words
		}

		return right - 1;
	}

	// Calculate the length of the line formed by words between left and right
	// indices
	private int calculateLineLength(int left, int right, String[] words) {
		int length = 0;

		for (int i = left; i <= right; i++) {
			length += words[i].length();
		}

		return length;
	}

	// Left justify the words in a line
	private String leftJustify(int left, int right, String[] words, int maxWidth) {
		StringBuilder sb = new StringBuilder();

		for (int i = left; i <= right; i++) {
			sb.append(words[i]);
			if (i != right) {
				sb.append(" ");
			}
		}

		// Append extra spaces at the end to reach the desired maxWidth
		while (sb.length() < maxWidth) {
			sb.append(" ");
		}

		return sb.toString();
	}

	// Justify the words in a line by adding extra spaces between them
	private String justify(int left, int right, String[] words, int maxWidth, int lineLength) {
		int wordCount = right - left + 1;
		int totalSpaces = maxWidth - lineLength;
		int spacesBetweenWords = wordCount > 1 ? totalSpaces / (wordCount - 1) : totalSpaces;
		int extraSpaces = wordCount > 1 ? totalSpaces % (wordCount - 1) : totalSpaces;

		StringBuilder sb = new StringBuilder();

		for (int i = left; i < right; i++) {
			sb.append(words[i]);
//			sb.append(" ".repeat(spacesBetweenWords));

			if (extraSpaces > 0) {
				sb.append(" ");
				extraSpaces--;
			}
		}

		sb.append(words[right]); // Append the last word

		return sb.toString();
	}
}
