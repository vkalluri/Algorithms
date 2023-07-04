package com.venkat.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListStreams {

	public static void main(String[] args) {

		List<String> myList =
		        Arrays.asList("area", "block", "building", "city", "country");
		 
		myList.stream()
		        .filter(s -> s.startsWith("c"))
		        .map(String::toUpperCase)
		        .sorted()
		        .forEach(System.out::println);
		
		Map<Integer, String> myMap = new HashMap<>();
		myMap.put(1, "One");
		myMap.put(2, "Two");
		myMap.put(3, "Three");
		myMap.put(4, "Four");
		myMap.put(5, "Five");
		
//		myMap.entrySet().stream()
	}

}
