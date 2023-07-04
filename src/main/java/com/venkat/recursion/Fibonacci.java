package com.venkat.recursion;

public class Fibonacci {

	public Fibonacci() {
		// TODO Auto-generated constructor stub
	}
	public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        for (int i = 0; i < n; i++) {
            int result = fibonacci(i);
            System.out.print(result + " ");
        }
    }
}
