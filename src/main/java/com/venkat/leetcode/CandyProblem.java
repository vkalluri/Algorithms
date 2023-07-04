package com.venkat.leetcode;

import java.util.Arrays;

public class CandyProblem {
	public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Initialize all candies to 1
        Arrays.fill(candies, 1);
        
        // Traverse from left to right, assign more candies to higher-rated children
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Traverse from right to left, ensure right neighbors have more candies if needed
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        // Calculate the total number of candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        
        return totalCandies;
    }
	
	public static void main(String[] args) {
		int[] i = {1,2,2};
		
		System.out.println(candy(i));
	}
}
