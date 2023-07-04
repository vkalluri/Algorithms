package com.venkat.leetcode.challenges;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

public class BinaryTree {
	private int maxPathSum;

	/**
	 * In this code, the TreeNode class represents a node in the binary tree. Each
	 * node has a value and references to its left and right child nodes.
	 * 
	 * The BinaryTree class contains the maxPathSum method, which is the entry point
	 * to find the maximum path sum. The calculateMaxPathSum method is a recursive
	 * helper function that calculates the maximum sum of a path starting from the
	 * given node. It returns the maximum sum of a path starting from the current
	 * node, and updates the maxPathSum variable if the current node is part of the
	 * maximum path sum.
	 * 
	 * In the main method, a binary tree is created, and the maxPathSum method is
	 * called to find the maximum path sum. Finally, the result is printed to the
	 * console.
	 * 
	 * @param root
	 * @return
	 */
	public int maxPathSum(TreeNode root) {
		maxPathSum = Integer.MIN_VALUE;
		calculateMaxPathSum(root);
		return maxPathSum;
	}

	private int calculateMaxPathSum(TreeNode node) {
		if (node == null) {
			return 0;
		}

		// Recursively calculate the maximum path sum for the left and right subtrees
		int leftSum = Math.max(0, calculateMaxPathSum(node.left));
		int rightSum = Math.max(0, calculateMaxPathSum(node.right));

		// Update the maximum path sum if the current node is part of the path
		maxPathSum = Math.max(maxPathSum, leftSum + rightSum + node.val);

		// Return the maximum sum of a path starting from the current node
		return Math.max(leftSum, rightSum) + node.val;
	}
}
