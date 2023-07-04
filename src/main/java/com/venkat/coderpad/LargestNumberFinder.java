package com.venkat.coderpad;

public class LargestNumberFinder {
	 public static int findLargestNumber(int[] numbers) {
	        // Check if the array is empty
	        if (numbers == null || numbers.length == 0) {
	            throw new IllegalArgumentException("Array is empty.");
	        }

	        // Assume the first number is the largest
	        int largestNumber = numbers[0];

	        // Iterate through the array starting from the second number
//	        for (int i = 1; i < numbers.length; i++) {
//	            // If a larger number is found, update the largestNumber variable
//	            if (numbers[i] > largestNumber) {
//	                largestNumber = numbers[i];
//	            }
//	        }
	        
	        for(int n : numbers) {
	        	if(n > largestNumber) {
	        		largestNumber = n;
	        	}
	        }

	        return largestNumber;
	    }

	    public static void main(String[] args) {
	        int[] numbers = { 5, 3, 9, 1, 7 };
	        int largestNumber = findLargestNumber(numbers);
	        System.out.println("The largest number in the array is: " + largestNumber);
	    }
}
