package com.venkat.recursion;

public class Factorial {

	public Factorial() {
		// TODO Auto-generated constructor stub
	}
	public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }

}
