package com.venkat.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxRotation {
    public static void rotateMatrix(int[][] matrix, int r) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Calculate the number of layers in the matrix
        int numLayers = Math.min(m, n) / 2;

        // Perform the rotation r times
        for (int rotation = 0; rotation < r; rotation++) {
            // Rotate each layer
            for (int layer = 0; layer < numLayers; layer++) {
                int firstRow = layer;
                int lastRow = m - 1 - layer;
                int firstCol = layer;
                int lastCol = n - 1 - layer;

                // Store the top-left element of the current layer
                int temp = matrix[firstRow][firstCol];

                // Rotate the top row (left to right)
                for (int col = firstCol; col < lastCol; col++) {
                    matrix[firstRow][col] = matrix[firstRow][col + 1];
                }

                // Rotate the right column (top to bottom)
                for (int row = firstRow; row < lastRow; row++) {
                    matrix[row][lastCol] = matrix[row + 1][lastCol];
                }

                // Rotate the bottom row (right to left)
                for (int col = lastCol; col > firstCol; col--) {
                    matrix[lastRow][col] = matrix[lastRow][col - 1];
                }

                // Rotate the left column (bottom to top)
                for (int row = lastRow; row > firstRow; row--) {
                    matrix[row][firstCol] = matrix[row - 1][firstCol];
                }

                // Assign the stored top-left element to the bottom-left position
                matrix[firstRow + 1][firstCol] = temp;
            }
        }

        // Print the resultant matrix
        printMatrix(matrix);
    }


    // Helper method to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void rotateMatrix(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        // Calculate the number of layers in the matrix
        int numLayers = Math.min(m, n) / 2;

        // Perform the rotation r times
        for (int rotation = 0; rotation < r; rotation++) {
            // Rotate each layer
            for (int layer = 0; layer < numLayers; layer++) {
                int firstRow = layer;
                int lastRow = m - 1 - layer;
                int firstCol = layer;
                int lastCol = n - 1 - layer;

                // Store the top-left element of the current layer
                int temp = matrix.get(firstRow).get(firstCol);

                // Rotate the top row (left to right)
                for (int col = firstCol; col < lastCol; col++) {
                    matrix.get(firstRow).set(col, matrix.get(firstRow).get(col + 1));
                }

                // Rotate the right column (top to bottom)
                for (int row = firstRow; row < lastRow; row++) {
                    matrix.get(row).set(lastCol, matrix.get(row + 1).get(lastCol));
                }

                // Rotate the bottom row (right to left)
                for (int col = lastCol; col > firstCol; col--) {
                    matrix.get(lastRow).set(col, matrix.get(lastRow).get(col - 1));
                }

                // Rotate the left column (bottom to top)
                for (int row = lastRow; row > firstRow; row--) {
                    matrix.get(row).set(firstCol, matrix.get(row - 1).get(firstCol));
                }

                // Assign the stored top-left element to the bottom-left position
                matrix.get(firstRow + 1).set(firstCol, temp);
            }
        }

        // Print the resultant matrix
        printMatrix(matrix);
    }

    // Helper method to print the matrix
    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        int r = 3;

        List<List<Integer>> matrix1 = new ArrayList<>();
        matrix1.add(Arrays.asList(1, 2, 3, 4, 5));
        matrix1.add(Arrays.asList(6, 7, 8, 9, 10));
        matrix1.add(Arrays.asList(11, 12, 13, 14, 15));
        matrix1.add(Arrays.asList(16, 17, 18, 19, 20));

//        rotateMatrix(matrix, r);

        rotateMatrix(matrix1, r);
    }
}
