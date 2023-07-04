package com.venkat.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n board of characters and a list of strings words, return all
 * words on the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board =
 * [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"] Output: ["eat","oath"] Example 2:
 * 
 * 
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"] Output: []
 * 
 * 
 * Constraints:
 * 
 * m == board.length n == board[i].length 1 <= m, n <= 12 board[i][j] is a
 * lowercase English letter. 1 <= words.length <= 3 * 104 1 <= words[i].length
 * <= 10 words[i] consists of lowercase English letters. All the strings of
 * words are unique.
 */
public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		TrieNode root = buildTrie(words);
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, i, j, root, result);
			}
		}

		return result;
	}

	private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
		char c = board[i][j];
		if (c == '#' || node.children[c - 'a'] == null) {
			return;
		}

		node = node.children[c - 'a'];
		if (node.word != null) {
			result.add(node.word);
			node.word = null; // Avoid duplicates
		}

		board[i][j] = '#'; // Mark cell as visited

		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int m = board.length;
		int n = board[0].length;

		for (int[] direction : directions) {
			int ni = i + direction[0];
			int nj = j + direction[1];
			if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
				dfs(board, ni, nj, node, result);
			}
		}

		board[i][j] = c; // Restore cell value
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				int index = c - 'a';
				if (node.children[index] == null) {
					node.children[index] = new TrieNode();
				}
				node = node.children[index];
			}
			node.word = word;
		}
		return root;
	}

	private class TrieNode {
		TrieNode[] children;
		String word;

		TrieNode() {
			children = new TrieNode[26];
			word = null;
		}
	}

	public static void main(String[] args) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

		String[] words = { "oath", "pea", "eat", "rain" };

		WordSearchII solution = new WordSearchII();
		List<String> result = solution.findWords(board, words);

		System.out.println(result);
	}
}
