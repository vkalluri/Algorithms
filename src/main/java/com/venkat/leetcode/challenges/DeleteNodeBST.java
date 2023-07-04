package com.venkat.leetcode.challenges;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,7], key = 0
 * Output: [5,3,6,2,4,null,7]
 * Explanation: The tree does not contain a node with value = 0.
 * Example 3:
 *
 * Input: root = [], key = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -105 <= Node.val <= 105
 * Each node has a unique value.
 * root is a valid binary search tree.
 * -105 <= key <= 105
 *
 *
 * Follow up: Could you solve it with time complexity O(height of tree)?
 */
public class DeleteNodeBST {
    /**
     * In this program, the deleteNode method takes the root node reference of a Binary Search Tree (BST)
     * and a key to delete as input. It performs a recursive search for the node with the given key in the BST.
     * If the key is less than the current node's value, the method recursively searches in the left subtree.
     * If the key is greater than the current node's value, it searches in the right subtree.
     * If the key matches the current node's value, it proceeds to delete the node.
     *
     * If the node to delete has no left child, the method returns its right child as the new root of the subtree.
     * If it has no right child, the method returns its left child. If the node has both left and right children,
     * the method finds the minimum value in its right subtree (the smallest node greater than the current node)
     * and replaces the current node's value with the minimum value. Then, it recursively deletes the minimum node from the right subtree.
     *
     * The findMin method is a helper function that finds and returns the minimum node in a given subtree.
     *
     * In the main method, an example BST is created, and a node with the key 3 is deleted.
     * The program then prints the value of the new root node after deletion.
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode1 deleteNode(TreeNode1 root, int key) {
        if (root == null) {
            return null;
        }

        // Search for the node to remove
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with the given key is found, delete it
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node has both left and right subtrees
            TreeNode1 minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }

        return root;
    }

    private static TreeNode1 findMin(TreeNode1 node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(5);
        root.left = new TreeNode1(3);
        root.right = new TreeNode1(6);
        root.left.left = new TreeNode1(2);
        root.left.right = new TreeNode1(4);
        root.right.right = new TreeNode1(7);

        int key = 3;
        TreeNode1 result = deleteNode(root, key);
        System.out.println("Root node value after deletion: " + result.val);
    }
}
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
