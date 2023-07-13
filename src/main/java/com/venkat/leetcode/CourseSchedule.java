package com.venkat.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph based on the prerequisites
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(course).add(prerequisiteCourse);
        }

        // Keep track of visited nodes
        boolean[] visited = new boolean[numCourses];
        // Keep track of nodes in the current DFS path
        boolean[] dfsPath = new boolean[numCourses];

        // Perform DFS on each node in the graph
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(graph, visited, dfsPath, i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean hasCycle(List<List<Integer>> graph, boolean[] visited, boolean[] dfsPath, int node) {
        visited[node] = true;
        dfsPath[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(graph, visited, dfsPath, neighbor)) {
                    return true;
                }
            } else if (dfsPath[neighbor]) {
                return true;
            }
        }

        dfsPath[node] = false;
        return false;
    }

    public static void main(String[] args){
        int numCourses = 2;
        int[][] preRequsites = {{1,0}};

        System.out.println(canFinish(numCourses, preRequsites));
    }
}
