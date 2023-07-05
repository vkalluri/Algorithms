package com.venkat.test;

import java.util.HashMap;

public class WordCount {

	public static void main(String[] args) {
		String str = "Hello World, Welcome to Simplilearn World world";

		String[] split = str.split(" ");

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < split.length; i++) {

//			if (map.containsKey(split[i])) {
//
//				int count = map.get(split[i]);
//
//				map.put(split[i], count + 1);
//
//			} else {
//
//				map.put(split[i], 1);
//
//			}
//			{world=1, Hello=1, Simplilearn=1, Welcome=1, to=1, World=1, World,=1}
			map.put(split[i], map.getOrDefault(split[i], 0) +1);

		}

		System.out.println(map);	
	}

}
