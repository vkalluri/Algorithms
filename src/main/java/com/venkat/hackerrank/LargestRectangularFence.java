package com.venkat.hackerrank;

import java.util.Arrays;
import java.util.List;

public class LargestRectangularFence {
    public static int calculateLargestPerimeter(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        int maxPerimeter = 0;

        // Fill the first row of the dynamic programming array
        for (int col = 0; col < n; col++) {
            if (grid[0][col] == 'x') {
                dp[0][col] = 0;
            } else {
                dp[0][col] = 1;
                maxPerimeter = Math.max(maxPerimeter, 2);
            }
        }

        // Fill the first column of the dynamic programming array
        for (int row = 1; row < m; row++) {
            if (grid[row][0] == 'x') {
                dp[row][0] = 0;
            } else {
                dp[row][0] = dp[row - 1][0] + 1;
                maxPerimeter = Math.max(maxPerimeter, 2 * dp[row][0]);
            }
        }

        // Fill the remaining cells of the dynamic programming array
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (grid[row][col] == 'x') {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] = dp[row - 1][col] + 1;
                    int minWidth = dp[row][col];

                    // Calculate the maximum width for the current cell
                    for (int k = col - 1; k >= 0; k--) {
                        if (grid[row][k] == 'x') {
                            break;
                        }
                        minWidth = Math.min(minWidth, dp[row][k]);
                        maxPerimeter = Math.max(maxPerimeter, 2 * (col - k + 1) + 2 * minWidth);
                    }
                }
            }
        }

        return maxPerimeter;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'.', '.', '.', '.'},
                {'.', 'x', '.', '.'},
                {'.', '.', 'x', 'x'},
                {'.', '.', '.', '.'}
        };

        int largestPerimeter = calculateLargestPerimeter(grid);
        System.out.println("Largest perimeter of the rectangular fence: " + largestPerimeter);

        List<String> grid1 = Arrays.asList(
                ".x",
                "x."
        );

        int largestPerimeter1 = calculateLargestPerimeter(grid1);
        System.out.println("Largest perimeter of the rectangular fence: " + largestPerimeter1);
    }

    public static int calculateLargestPerimeter(List<String> grid) {
        int m = grid.size();
        int n = grid.get(0).length();

        int[][] dp = new int[m][n];
        int maxPerimeter = 0;

        // Fill the first row of the dynamic programming array
        for (int col = 0; col < n; col++) {
            if (grid.get(0).charAt(col) == 'x') {
                dp[0][col] = 0;
            } else {
                dp[0][col] = 1;
                maxPerimeter = Math.max(maxPerimeter, 2);
            }
        }

        // Fill the first column of the dynamic programming array
        for (int row = 1; row < m; row++) {
            if (grid.get(row).charAt(0) == 'x') {
                dp[row][0] = 0;
            } else {
                dp[row][0] = dp[row - 1][0] + 1;
                maxPerimeter = Math.max(maxPerimeter, 2 * dp[row][0]);
            }
        }

        // Fill the remaining cells of the dynamic programming array
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (grid.get(row).charAt(col) == 'x') {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] = dp[row - 1][col] + 1;
                    int minWidth = dp[row][col];

                    // Calculate the maximum width for the current cell
                    for (int k = col - 1; k >= 0; k--) {
                        if (grid.get(row).charAt(k) == 'x') {
                            break;
                        }
                        minWidth = Math.min(minWidth, dp[row][k]);
                        maxPerimeter = Math.max(maxPerimeter, 2 * (col - k + 1) + 2 * minWidth);
                    }
                }
            }
        }

        return maxPerimeter;
    }
}
