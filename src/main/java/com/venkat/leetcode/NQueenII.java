package com.venkat.leetcode;

/**
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4 Output: 2 Explanation: There are two distinct solutions to the
 * 4-queens puzzle as shown. Example 2:
 * 
 * Input: n = 1 Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 9
 * 
 * To use the code, create an instance of the Solution class and call the
 * totalNQueens method, passing in the value of n. The totalNQueens method will
 * return the number of distinct solutions to the n-queens puzzle.
 */
public class NQueenII {
	private int count;

	public int totalNQueens(int n) {
		count = 0;
		int[] queens = new int[n];
		solveNQueens(queens, 0, n);
		return count;
	}

	private void solveNQueens(int[] queens, int row, int n) {
		if (row == n) {
			count++;
			return;
		}

		for (int col = 0; col < n; col++) {
			if (isValidPlacement(queens, row, col)) {
				queens[row] = col;
				solveNQueens(queens, row + 1, n);
			}
		}
	}

	private boolean isValidPlacement(int[] queens, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (queens[i] == col || queens[i] - queens[row] ==  row - i || queens[i] - queens[row] == i - row) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 4;

		NQueenII solution = new NQueenII();
		int distinctSolutions = solution.totalNQueens(n);

		System.out.println("Number of distinct solutions: " + distinctSolutions);
	}
}
