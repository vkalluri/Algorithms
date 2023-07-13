package com.venkat.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * Find Eventual Safe States
 * Medium
 * 4.6K
 * 401
 * Companies
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1.
 * The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an
 * #integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
 *
 * A node is a terminal node if there are no outgoing edges. A node is a safe node
 * if every possible path starting from that node leads to a terminal node (or another safe node).
 *
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Illustration of graph
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Explanation: The given graph is shown above.
 * Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
 * Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
 * Example 2:
 *
 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * Output: [4]
 * Explanation:
 * Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 *
 *
 * Constraints:
 *
 * n == graph.length
 * 1 <= n <= 104
 * 0 <= graph[i].length <= n
 * 0 <= graph[i][j] <= n - 1
 * graph[i] is sorted in a strictly increasing order.
 * The graph may contain self-loops.
 * The number of edges in the graph will be in the range [1, 4 * 104].
 */
public class SafeStates {

    /**
     * In this implementation, we use a depth-first search (DFS) approach to check whether
     * a node is safe or not. We keep track of the state of each node using an array called colors,
     * where colors[i] represents the state of node i (0: unvisited, 1: visiting, 2: safe).
     *
     * We iterate through each node in the graph and call the isSafe function to determine
     * if it is a safe node. The isSafe function performs a DFS traversal starting from the current node.
     * If it encounters a node that is already marked as visiting (indicating a cycle), it returns false. Otherwise,
     * it recursively visits all the neighbors of the current node. If all the neighbors are safe nodes,
     * the current node is marked as safe and the function returns true.
     *
     * Finally, we collect all the safe nodes in a list and return it in ascending order.
     *
     * You can use this solution by creating an instance of the Solution class and calling the eventualSafeNodes m
     * ethod with the graph as the input. The method will return a list containing all the safe nodes in the graph.
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0: unvisited, 1: visiting, 2: safe

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe(graph, colors, i)) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean isSafe(int[][] graph, int[] colors, int node) {
        if (colors[node] > 0) {
            return colors[node] == 2;
        }

        colors[node] = 1;
        for (int next : graph[node]) {
            if (!isSafe(graph, colors, next)) {
                return false;
            }
        }

        colors[node] = 2;
        return true;
    }
}
