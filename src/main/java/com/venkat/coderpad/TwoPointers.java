package com.venkat.coderpad;

public class TwoPointers {
	public static int isPairSum(int A[], int N, int X)
    {
        // represents first pointer
        int i = 0;
  
        // represents second pointer
        int j = N - 1;
  
        while (i < j) {
  
            // If we find a pair
            if (A[i] + A[j] == X)
                return 1;
  
            // If sum of elements at current
            // pointers is less, we move towards
            // higher values by doing i++
            else if (A[i] + A[j] < X)
                i++;
  
            // If sum of elements at current
            // pointers is more, we move towards
            // lower values by doing j--
            else
                j--;
        }
        return 0;
    }
    
    // Driver code
    public static void main(String[] args)
    {
        // array declaration
        int arr[] = { 2, 3, 5, 8, 9, 10, 11 };
          
        // value to search
        int val = 17;
        
        // size of the array
        int arrSize = arr.length;
        
        // Function call
        System.out.println(isPairSum(arr, arrSize, val));
    }
}
