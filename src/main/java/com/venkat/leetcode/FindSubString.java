package com.venkat.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubString {
	public static List<Integer> findSubstring(String s, String[] words) {
	    List<Integer> result = new ArrayList<>();
	    
	    if (s == null || s.length() == 0 || words == null || words.length == 0)
	        return result;
	    
	    int wordLength = words[0].length();
	    int wordsCount = words.length;
	    int totalLength = wordLength * wordsCount;
	    
	    if (s.length() < totalLength)
	        return result;
	    
	    Map<String, Integer> wordCounts = new HashMap<>();
	    for (String word : words) {
	        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
	    }
	    
	    for (int i = 0; i <= s.length() - totalLength; i++) {
	        String substring = s.substring(i, i + totalLength);
	        Map<String, Integer> seen = new HashMap<>();
	        
	        int j = 0;
	        while (j < totalLength) {
	            String word = substring.substring(j, j + wordLength);
	            seen.put(word, seen.getOrDefault(word, 0) + 1);
	            
	            if (!wordCounts.containsKey(word) || seen.get(word) > wordCounts.get(word))
	                break;
	            
	            j += wordLength;
	        }
	        
	        if (j == totalLength)
	            result.add(i);
	    }
	    
	    return result;
	}
	
	public static void main(String[] args) {
		String[] a = {"foo","bar"};
		System.out.println(findSubstring("barfoothefoobarman", a));
	}
}
