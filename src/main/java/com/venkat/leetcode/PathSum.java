package com.venkat.leetcode;


/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 1000].
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */
public class PathSum {


    /**
     * To find the number of paths in a binary tree where the sum of values along the path equals
     * the target sum, we can use a recursive approach. For each node in the tree, we can explore
     * all possible paths that start from that node and find the count of such paths.
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        // Explore paths that start from the current node and count the valid paths
        int pathsFromRoot = countPaths(root, targetSum);

        // Recursively explore paths in the left and right subtrees
        int pathsInLeftSubtree = pathSum(root.left, targetSum);
        int pathsInRightSubtree = pathSum(root.right, targetSum);

        // Total number of paths is the sum of pathsFromRoot, pathsInLeftSubtree, and pathsInRightSubtree
        return pathsFromRoot + pathsInLeftSubtree + pathsInRightSubtree;
    }

    private static int countPaths(TreeNode node, int targetSum) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.val == targetSum) {
            count++;
        }

        // Recursively explore paths in the left and right subtrees
        count += countPaths(node.left, targetSum - node.val);
        count += countPaths(node.right, targetSum - node.val);

        return count;
    }

    //1,null,2,null,3,null,4,null,5
    public static void main(String... args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        int numPaths = pathSum(root, targetSum);
        System.out.println("Number of paths with sum " + targetSum + ": " + numPaths);
        // Output: Number of paths with sum 8: 3
    }
}
