package com.venkat.codility;

import java.util.ArrayList;

public class SparseNumber {
	public static boolean isSparseNum(int n) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		while (n != 0) {
			al.add(n % 2);
			n = n / 2;
		}

		int size = al.size();
		for (int i = 0; i < size - 1; i++) {
			// checking whether the two consecutive elements are 1 or not
			if ((al.get(i) == al.get(i + 1)) && (al.get(i) == 1)) {
				return false;
			}
		}

		return true;

	}

	public static boolean isSparseNum1(int n) {

		int rightShiftNum = n >> 1;

		if ((n & rightShiftNum) > 0) {
			return false;
		}

		return true;

	}
	
	public static void main(String[] args) {
		int range = 20;  
		  
//		System.out.println("The Spare numbers lying between 1 to " + range + " are: ");  
		
		System.out.println(isSparseNum(26));
//		 long startTime = System.currentTimeMillis(); 
//		for(int i = 1; i <= range; i++)  
//		{  
//		    if(isSparseNum(i))  
//		    {  
//		        System.out.print(i + " ");  
//		    }  
//		} 
//		System.out.println(System.currentTimeMillis() - startTime);
//		
//		startTime = System.currentTimeMillis(); 
//		for(int i = 1; i <= range; i++)  
//		{  
//		    if(isSparseNum1(i))  
//		    {  
//		        System.out.print(i + " ");  
//		    }  
//		} 
//		System.out.println(System.currentTimeMillis() - startTime);
	}

}
