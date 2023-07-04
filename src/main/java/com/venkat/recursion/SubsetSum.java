package com.venkat.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

	public SubsetSum() {
		// TODO Auto-generated constructor stub
	}
	public static List<List<Integer>> findSubsets(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int[] nums, int target, int start, List<Integer> tempList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
        } else if (target < 0) {
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(nums, target - nums[i], i + 1, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> subsets = findSubsets(nums, target);
        System.out.println("Subsets with sum " + target + ": " + subsets);
    }
}
