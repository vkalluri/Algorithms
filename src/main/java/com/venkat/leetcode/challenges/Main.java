package com.venkat.leetcode.challenges;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		// Create a binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		BinaryTree binaryTree = new BinaryTree();
		int maxPathSum = binaryTree.maxPathSum(root);

		System.out.println("Maximum path sum: " + maxPathSum);

		WordSearch wordSearch = new WordSearch();

		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

		String[] words = { "oath", "pea", "eat", "rain" };

		List<String> foundWords = wordSearch.findWords(board, words);

		System.out.println("Found words: " + foundWords);
	}
}
