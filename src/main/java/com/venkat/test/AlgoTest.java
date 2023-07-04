package com.venkat.test;

public class AlgoTest {
	public static void main(String[] args) {
		returnValue();
	}
	
	public static int returnValue() {
		try {
			return 1;
		}catch(Exception ex) {
			return 0;
		}finally {
			System.out.println("calling finally");
		}
	}
}

