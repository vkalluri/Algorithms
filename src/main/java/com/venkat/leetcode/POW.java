package com.venkat.leetcode;

public class POW {
    public static double myPow(double x, int n) {
        // Base case: x raised to the power 0 is 1
        if (n == 0) {
            return 1;
        }

        if(n <= Integer.MIN_VALUE){
            return 1 / (myPow(x, -(n)) * x);
        }

        // For negative exponent, invert the base and make the exponent positive
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        // Recursive calculation using binary exponentiation
        double result = myPow(x, n / 2);
        result *= result;

        // For odd exponent, multiply the base once more
        if (n % 2 == 1) {
            result *= x;
        }

        return result;
    }
    public  static void main(String[] args){
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2147483648));
    }}
