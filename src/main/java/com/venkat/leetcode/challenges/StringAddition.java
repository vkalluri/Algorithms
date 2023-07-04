package com.venkat.leetcode.challenges;

public class StringAddition {

	/**
	 * In this code, the addStrings method takes two strings num1 and num2
	 * representing non-negative integers. It uses a StringBuilder to build the sum
	 * string. It also initializes a carry variable to keep track of any carry-over
	 * that occurs during addition.
	 * 
	 * The method iterates from the rightmost digit of both input strings towards
	 * the leftmost digit. It extracts the corresponding digits from num1 and num2
	 * and adds them along with the carry. The resulting sum is divided by 10 to get
	 * the digit to be inserted into the sum string, and the carry is updated for
	 * the next iteration. The digit is inserted at the beginning of the sum using
	 * insert(0, digitSum).
	 * 
	 * The loop continues until both num1 and num2 have been traversed, and the
	 * carry is 0. Finally, the sum string is returned.
	 * 
	 * In the main method, an example is provided where num1 is "123" and num2 is
	 * "456". The addStrings method is called, and the resulting sum is printed to
	 * the console.
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String addStrings(String num1, String num2) {
		StringBuilder sum = new StringBuilder();
		int carry = 0;
		int i = num1.length() - 1;
		int j = num2.length() - 1;

		while (i >= 0 || j >= 0 || carry > 0) {
			int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
			int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
			int currentSum = digit1 + digit2 + carry;
			int digitSum = currentSum % 10;
			carry = currentSum / 10;
			sum.insert(0, digitSum);
			i--;
			j--;
		}

		return sum.toString();
	}

	public static void main(String[] args) {
		String num1 = "77";
		String num2 = "456";
		String sum = addStrings(num1, num2);
		System.out.println("Sum: " + sum);
	}
}
