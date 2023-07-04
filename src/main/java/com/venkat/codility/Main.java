package com.venkat.codility;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class Main {
	
	public static void main(String[] args) {
        String input1 = "aaa";
        String input2 = "bbaaaabb";
        String input3 = "abb";

        System.out.println(checkOrder(input1)); // true
        System.out.println(checkOrder(input2)); // false
        System.out.println(checkOrder(input3)); // true
        
        System.out.println(DateTimeFormatter.ISO_INSTANT.format(Instant.now()));
    }

    public static boolean checkOrder(String input) {
        boolean bFound = false;

        for (char c : input.toCharArray()) {
            if (c == 'a') {
                if (bFound) {
                    return false; // 'a' found after 'b', return false
                }
            } else if (c == 'b') {
                bFound = true;
            } else {
                return false; // invalid character, return false
            }
        }

        return true;
    }

}
