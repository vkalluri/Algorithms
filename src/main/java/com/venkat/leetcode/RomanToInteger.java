package com.venkat.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public int romanToInt(String s) {
		Map<Character, Integer> romanMap = createRomanMap();

		int result = 0;
		int prevValue = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			int currValue = romanMap.get(s.charAt(i));

			if (currValue < prevValue) {
				result -= currValue;
			} else {
				result += currValue;
			}

			prevValue = currValue;
		}

		return result;
	}

	private Map<Character, Integer> createRomanMap() {
		Map<Character, Integer> romanMap = new HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);

		return romanMap;
	}
	
	public static void main(String[] args) {
		
	}
}
