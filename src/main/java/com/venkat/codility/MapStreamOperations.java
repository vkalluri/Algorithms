package com.venkat.codility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class MapStreamOperations {
	
	public void mapStreamOperations() {
		Map<String, Integer> map = new HashMap<>();
		// Add key-value pairs to the map

		map.entrySet().stream().forEach(entry -> {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    // Process key-value pair
		});

		Map<String, Integer> map1 = new HashMap<>();
		// Add key-value pairs to the map

		map1.entrySet().stream()
		    .filter(entry -> entry.getValue() > 50)
		    .forEach(entry -> {
		        String key = entry.getKey();
		        Integer value = entry.getValue();
		        // Process filtered key-value pair
		    });
		Map<String, Integer> map2 = new HashMap<>();
		// Add key-value pairs to the map

		List<String> transformedValues = map2.entrySet().stream()
		    .map(entry -> entry.getValue().toString())
		    .collect(Collectors.toList());

		Map<String, Integer> map3 = new HashMap<>();
		// Add key-value pairs to the map

		Map<String, Integer> filteredMap = map3.entrySet().stream()
		    .filter(entry -> entry.getValue() > 50)
		    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		Map<String, Integer> map4 = new HashMap<>();
		// Add key-value pairs to the map

		int sum = map4.values().stream().mapToInt(Integer::intValue).sum();
		OptionalInt max = map.values().stream().mapToInt(Integer::intValue).max();
		OptionalInt min = map.values().stream().mapToInt(Integer::intValue).min();


	}

}
