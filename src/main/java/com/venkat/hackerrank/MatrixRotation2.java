package com.venkat.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixRotation2 {
    public static void rotateMatrix(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int totalElements = m * n;
        int rotations = r % totalElements;

        // Perform the rotation r times
        for (int rotation = 0; rotation < rotations; rotation++) {
            int startRow = 0, startCol = 0;
            int endRow = m - 1, endCol = n - 1;

            // Rotate each layer
            while (startRow < endRow && startCol < endCol) {
                int prev = matrix.get(startRow).get(startCol);

                // Rotate top row
                for (int col = startCol; col < endCol; col++) {
                    int curr = matrix.get(startRow).get(col + 1);
                    matrix.get(startRow).set(col + 1, prev);
                    prev = curr;
                }

                // Rotate right column
                for (int row = startRow; row < endRow; row++) {
                    int curr = matrix.get(row + 1).get(endCol);
                    matrix.get(row + 1).set(endCol, prev);
                    prev = curr;
                }

                // Rotate bottom row
                for (int col = endCol; col > startCol; col--) {
                    int curr = matrix.get(endRow).get(col - 1);
                    matrix.get(endRow).set(col - 1, prev);
                    prev = curr;
                }

                // Rotate left column
                for (int row = endRow; row > startRow; row--) {
                    int curr = matrix.get(row - 1).get(startCol);
                    matrix.get(row - 1).set(startCol, prev);
                    prev = curr;
                }

                startRow++;
                startCol++;
                endRow--;
                endCol--;
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
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2, 3, 4, 5));
        matrix.add(Arrays.asList(6, 7, 8, 9, 10));
        matrix.add(Arrays.asList(11, 12, 13, 14, 15));
        matrix.add(Arrays.asList(16, 17, 18, 19, 20));

        int r = 3;

        rotateMatrix(matrix, r);
    }
}
