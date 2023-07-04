package com.venkat.leetcode.challenges;

import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic
 * calculator to evaluate it, and return the result of the evaluation.
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "1 + 1" Output: 2 Example 2:
 * 
 * Input: s = " 2-1 + 2 " Output: 3 Example 3:
 * 
 * Input: s = "(1+(4+5+2)-3)+(6+8)" Output: 23
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 3 * 105 s consists of digits, '+', '-', '(', ')', and ' '. s
 * represents a valid expression. '+' is not used as a unary operation (i.e.,
 * "+1" and "+(2 + 3)" is invalid). '-' could be used as a unary operation
 * (i.e., "-1" and "-(2 + 3)" is valid). There will be no two consecutive
 * operators in the input. Every number and running calculation will fit in a
 * signed 32-bit integer.
 * 
 * @author vkall
 *
 */
public class BasicCalculator {
	/**
	 * In this implementation, we iterate through each character of the expression
	 * string s. We maintain a stack to keep track of the accumulated results and
	 * signs within parentheses.
	 * 
	 * We use the operand variable to build up the current operand while iterating
	 * through digits. Whenever we encounter a + or -, we evaluate the previous
	 * operand, update the cumulative result, reset the operand, and update the sign
	 * accordingly.
	 * 
	 * When we encounter an opening parenthesis (, we store the current result and
	 * sign on the stack and reset them for the evaluation within the parentheses.
	 * 
	 * When we encounter a closing parenthesis ), we evaluate the current operand,
	 * multiply it by the previous sign from the stack, and add it to the
	 * accumulated result within the parentheses. We then update the result and
	 * operand variables accordingly.
	 * 
	 * Finally, after iterating through all the characters, we add the remaining
	 * operand (if any) to the result and return the final evaluated result.
	 * 
	 * In the main method, an example expression is provided, and the calculate
	 * function is used to evaluate it. The result is then printed to the console.
	 * 
	 * @param s
	 * @return
	 */
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int operand = 0;
		int result = 0; // Stores the cumulative result
		int sign = 1; // Represents the sign of the current operand (+1 or -1)

		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				operand = operand * 10 + (ch - '0');
			} else if (ch == '+') {
				result += sign * operand;
				operand = 0;
				sign = 1;
			} else if (ch == '-') {
				result += sign * operand;
				operand = 0;
				sign = -1;
			} else if (ch == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (ch == ')') {
				result += sign * operand;
				operand = 0;
				result *= stack.pop(); // Previous sign
				result += stack.pop(); // Accumulated result within the parentheses
			}
		}

		return result + (sign * operand);
	}

	public static void main(String[] args) {
		String expression = "(1+(4+5+2)-3)+(6+8)"; //"2+(3-1)+4";
		int result = calculate(expression);
		System.out.println("Result: " + result);
	}
}
