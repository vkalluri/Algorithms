package com.venkat.coderpad;

public class Palindrome {
	
	public static boolean isPalindromeUsingStringBuilder(String text) {
	    String clean = text.replaceAll("\\s+", "").toLowerCase();
	    StringBuilder plain = new StringBuilder(clean);
	    StringBuilder reverse = plain.reverse();
	    return (reverse.toString()).equals(clean);
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindromeUsingStringBuilder("madam"));
		System.out.println(isPalindromeUsingStringBuilder("test"));
		
	
	}

}
