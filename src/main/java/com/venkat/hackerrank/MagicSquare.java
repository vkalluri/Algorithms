package com.venkat.hackerrank;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We define a magic square to be an n x n matrix of distinct positive integers
 * from 1 to n^2 where the sum of any row, column, or diagonal of length n is
 * always equal to the same number: the magic constant.
 *
 * You will be given a 3 x 3 matrix  of integers in the inclusive range [1, 9].
 * We can convert any digit a to any other digit b in the range [1,9] at cost of |a -b|.
 * Given s, convert it into a magic square at minimal cost. Print this cost on a new line.
 *
 * Note: The resulting magic square must contain distinct integers in the inclusive range |1, 9|.
 *
 * Example
 *
 * $s = [[5, 3, 4], [1, 5, 8], [6, 4, 2]]
 *
 * The matrix looks like this:
 *
 * 5 3 4
 * 1 5 8
 * 6 4 2
 * We can convert it to the following magic square:
 *
 * 8 3 4
 * 1 5 9
 * 6 7 2
 * This took three replacements at a cost of |5 - 8|+|8 - 9|+|4 - 7| = 7.
 *
 * Function Description
 *
 * Complete the formingMagicSquare function in the editor below.
 *
 * formingMagicSquare has the following parameter(s):
 *
 * int s[3][3]: a 3 x 3 array of integers
 *
 * Returns
 * int: the minimal total cost of converting the input square to a magic square
 *
 * Input Format
 * Each of the  lines contains three space-separated integers of row s[i].
 */
public class MagicSquare {
    static final int[][][] POSSIBLE_MAGIC_SQUARES = {
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
    };
    static int formingMagicSquare(int[][] s) {
        int minCost = Integer.MAX_VALUE;

        for (int[][] magicSquare : POSSIBLE_MAGIC_SQUARES) {
            int cost = calculateCost(s, magicSquare);
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    /**
     *
     To solve this problem, we can analyze all possible 3x3 magic squares and calculate
     the cost of transforming the given matrix into each of them. We'll calculate
     the cost by finding the absolute difference between each element in the given matrix and
     the corresponding element in the magic square. We'll keep track of the minimum cost encountered and return it as the result.

     We define POSSIBLE_MAGIC_SQUARES as an array of all possible 3x3 magic squares.
     We iterate over each magic square and calculate the cost of transforming the given
     matrix into that magic square using the calculateCost function. We keep track of
     the minimum cost encountered and return it as the result.

     The calculateCost function calculates the cost by iterating over each element in
     the given matrix s and finding the absolute difference between it and the corresponding element in the magic square.

     In the main method, we initialize s with the given matrix and call formingMagicSquare
     to get the minimal total cost. Finally, we print the minimal total cost.

     Note: This solution assumes that the input matrix s will always be a valid 3x3 matrix containing
     integers in the inclusive range [1, 9]. Make sure to handle potential exceptions and edge cases in a production-level implementation.
     * @param s
     * @param magicSquare
     * @return
     */
    static int calculateCost(int[][] s, int[][] magicSquare) {
        int cost = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cost += Math.abs(s[i][j] - magicSquare[i][j]);
            }
        }

        return cost;
    }

    public static void main(String[] args) {
//        int[][] s = {
//                {5, 3, 4},
//                {1, 5, 8},
//                {6, 4, 2}
//        };
//
//        int minCost = formingMagicSquare(s);
//        System.out.println("Minimal Total Cost: " + minCost);

        List<List<Integer>> s1 = new ArrayList<>();
        s1.add(Arrays.asList(4, 8, 2));
        s1.add(Arrays.asList(4, 5, 7));
        s1.add(Arrays.asList(6, 1, 6));

        int minCost1 = formingMagicSquare(s1);
        System.out.println("Minimal Total Cost: " + minCost1);
    }

    static final List<List<Integer>> POSSIBLE_MAGIC_SQUARES1 = Arrays.asList(
            Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2),
            Arrays.asList(6, 1, 8, 7, 5, 3, 2, 9, 4),
            Arrays.asList(4, 9, 2, 3, 5, 7, 8, 1, 6),
            Arrays.asList(2, 9, 4, 7, 5, 3, 6, 1, 8),
            Arrays.asList(8, 3, 4, 1, 5, 9, 6, 7, 2),
            Arrays.asList(4, 3, 8, 9, 5, 1, 2, 7, 6),
            Arrays.asList(6, 7, 2, 1, 5, 9, 8, 3, 4),
            Arrays.asList(2, 7, 6, 9, 5, 1, 4, 3, 8)
    );

    static int formingMagicSquare(List<List<Integer>> s) {
        int minCost = Integer.MAX_VALUE;

        for (List<Integer> magicSquare : s) {
            int cost = calculateCost(s, magicSquare);
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    static int calculateCost(List<List<Integer>> s, List<Integer> magicSquare) {
        int cost = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(s.get(i).get(j) + "       " + magicSquare.get(i * 3 + j));
                cost += Math.abs(s.get(i).get(j) - magicSquare.get(i * 3 + j));
            }
        }

        return cost;
    }

}
