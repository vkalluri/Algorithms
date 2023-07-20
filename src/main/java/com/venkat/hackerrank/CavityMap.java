package com.venkat.hackerrank;

import java.util.ArrayList;
import java.util.List;


/**
 * You are given a square map as a matrix of integer strings. Each cell of the map has a
 * value denoting its depth. We will call a cell of the map a cavity if and only if this cell
 * is not on the border of the map and each cell adjacent to it has strictly smaller depth.
 * Two cells are adjacent if they have a common side, or edge.
 *
 * Find all the cavities on the map and replace their depths with the uppercase character X.
 *
 * Example
 * grid = ['989','191','111']
 *
 * The grid is rearranged for clarity:
 * 989
 * 191
 * 111
 *
 * Return:
 * 989
 * 1X1
 * 111
 *
 * The center cell was deeper than those on its edges: [8,1,1,1]. The deep cells in the top two
 * corners do not share an edge with the center cell, and none of the border cells is eligible.
 *
 * Function Description
 *
 * Complete the cavityMap function in the editor below.
 *
 * cavityMap has the following parameter(s):
 *
 * string grid[n]: each string represents a row of the grid
 *
 * Returns
 * string{n}: the modified grid
 *
 * Input Format
 * The first line contains an integer n, the number of rows and columns in the grid.
 *
 * Each of the following n lines (rows) contains  positive digits without spaces (columns) that represent the depth at grid[row,column].
 *
 * Constraints
 * 1 <= n <= 100
 */
public class CavityMap {

    /**
     * The cavityMap function takes a list of strings representing the square map as input
     * and returns the modified grid with cavities marked by 'X'. It first converts the input
     * grid into a 2D char array, then iterates through the interior cells of the map to find
     * cavities and replaces their depths with 'X'. Finally, it converts the modified 2D char
     * array back to a list of strings and returns the result. The main method demonstrates
     * how to use this function with the given example input
     *
     * @param grid
     * @return
     */
    public static List<String> cavityMap(List<String> grid) {
        int n = grid.size();
        char[][] map = new char[n][n];

        // Convert the input grid to a 2D char array
        for (int i = 0; i < n; i++) {
            String row = grid.get(i);
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        // Mark cavities with 'X'
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int currentDepth = map[i][j] - '0';
                if (currentDepth > (map[i - 1][j] - '0') &&
                        currentDepth > (map[i + 1][j] - '0') &&
                        currentDepth > (map[i][j - 1] - '0') &&
                        currentDepth > (map[i][j + 1] - '0')) {
                    map[i][j] = 'X';
                }
            }
        }

        // Convert the 2D char array back to a list of strings
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(map[i][j]);
            }
            result.add(row.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> grid = new ArrayList<>();
        grid.add("989");
        grid.add("191");
        grid.add("111");

        List<String> result = cavityMap(grid);
        for (String row : result) {
            System.out.println(row);
        }
        // Output:
        // 989
        // 1X1
        // 111
    }
}
