package com.venkat.leetcode.challenges;

import java.util.LinkedList;
import java.util.Queue;

public class NearestZeroDistance {
	/**
	 * In this code, the nearestZeroDistance method takes a binary matrix mat as
	 * input and returns a matrix distances of the same size, where each cell
	 * represents the distance of the nearest 0 in the mat matrix.
	 * 
	 * The method first initializes the distances matrix with maximum values,
	 * representing an initial "infinity" distance for all cells.
	 * 
	 * Then, it creates a queue to perform breadth-first search (BFS). It enqueues
	 * all the cells with 0 in the mat matrix, updates their distance to 0, and
	 * marks them as visited.
	 * 
	 * After that, it defines the four directions
	 * 
	 * @param mat
	 * @return
	 */
	public static int[][] nearestZeroDistance(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] distances = new int[m][n];

		// Initialize distances matrix with maximum value
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				distances[i][j] = Integer.MAX_VALUE;
			}
		}

		// Create a queue to perform BFS
		Queue<int[]> queue = new LinkedList<>();

		// Enqueue all cells with 0, update their distance to 0
		// and mark them as visited
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					distances[i][j] = 0;
					queue.offer(new int[] { i, j });
				}
			}
		}

		// Define the directions for neighbors (up, down, left, right)
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		// Perform BFS on the queue until it becomes empty
		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			int row = cell[0];
			int col = cell[1];

			// Check all neighboring cells
			for (int[] direction : directions) {
				int newRow = row + direction[0];
				int newCol = col + direction[1];

				// Check if the new cell is within bounds
				if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
					// If the new cell is unvisited and the distance
					// can be updated, enqueue it, update the distance,
					// and mark it as visited
					if (distances[newRow][newCol] == Integer.MAX_VALUE) {
						queue.offer(new int[] { newRow, newCol });
						distances[newRow][newCol] = distances[row][col] + 1;
					}
				}
			}
		}

		return distances;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		int[][] distances = nearestZeroDistance(matrix);

		// Print the distances matrix
		for (int[] row : distances) {
			for (int dist : row) {
				System.out.print(dist + " ");
			}
			System.out.println();
		}
	}
}
