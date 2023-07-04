package com.venkat.codility;

public class AddNumbersInAString {
	public static void main(String[] args) {
        String input = "I have 3 apples and 5 oranges.";
//		String input = "Gl123a45ssd908oo6r";
//
//		int sum = 0;
//
//		String[] words = input.split("\\s+"); // Split the input string into individual words
//
//		for (String word : words) {
//			if (word.matches("\\d+")) { // Check if the word contains only digits
//				int number = Integer.parseInt(word);
//				sum += number;
//			}
//		}

		System.out.println("Sum of numbers in the string: " + addNumbersFromStringWithOutSpaces(input));
	}

	public static int addNumbersFromStringWithOutSpaces(String input) {
		int sum = 0;

		StringBuilder currentNumber = new StringBuilder();

		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				currentNumber.append(c);
			} else if (currentNumber.length() > 0) {
				int number = Integer.parseInt(currentNumber.toString());
				sum += number;
				currentNumber.setLength(0);
			}
		}
		System.out.println(sum);

		if (currentNumber.length() > 0) {
			int number = Integer.parseInt(currentNumber.toString());
			sum += number;
		}
		return sum;
	}

}
