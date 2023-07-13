package com.venkat.hackerrank;


import java.util.List;

/**
 * Given an array of strings of digits, try to find the occurrence of a given pattern of digits.
 * In the grid and pattern arrays, each string represents a row in the grid. For example, consider the following grid:
 *
 * 1234567890
 * 0987654321
 * 1111111111
 * 1111111111
 * 2222222222
 *
 * The pattern array is:
 * 876543
 * 111111
 * 111111
 *
 * The pattern begins at the second row and the third column of the grid and continues in the
 * following two rows. The pattern is said to be present in the grid. The return value should be YES or NO,
 * depending on whether the pattern is found. In this case, return YES.
 *
 * Function Description
 * Complete the gridSearch function in the editor below. It should return YES if the pattern exists in the grid, or NO otherwise.
 *
 * gridSearch has the following parameter(s):
 *
 * string G[R]: the grid to search
 * string P[r]: the pattern to search for
 *
 * Input Format
 * The first line contains an integer , the number of test cases.
 *
 * Each of the t test cases is represented as follows:
 * The first line contains two space-separated integers R and c, the number of rows in the search grid G and the length of each row string.
 * This is followed by R lines, each with a string of C digits that represent the grid G.
 * The following line contains two space-separated integers, r and c, the number of rows in the pattern grid P and the length of each pattern row string.
 * This is followed by r lines, each with a string of c digits that represent the pattern grid P.
 *
 * Returns
 * string: either YES or NO
 *
 * Constraints
 * 1 <= t <= 5
 * 1 < R,r,C,c <= 1000
 * 1 <= r <= R
 * 1 <= c <= C
 *
 *
 *
 *
 *
 *
 * Sample Input
 *
 * 2
 * 10 10
 * 7283455864
 * 6731158619
 * 8988242643
 * 3830589324
 * 2229505813
 * 5633845374
 * 6473530293
 * 7053106601
 * 0834282956
 * 4607924137
 * 3 4
 * 9505
 * 3845
 * 3530
 * 15 15
 * 400453592126560
 * 114213133098692
 * 474386082879648
 * 522356951189169
 * 887109450487496
 * 252802633388782
 * 502771484966748
 * 075975207693780
 * 511799789562806
 * 404007454272504
 * 549043809916080
 * 962410809534811
 * 445893523733475
 * 768705303214174
 * 650629270887160
 * 2 2
 * 99
 * 99
 * Sample Output
 *
 * YES
 * NO
 */
public class StringOccurance {

    public static String gridSearch(String[] G, String[] P) {
        int R = G.length;
        int C = G[0].length();
        int r = P.length;
        int c = P[0].length();

        for (int i = 0; i <= R - r; i++) {
            for (int j = 0; j <= C - c; j++) {
                if (G[i].substring(j, j + c).equals(P[0])) {
                    boolean found = true;
                    for (int k = 1; k < r; k++) {
                        if (!G[i + k].substring(j, j + c).equals(P[k])) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        return "YES";
                    }
                }
            }
        }

        return "NO";
    }

    public static String gridSearch(List<String> G, List<String> P) {
        int R = G.size();
        int C = G.get(0).length();
        int r = P.size();
        int c = P.get(0).length();

        for (int i = 0; i <= R - r; i++) {
            for (int j = 0; j <= C - c; j++) {
                if (G.get(i).substring(j, j + c).equals(P.get(0))) {
                    boolean found = true;
                    for (int k = 1; k < r; k++) {
                        if (!G.get(i + k).substring(j, j + c).equals(P.get(k))) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        return "YES";
                    }
                }
            }
        }

        return "NO";
    }
}
