package com.venkat.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

    /**
     * Given an m x n grid of characters board and a string word,
     * return positions of the letters in the grid.
     *
     *
     *
     * The word can be constructed from letters of sequentially adjacent cells,
     * where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
     *
     *
     *
     * static int[][] exists(char[][] matrix, String word) {}
     * @param args
     */
    public static void main(String[] args){
        char[][] matrix = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'B'}
        };
        String s = "ABCCED";
    }
    public List<int[]> findWordPositions(char[][] board, String word) {
        List<int[]> positions = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return positions;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    positions.add(new int[]{i, j});
                }
            }
        }

        return positions;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }

        if (k == word.length() - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i, j - 1, k + 1);

        board[i][j] = temp;

        return found;
    }

    public int[][] findWordPositions1(char[][] board, String word) {
        List<int[]> positions = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return new int[0][0];
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    positions.add(new int[]{i, j});
                }
            }
        }

        int[][] result = new int[positions.size()][2];
        for (int i = 0; i < positions.size(); i++) {
            result[i] = positions.get(i);
        }

        return result;
    }




}
