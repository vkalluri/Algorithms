package com.venkat.other;

import java.util.Scanner;

public class TravelDiaries {
	 public static void main(String[] args) {

	        // Create a Scanner object to read input from the console.
	        Scanner scanner = new Scanner(System.in);

	        // Read the number of rows and columns in the matrix.
	        int rows = scanner.nextInt();
	        int columns = scanner.nextInt();

	        // Create a matrix to store the values.
	        int[][] matrix = new int[rows][columns];

	        // Read the values in the matrix.
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < columns; j++) {
	                matrix[i][j] = scanner.nextInt();
	            }
	        }

	        // Find the number of seconds it takes for all the 1s to be converted to 2s.
	        int seconds = 0;
	        while (true) {
	            boolean changed = false;
	            for (int i = 0; i < rows; i++) {
	                for (int j = 0; j < columns; j++) {
	                    if (matrix[i][j] == 1 && isAdjacentTo2(matrix, i, j)) {
	                        matrix[i][j] = 2;
	                        changed = true;
	                    }
	                }
	            }
	            if (!changed) {
	                break;
	            }
	            seconds++;
	        }

	        // Print the number of seconds.
	        System.out.println(seconds);
	        scanner.close();
	    }

	    private static boolean isAdjacentTo2(int[][] matrix, int row, int column) {
	        for (int i = row - 1; i <= row + 1; i++) {
	            if (i < 0 || i >= matrix.length) {
	                continue;
	            }
	            for (int j = column - 1; j <= column + 1; j++) {
	                if (j < 0 || j >= matrix[0].length) {
	                    continue;
	                }
	                if (matrix[i][j] == 2) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
}
