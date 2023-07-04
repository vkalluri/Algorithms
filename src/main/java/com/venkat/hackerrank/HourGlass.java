package com.venkat.hackerrank;

import java.util.List;

public class HourGlass {
	
	public static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int currentSum = calculateHourglassSum(arr, i, j);
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    private static int calculateHourglassSum(int[][] arr, int row, int col) {
        int sum = 0;

        // Calculate the sum of elements in the hourglass
        sum += arr[row][col];
        sum += arr[row][col + 1];
        sum += arr[row][col + 2];
        sum += arr[row + 1][col + 1];
        sum += arr[row + 2][col];
        sum += arr[row + 2][col + 1];
        sum += arr[row + 2][col + 2];

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}
        };

        int maxHourglassSum = hourglassSum(arr);
        System.out.println("Maximum hourglass sum: " + maxHourglassSum);
    }
    
    public static int hourglassSum(List<List<Integer>> grid) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < grid.size() - 2; i++) {
            for (int j = 0; j < grid.get(i).size() - 2; j++) {
                int currentSum = calculateHourglassSum(grid, i, j);
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    private static int calculateHourglassSum(List<List<Integer>> grid, int row, int col) {
        int sum = 0;

        // Calculate the sum of elements in the hourglass
        sum += grid.get(row).get(col);
        sum += grid.get(row).get(col + 1);
        sum += grid.get(row).get(col + 2);
        sum += grid.get(row + 1).get(col + 1);
        sum += grid.get(row + 2).get(col);
        sum += grid.get(row + 2).get(col + 1);
        sum += grid.get(row + 2).get(col + 2);

        return sum;
    } 	

}
