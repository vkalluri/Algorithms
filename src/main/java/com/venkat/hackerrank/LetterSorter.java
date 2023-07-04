package com.venkat.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterSorter {
	public static List<Character> sortLetters(String text) {
        // Remove non-alphabetic characters and convert to lowercase
        text = text.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Convert the string to a character array
        char[] letters = text.toCharArray();

        // Create a list to store the letters
        List<Character> letterList = new ArrayList<>();

        // Add each letter to the list
        for (char letter : letters) {
            letterList.add(letter);
        }

        // Sort the list in ascending order
        Collections.sort(letterList);

        return letterList;
    }

    public static void main(String[] args) {
        String text = "Hello, 43423432 World!";
        List<Character> sortedLetters = sortLetters(text);
        System.out.println("Sorted list of letters: " + sortedLetters);
    }
}
