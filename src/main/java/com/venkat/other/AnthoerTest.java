package com.venkat.other;

import java.util.regex.Pattern;

public class AnthoerTest {
	
	static int  findNthTerm(int n)
	{
	    // If input number is even
		int returnValue = 0;
		//
//	    if (n % 2 == 0)
//	    {
//	        n = n / 2;
//	        returnValue = (int) Math.pow(3, n - 1);
//	    }
//	    // If input number is odd
//	    else
//	    {
//	        n = (n / 2) + 1;
//	        returnValue = (int) Math.pow(2, n - 1);
//	    }
		
		//f(n+1)=f(N+1-f(f(N))) 
		
		returnValue = fib(100);
	    return returnValue;
	}
	
	 static int fib(int n)
	    {
	        if (n <= 1)
	            return n;
	        return fib(n - 1) - fib(n - 2);
	    }
	 
	
	public static int fibonacci(int n)  {
	    if(n == 0)
	        return 0;
	    else if(n == 1)
	      return 1;
	   else
	      return fibonacci(n + 1) - fibonacci(n);
	}
	
	public static void main(String[] args) {
		System.out.println("found "+findNthTerm(100));
	}
	
	static String generateNumbers(int n) {
		final Pattern seq = Pattern.compile("(.)\\1*");
		if(n<=0 || n>=10) {
			return "Invalid Number";
		}else if(n==2) {
			return "11,12,13,14,15,16,17,18,19,23,24,25,26,27,28,29,34,35,36,37,38,39,45,46,47,48,49,56,57,58,59,67,68,69,78,79,89";
		}else if(n==1) {
			return "1,2,3,4,5,6,7,8,8,11,12,13,14,15,16,17,18,19,23,24,25,26,27,28,29,34,35,36,37,38,39,45,46,47,48,49,56,57,58,59,67,68,69,78,79,89";
		}
		return null;
	}

}
