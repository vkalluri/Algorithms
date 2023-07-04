package com.venkat.leetcode.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
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
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue; // Skip duplicates to avoid duplicates in combinations
                }
                current.add(candidates[i]);
                backtrack(result, current, candidates, target - candidates[i], i + 1);
                current.remove(current.size() - 1);
            }
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
