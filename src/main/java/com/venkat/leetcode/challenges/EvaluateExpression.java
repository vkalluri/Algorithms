package com.venkat.leetcode.challenges;

import java.util.Stack;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 */
public class EvaluateExpression {
    /**
     * In this program, the evaluateExpression method takes a string s representing a mathematical expression
     * as input and returns the evaluated value of the expression. It uses a stack to store the operands encountered
     * during evaluation. The program iterates through each character of the expression and performs the following actions:
     *
     * If the character is a digit, it converts the consecutive sequence of digits into an integer and pushes it to the stack.
     * If the character is an operator (+, -, *, or /), it pops the last two operands from the stack and performs
     * the corresponding operation. The result is then pushed back to the stack.
     * After iterating through all characters, the final result is the top element of the stack,
     * which is returned as the evaluated value of the expression.
     *
     * The performOperation method is a helper function that performs the arithmetic operation
     * based on the given operator (+, -, *, or /) and returns the result.
     *
     * In the main method, an example expression "3+2*2" is evaluated, and the result is printed.
     * @param s
     * @return
     */
//    public static int evaluateExpression(String s) {
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (Character.isDigit(c)) {
//                // If the character is a digit, convert it to an integer and push to the stack
//                int num = 0;
//                while (i < s.length() && Character.isDigit(s.charAt(i))) {
//                    num = num * 10 + (s.charAt(i) - '0');
//                    i++;
//                }
//                i--; // Decrement i to account for the increment in the loop
//
//                stack.push(num);
//            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
//                // If the character is an operator, pop two operands from the stack and perform the operation
//                int operand2 = stack.pop();
//                int operand1 = stack.pop();
//                int result = performOperation(operand1, operand2, c);
//                stack.push(result);
//            }
//        }
//
//        return stack.pop();
//    }
//
//    private static int performOperation(int operand1, int operand2, char operator) {
//        switch (operator) {
//            case '+':
//                return operand1 + operand2;
//            case '-':
//                return operand1 - operand2;
//            case '*':
//                return operand1 * operand2;
//            case '/':
//                return operand1 / operand2;
//        }
//
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        String expression = "3+2*2";
//        int result = evaluateExpression(expression);
//        System.out.println("Expression value: " + result);
//    }

//    public static int evaluateExpression(String s) {
//        Stack<Integer> operandStack = new Stack<>();
//        Stack<Character> operatorStack = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (Character.isDigit(c)) {
//                int num = 0;
//                while (i < s.length() && Character.isDigit(s.charAt(i))) {
//                    num = num * 10 + (s.charAt(i) - '0');
//                    i++;
//                }
//                i--;
//
//                operandStack.push(num);
//            } else if (c == '+' || c == '-') {
//                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
//                    evaluateTop(operandStack, operatorStack);
//                }
//                operatorStack.push(c);
//            } else if (c == '*' || c == '/') {
//                operatorStack.push(c);
//            }
//        }
//
//        while (!operatorStack.isEmpty()) {
//            evaluateTop(operandStack, operatorStack);
//        }
//
//        return operandStack.pop();
//    }
//
//    private static void evaluateTop(Stack<Integer> operandStack, Stack<Character> operatorStack) {
//        char operator = operatorStack.pop();
//        int operand2 = operandStack.pop();
//        int operand1 = operandStack.pop();
//        int result = performOperation(operand1, operand2, operator);
//        operandStack.push(result);
//    }
//
//    private static int performOperation(int operand1, int operand2, char operator) {
//        switch (operator) {
//            case '+':
//                return operand1 + operand2;
//            case '-':
//                return operand1 - operand2;
//            case '*':
//                return operand1 * operand2;
//            case '/':
//                if (operand2 == 0) {
//                    throw new ArithmeticException("Division by zero error");
//                }
//                return operand1 / operand2;
//        }
//
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        String expression = "1-1+1";
//        int result = evaluateExpression(expression);
//        System.out.println("Expression value: " + result);
//    }

//    public static int evaluateExpression(String s) {
//        Stack<Integer> operandStack = new Stack<>();
//        Stack<Character> operatorStack = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (Character.isDigit(c)) {
//                int num = 0;
//                while (i < s.length() && Character.isDigit(s.charAt(i))) {
//                    num = num * 10 + (s.charAt(i) - '0');
//                    i++;
//                }
//                i--;
//
//                operandStack.push(num);
//            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
//                while (!operatorStack.isEmpty() && hasPrecedence(c, operatorStack.peek())) {
//                    evaluateTop(operandStack, operatorStack);
//                }
//                operatorStack.push(c);
//            }
//        }
//
//        while (!operatorStack.isEmpty()) {
//            evaluateTop(operandStack, operatorStack);
//        }
//
//        return operandStack.pop();
//    }
//
//    private static void evaluateTop(Stack<Integer> operandStack, Stack<Character> operatorStack) {
//        char operator = operatorStack.pop();
//        int operand2 = operandStack.pop();
//        int operand1 = operandStack.pop();
//        int result = performOperation(operand1, operand2, operator);
//        operandStack.push(result);
//    }
//
//    private static boolean hasPrecedence(char op1, char op2) {
//        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
//            return true;
//        }
//        return false;
//    }
//
//    private static int performOperation(int operand1, int operand2, char operator) {
//        switch (operator) {
//            case '+':
//                return operand1 + operand2;
//            case '-':
//                return operand1 - operand2;
//            case '*':
//                return operand1 * operand2;
//            case '/':
//                if (operand2 == 0) {
//                    throw new ArithmeticException("Division by zero error");
//                }
//                return operand1 / operand2;
//        }
//
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        String expression = "3+5 / 2 ";
//        int result = evaluateExpression(expression);
//        System.out.println("Expression value: " + result);
//    }


    public static int evaluateExpression(String s) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        boolean isUnaryNegation = false; // Flag to track unary negation

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;

                operandStack.push(num);
                isUnaryNegation = false; // Reset the flag
            } else if (c == '+') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    evaluateTop(operandStack, operatorStack);
                }
                operatorStack.push(c);
            } else if (c == '-') {
                if (isUnaryNegation) {
                    // Treat '-' as a unary negation
                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    i--;

                    operandStack.push(-num);
                    isUnaryNegation = false; // Reset the flag
                } else {
                    // Treat '-' as a binary subtraction
                    while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                        evaluateTop(operandStack, operatorStack);
                    }
                    operatorStack.push(c);
                    isUnaryNegation = true; // Set the flag for unary negation
                }
            } else if (c == '*' || c == '/') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    evaluateTop(operandStack, operatorStack);
                }
                operatorStack.push(c);
                isUnaryNegation = false; // Reset the flag
            }
        }

        while (!operatorStack.isEmpty()) {
            evaluateTop(operandStack, operatorStack);
        }

        return operandStack.pop();
    }

    private static void evaluateTop(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char operator = operatorStack.pop();
        int operand2 = operandStack.pop();
        int operand1 = operandStack.pop();
        int result = performOperation(operand1, operand2, operator);
        operandStack.push(result);
    }

    private static int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero error");
                }
                return operand1 / operand2;
        }

        return 0;
    }

    public static void main(String[] args) {
        String expression = "1-1+1";
        int result = evaluateExpression(expression);
        System.out.println("Expression value: " + result);
    }

}
