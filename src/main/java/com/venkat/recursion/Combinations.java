package com.venkat.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public Combinations() {
		// TODO Auto-generated constructor stub
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(n, k, 1, new ArrayList<>(), result);
		return result;
	}

	public static void backtrack(int n, int k, int start, List<Integer> tempList, List<List<Integer>> result) {
		if (tempList.size() == k) {
			result.add(new ArrayList<>(tempList));
		} else {
			for (int i = start; i <= n; i++) {
				tempList.add(i);
				backtrack(n, k, i + 1, tempList, result);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		List<List<Integer>> combinations = combine(n, k);
		System.out.println("Combinations: " + combinations);
	}
}
