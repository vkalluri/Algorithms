package com.venkat.other;

import java.util.Scanner;

public class PrintPyramidTest {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int rows = sc.nextInt();
        System.out.println("Pyramid pattern of star in Java : ");
        drawPyramidPattern(rows);
        
        System.out.println("Pyramid of numbers in Java : ");
        drawPyramidOfNumbers(rows);
        sc.close();
    }

    /**
     * This method draws a pyramid pattern using asterisk character. You can
     * replace the asterisk with any other character to draw a pyramid of that.
     */
    public static void drawPyramidPattern(int totalRows) {
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    
    /**
     * This method draws a pyramid of numbers. 
     */
    public static void drawPyramidOfNumbers(int totalRows) {
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

}
