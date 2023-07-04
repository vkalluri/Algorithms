package com.venkat.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamTest {
	
	public static void main(String[] args) {
		Map<String, List<String>> people = new HashMap<>();
		people.put("John", Arrays.asList("555-1123", "555-3389"));
		people.put("Mary", Arrays.asList("555-2243", "555-5264"));
		people.put("Steve", Arrays.asList("555-6654", "555-3242"));
		
		String[] languages = {"Java", "Python", "JavaScript"};
		Stream numbers = Stream.of(languages);
	}

}
