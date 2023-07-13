package com.venkat.leetcode;

/**
 * . Divide Two Integers
 * Medium
 * 4.5K
 * 13.6K
 * Companies
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within
 * the 32-bit signed integer range: [−2^31, 2^31 − 1]. For this problem, if the quotient is strictly greater than 2^31 - 1,
 * then return 2^31 - 1, and if the quotient is strictly less than -2^31, then return -2^31.
 *
 *
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 *
 *
 * Constraints:
 *
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 */
public class DivideIntegers {

    /**
     * This implementation handles the special cases where the divisor is zero and when the dividend is Integer.MIN_VALUE
     * and the divisor is -1. It converts the dividend and divisor to positive values to simplify the calculations.
     *
     * The division is performed using a repeated subtraction approach. It keeps subtracting
     * the divisor from the dividend until the dividend becomes less than the divisor. The number of
     * subtractions performed is the quotient. The sign of the quotient is determined based on the signs of the dividend and divisor.
     *
     * The implementation also takes care of integer overflow by using long for intermediate calculations.
     * Finally, it returns the quotient multiplied by the sign.
     *
     * You can use this function by creating an instance of the Solution class and calling divide(dividend, divisor)
     * on that instance, where dividend and divisor are the two integers you want to divide. It will return the quotient
     * after dividing the dividend by the divisor, with the truncation towards zero.
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        // Handle special cases
        if (divisor == 0) {
            throw new ArithmeticException("Divisor cannot be zero.");
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Convert dividend and divisor to positive to simplify calculations
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        // Perform division
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int quotient = 0;

        while (dividendL >= divisorL) {
            long temp = divisorL;
            int count = 1;

            while (dividendL >= (temp << 1)) {
                temp <<= 1;
                count <<= 1;
            }

            dividendL -= temp;
            quotient += count;
        }

        return sign * quotient;
    }

    public static void main(String[] args){
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
//        System.out.println(divide(10, 3));
    }
}
