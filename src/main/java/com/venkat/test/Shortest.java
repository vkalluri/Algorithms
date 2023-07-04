package com.venkat.test;

import java.util.ArrayList;
import java.util.List;

public class Shortest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int DP[][] = {{0,0,1,0},
//            {1,0,0,0},
//            {0,0,1,0}};
//
//		System.out.println(shortestPath(3, 4, DP));
		
//		char DP[][] =  {
//			{'A', 'B'},
//			{'B', 'C'}
//		};
//		
//		System.out.println(transitiveBuyCount(2, DP));
		
//		int DP[][] = new int[3][4];
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 4; j++) {
//                DP[i][j] = 0;
//            }
//        }
		int DP[][] = {{0,0,1,0},
	            {1,0,0,0},
	            {0,0,1,0},
	            {0,0,1,0}};
 
        System.out.println(numberOfPaths(3, 4, DP));
	}

	public static int shortestPath(int rows, int cols, int[][] grid) {
		if (rows == 1 || cols == 1) {
			return grid[rows][cols];
		}

		if (grid[rows][cols] == 0) {
			grid[rows][cols] = shortestPath(rows - 1, cols, grid) + shortestPath(rows, cols - 1, grid);
		}

		return grid[rows][cols];
	}
	
	static int transitiveBuyCount(int initialCount, char[][] buys) {
		int i = 0;
		List<String> charList = new ArrayList<String>();
		 for (int row = 0; row < buys.length; row++) {
			    for (int col = 0; col < buys[row].length; col++) {
			    	charList.add(String.valueOf(buys[row][col]));
			    }
			 }
		 String n = null;
		 for(String s: charList) {
			if(s.equals(n)) {
				i++;
			}
			n = s;
			System.out.println(n);
			System.out.println(s);;
		 }
		 System.out.println(charList);
		 return i;
	}
	static int numberOfPaths(int n, int m, int DP[][])
    {
        if (n == 1 || m == 1)
            return DP[n][m] = 1;
 
        // Add the element in the DP table
        // If it was not computed before
//        if (DP[n][m] == 0)
//            DP[n][m] = numberOfPaths(n - 1, m, DP)
//                       + numberOfPaths(n, m - 1, DP);
 
        for(int i=1; i<n; i++) {
        	for(int j=1; j<m; j++) {
        		DP[i][j] = DP[n-1][m] + DP[n][m-1];
        	}
        }
        return DP[n-1][m-1];
    }
}
