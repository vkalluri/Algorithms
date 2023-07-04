package com.venkat.leetcode.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /**
     * In this program, the combinationSum method takes an array of distinct integers candidates and a target
     * integer target as input and returns a list of all unique combinations of candidates that sum to the target.
     * It initializes an empty list combinations to store the result. The backtrack method performs the backtracking
     * algorithm to generate the combinations. It starts by checking if the current combination sum equals the target.
     * If it does, the combination is added to the result. If the current sum exceeds the target, the method returns to backtrack.
     * Otherwise, it iterates through the candidates starting from the given index and recursively calls the backtrack
     * method with the updated target and current combination. After each recursive call, the last added candidate is
     * removed to backtrack and try other combinations. Finally, the main method demonstrates an example
     * usage of the combinationSum method by passing the candidates and target and printing the unique combinations.
     *
     * @param candidates
     * @param target
     * @return
     */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates array for pruning

        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(
            List<List<Integer>> result,
            List<Integer> current,
            int[] candidates,
            int target,
            int start
    ) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            // The current combination sum exceeds the target, backtrack
            return;
        }
//        else if (target > 0) {
//            for (int i = start; i < candidates.length; i++) {
//                if (i > start && candidates[i] == candidates[i - 1]) {
//                    continue; // Skip duplicates to avoid duplicates in combinations
//                }
//                current.add(candidates[i]);
//                backtrack(result, current, candidates, target - candidates[i], i + 1);
//                current.remove(current.size() - 1);
//            }
//        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);  // Add the current candidate to the combination
           // backtrack(candidates, target - candidates[i], current, combinations, i);
            backtrack(result, current, candidates, target - candidates[i], i );
            current.remove(current.size() - 1);  // Remove the current candidate to backtrack
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(candidates, target);

        // Print the combinations
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

}
