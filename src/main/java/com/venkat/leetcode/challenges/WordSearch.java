package com.venkat.leetcode.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
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
 * 
 * @author vkall
 *
 */
class TrieNode {
	Map<Character, TrieNode> children;
	boolean isWord;

	TrieNode() {
		children = new HashMap<>();
		isWord = false;
	}
}

class Trie {
	TrieNode root;

	Trie() {
		root = new TrieNode();
	}

	void insert(String word) {
		TrieNode node = root;

		for (char c : word.toCharArray()) {
			node.children.putIfAbsent(c, new TrieNode());
			node = node.children.get(c);
		}

		node.isWord = true;
	}
}

class WordSearch {
	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();

		// Build the trie using the words list
		for (String word : words) {
			trie.insert(word);
		}

		Set<String> result = new HashSet<>();
		int rows = board.length;
		int cols = board[0].length;

		// Perform backtracking for each cell in the board
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				backtrack(board, i, j, rows, cols, trie.root, new StringBuilder(), result);
			}
		}

		return new ArrayList<>(result);
	}

	private void backtrack(char[][] board, int row, int col, int rows, int cols, TrieNode node, StringBuilder sb,
			Set<String> result) {
		char c = board[row][col];

		if (c == '#' || !node.children.containsKey(c)) {
			return; // Cell already visited or no matching word in the trie
		}

		// Update the current node and append the character to the string builder
		node = node.children.get(c);
		sb.append(c);

		if (node.isWord) {
			result.add(sb.toString()); // Found a word
		}

		board[row][col] = '#'; // Mark the cell as visited

		// Explore the neighboring cells
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		for (int k = 0; k < 4; k++) {
			int newRow = row + dx[k];
			int newCol = col + dy[k];

			if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
				backtrack(board, newRow, newCol, rows, cols, node, sb, result);
			}
		}

		board[row][col] = c; // Restore the original character
		sb.deleteCharAt(sb.length() - 1); // Remove the appended character
	}
}
