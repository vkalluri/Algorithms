package com.venkat.coderpad;

public class Recursion {
	static void printFun(int test)
    {
        if (test < 1)
            return;
 
        else {
            System.out.printf("%d ", test);
 
            // Statement 2
            printFun(test - 1);
 
            System.out.printf("%d ", test);
            return;
        }
    }
	
	static int fact(int n){
		int result;
		   
		  if(n==1) return 1;
		  result =fact(n-1) *n;
		  return result;
		}
 
    public static void main(String[] args)
    {
        int test = 3;
        printFun(test);
        System.out.println("");
        System.out.println("Factorial of 3 is " + fact(3));
        System.out.println("Factorial of 4 is " + fact(4));
        System.out.println("Factorial of 5 is " + fact(5));
    }
}
