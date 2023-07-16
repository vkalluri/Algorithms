package com.venkat.leetcode;

public class GreatestCommonDiviser {
    public static String largestCommonDivisor(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int gcdLen = gcd(len1, len2);
        String substring = str1.substring(0, gcdLen);

        // Check if substring divides both str1 and str2
        if (str1.equals(generateString(substring, len1 / gcdLen))
                && str2.equals(generateString(substring, len2 / gcdLen))) {
            return substring;
        }

        while (gcdLen > 0) {
            gcdLen--;
            substring = str1.substring(0, gcdLen);
            if (gcdLen > 0 && str1.equals(generateString(substring, len1 / gcdLen))
                    && str2.equals(generateString(substring, len2 / gcdLen))) {
                return substring;
            }
        }

        return "";
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static String generateString(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "LEET";
        String str2 = "CODE";
        String result = largestCommonDivisor(str1, str2);
        System.out.println(result);  // Output: "ABC"
    }
}
