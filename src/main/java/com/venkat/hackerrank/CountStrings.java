package com.venkat.hackerrank;


import java.util.Scanner;

/**
 * A regular expression is used to describe a set of strings. For this problem the alphabet is limited to 'a' and 'b'.
 *
 * We define  to be a valid regular expression if:
 * 1) R is "a" or "b".
 * 2) R is of the form "(R1R2)", where R1 and R2 are regular expressions.
 * 3) R is of the form "(R1|R2)" where R1 and R2 are regular expressions.
 * 4) R is of the form "(R1*)" where R1 is a regular expression.
 *
 * Regular expressions can be nested and will always have have two elements in the parentheses.
 * ('*' is an element, '|' is not; basically, there will always be pairwise evaluation) Additionally,
 * '*' will always be the second element; '(*a)' is invalid.
 *
 * The set of strings recognized by R are as follows:
 * 1) If R is "a", then the set of strings recognized = a.
 * 2) If R is "b", then the set of strings recognized = b.
 * 3) If R is of the form "(R1R2)" then the set of strings recognized = all strings
 * which can be obtained by a concatenation of strings s1 and s2, where s1 is recognized by R1 and s2 by R2.
 * 4) If R is of the form "(R1|R2)" then the set of strings recognized = union of the set of strings recognized by R1 and R2.
 * 5) If R is of the form "(R1*)" then the the strings recognized are the empty string
 * and the concatenation of an arbitrary number of copies of any string recognized by R1.
 *
 * Task
 * Given a regular expression and an integer, L, count how many strings of length L are recognized by it.
 *
 * Input Format
 * The first line contains the number of test cases T. T test cases follow.
 * Each test case contains a regular expression, R, and an integer, L.
 *
 * Constraints
 * 1 <= T <= 50
 * 1 <= |R| <= 100
 * 1 <= L <= 10^9
 * It is guaranteed that R will conform to the definition provided above.
 *
 * Output Format
 * Print T lines, one corresponding to each test case containing the required answer
 * for the corresponding test case. As the answers can be very big, output them modulo 10^9 + 7.
 *
 * Sample Input
 * 3
 * ((ab)|(ba)) 2
 * ((a|b)*) 5
 * ((a*)(b(a*))) 100
 */
public class CountStrings {
    static final int MOD = 1000000007;

    static long countStrings(String regex, int length) {
        int n = regex.length();
        long[][] dp = new long[n][length + 1];

        for (int i = 0; i < n; i++) {
            char ch = regex.charAt(i);
            if (ch == 'a' || ch == 'b') {
                dp[i][1] = 1;
            }
        }

        for (int l = 2; l <= length; l++) {
            for (int i = 0; i < n; i++) {
                char ch = regex.charAt(i);
                if (ch == '(') {
                    int j = findMatchingParenthesis(regex, i);
                    for (int k = i + 1; k < j; k++) {
                        if (regex.charAt(k) == '|') {
                            dp[i][l] = (dp[i][l] + dp[i + 1][l] + dp[k + 1][l]) % MOD;
                        }
                    }
                    dp[i][l] = (dp[i][l] + dp[i + 1][l - 1]) % MOD;
                } else if (ch == '*') {
                    dp[i][l] = (dp[i - 1][l] + dp[i][l - 1]) % MOD;
                }
            }
        }

        return dp[0][length];
    }

    static int findMatchingParenthesis(String regex, int i) {
        int count = 0;
        while (i < regex.length()) {
            if (regex.charAt(i) == '(') {
                count++;
            } else if (regex.charAt(i) == ')') {
                count--;
                if (count == 0) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

//        while (t-- > 0) {
//            String regex = scanner.next();
//            int length = scanner.nextInt();

            long count = countStrings("((ab)|(ba))", 2);
            System.out.println(count);
//        }
    }
}
