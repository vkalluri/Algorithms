package com.venkat.codility;

import java.util.Scanner;

public class TicTacToe {
	private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------");
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWinningMove(int row, int col) {
        // Check row
        if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != '-') {
            return true;
        }
        // Check column
        if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != '-') {
            return true;
        }
        // Check diagonals
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-')) {
            return true;
        }
        return false;
    }

    public void makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        int row, col;

        System.out.println("Welcome to Tic Tac Toe!");

        while (!game.isBoardFull()) {
            game.printBoard();
            System.out.print("Player " + game.currentPlayer + ", enter your move (row col): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            game.makeMove(row, col);
            if (game.isWinningMove(row, col)) {
                System.out.println("Player " + game.currentPlayer + " wins!");
                break;
            }
        }

        if (game.isBoardFull()) {
            System.out.println("It's a tie!");
        }

        game.printBoard();
        scanner.close();
    }
}
