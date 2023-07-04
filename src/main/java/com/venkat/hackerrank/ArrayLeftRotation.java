package com.venkat.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A left rotation operation on an array shifts each of the array's elements
 * unit to the left. For example, if left rotations are performed on array ,
 * then the array would become . Note that the lowest index item moves to the
 * highest index in a rotation. This is called a circular array.
 * 
 * Given an array of integers and a number, , perform left rotations on the
 * array. Return the updated array to be printed as a single line of
 * space-separated integers.
 * 
 * Function Description
 * 
 * Complete the function rotLeft in the editor below.
 * 
 * rotLeft has the following parameter(s):
 * 
 * int a[n]: the array to rotate int d: the number of rotations Returns
 * 
 * int a'[n]: the rotated array Input Format
 * 
 * The first line contains two space-separated integers and , the size of and
 * the number of left rotations. The second line contains space-separated
 * integers, each an .
 * 
 * Constraints
 * 
 * 
 * @author vkall
 *
 */
public class ArrayLeftRotation {
	/**
	 * In this code, the leftRotate method takes an integer array arr and the number
	 * of left rotations d as input. It creates a new array rotatedArray of the same
	 * size as arr to store the rotated elements.
	 * 
	 * The method then iterates over each element in the original array and
	 * calculates the new index for each element after d left rotations. The formula
	 * (i + (n - d)) % n calculates the new index by subtracting d from the current
	 * index i and taking the modulo n to handle wrap-around.
	 * 
	 * Finally, the method returns the rotatedArray with the elements after
	 * performing d left rotations.
	 * 
	 * In the main method, we provide an example array arr and the number of left
	 * rotations d as inputs. The leftRotate method is called to perform the left
	 * rotations, and the resulting array is printed.
	 * 
	 * @param arr
	 * @param d
	 * @return
	 */
	public static int[] leftRotate(int[] arr, int d) {
		int n = arr.length;
		int[] rotatedArray = new int[n];

		// Perform d left rotations
		for (int i = 0; i < n; i++) {
			int newIndex = (i + (n - d)) % n;
			rotatedArray[newIndex] = arr[i];
		}

		return rotatedArray;
	}

	public static void main(String[] args) {
//		int[] arr = { 1, 2, 3, 4, 5 };
//		int d = 2;

//		int[] rotatedArray = leftRotate(arr, d);
		int d = 4;

		System.out.println("Array after " + d + " left rotations:");
//		for (int num : rotatedArray) {
//			System.out.print(num + " ");
//		}
		
		List<Integer> newList = Arrays.asList(1, 2, 3, 4, 5);
		
		System.out.println(leftRotate(newList, d));
	}
	
	 public static List<Integer> leftRotate(List<Integer> list, int d) {
	        int n = list.size();
	        List<Integer> rotatedList = new ArrayList<>(n);

	        // Perform d left rotations
	        for (int i = 0; i < n; i++) {
	            int newIndex = (i + (n - d)) % n;
	            rotatedList.add(list.get(newIndex));
	        }

	        return rotatedList;
	    }
}
