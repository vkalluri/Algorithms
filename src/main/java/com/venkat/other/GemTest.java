package com.venkat.other;

import java.util.Scanner;

public class GemTest {
	
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the number of gems of each type: ");
	        int n1 = scanner.nextInt();
	        int n2 = scanner.nextInt();
	        int n3 = scanner.nextInt();
	        int n4 = scanner.nextInt();

	        String[] gems = new String[n1 + n2 + n3 + n4];

	        for (int i = 0; i < n1; i++) {
	            gems[i] = "G1";
	        }

	        for (int i = n1; i < n1 + n2; i++) {
	            gems[i] = "G2";
	        }

	        for (int i = n1 + n2; i < n1 + n2 + n3; i++) {
	            gems[i] = "G3";
	        }

	        for (int i = n1 + n2 + n3; i < n1 + n2 + n3 + n4; i++) {
	            gems[i] = "G4";
	        }

	        int i = 0;
	        while (i < gems.length - 1) {
	            if (gems[i].equals(gems[i + 1])) {
	                int j = i + 1;
	                while (j < gems.length - 1 && gems[j].equals(gems[i])) {
	                    j++;
	                }

	                String temp = gems[i];
	                gems[i] = gems[j];
	                gems[j] = temp;
	            }

	            i++;
	        }

	        System.out.println("The arranged gems are: ");
	        for (String gem : gems) {
	            System.out.print(gem + " ");
	        }
	        scanner.close();
	    }
	 
	 
	 

}
