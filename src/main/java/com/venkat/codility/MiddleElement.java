package com.venkat.codility;

public class MiddleElement {

	public static void main(String[] args) {
		int[] sequence = {1, 2, 3, 4, 5, 6};
		System.out.println(findMiddleElement(sequence));
	}
	public static int findMiddleElement(int[] sequence) {
		int middleIndex = sequence.length/2;
		
		int middleElement = 0;
		
		if(sequence.length%2 ==1) {
			middleElement = sequence[middleIndex];
		}else {
			middleElement = sequence[middleIndex-1] + sequence[middleIndex];
		}
		
		return middleElement;
	}
	
}
