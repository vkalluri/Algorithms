package com.venkat.coderpad;

import java.util.Arrays;
import java.util.List;

public class SumOfArray {
	public static void main(String args[]){
	      //Reading the array from the user
	     List<Integer> listOfNums = Arrays.asList(1,2,3,4,5);
	     SumOfArray sumofArray = new SumOfArray();
	     sumofArray.findNum(listOfNums, 4);
	   }
	
	public  void findNum(List<Integer> listNums, int num) {
		 for(int i=0; i<listNums.size(); i++){
	         for (int j=i; j<listNums.size(); j++){
	            if((listNums.get(i) + listNums.get(j))== num && i!=j){
	               System.out.println(listNums.get(i)+", "+listNums.get(j));
	            }
	         }
	      }
	}
}
