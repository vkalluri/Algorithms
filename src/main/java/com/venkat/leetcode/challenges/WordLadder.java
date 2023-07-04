package com.venkat.leetcode.challenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * A transformation sequence from word beginWord to word endWord using a
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
 * such that:
 * 
 * Every adjacent pair of words differs by a single letter. Every si for 1 <= i
 * <= k is in wordList. Note that beginWord does not need to be in wordList. sk
 * == endWord Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest transformation sequence from
 * beginWord to endWord, or 0 if no such sequence exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"] Output: 5 Explanation: One shortest
 * transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is
 * 5 words long. Example 2:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log"] Output: 0 Explanation: The endWord "cog" is
 * not in wordList, therefore there is no valid transformation sequence.
 * 
 * 
 * Constraints:
 * 
 * 1 <= beginWord.length <= 10 endWord.length == beginWord.length 1 <=
 * wordList.length <= 5000 wordList[i].length == beginWord.length beginWord,
 * endWord, and wordList[i] consist of lowercase English letters. beginWord !=
 * endWord All the words in wordList are unique.
 * 
 * @author vkall
 *
 */
public class WordLadder {
	/**
	 * The Word Ladder problem, also known as the Word Transformation problem, can
	 * be solved using a breadth-first search (BFS) algorithm. Here's an example of
	 * how you can implement it in Java:
	 * 
	 * In this code, the ladderLength method takes the starting word (beginWord),
	 * the target word (endWord), and a list of words (wordList) as input. It
	 * returns the minimum number of transformations needed to reach the target word
	 * from the starting word. If no transformation sequence is possible, it returns
	 * 0.
	 * 
	 * The method first creates a HashSet called dict from the wordList to
	 * efficiently check if a word is in the list or not. If the endWord is not in
	 * the wordList, it immediately returns 0.
	 * 
	 * A queue (LinkedList) is used to perform BFS. The starting word is added to
	 * the queue, and its occurrence is removed from the dict. A level variable
	 * keeps track of the current transformation level.
	 * 
	 * The BFS algorithm continues until the queue is empty. At each level, the
	 * words in the queue are processed. For each word, each character is replaced
	 * with every possible lowercase letter from 'a' to 'z'. If the resulting word
	 * is in the dict, it is added to the queue, and its occurrence is removed from
	 * the dict. The original character is then restored to proceed to the next
	 * character.
	 * 
	 * If the endWord is found during the BFS, the current level is returned as the
	 * minimum ladder length. If no transformation sequence exists, the method
	 * returns 0.
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		if (!dict.contains(endWord)) {
			return 0; // End word not in the word list
		}

		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		dict.remove(beginWord);
		int level = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				String currentWord = queue.poll();

				if (currentWord.equals(endWord)) {
					return level; // Found the end word
				}

				char[] wordChars = currentWord.toCharArray();

				for (int j = 0; j < wordChars.length; j++) {
					char originalChar = wordChars[j];

					for (char c = 'a'; c <= 'z'; c++) {
						if (wordChars[j] == c) {
							continue; // Skip the same character
						}

						wordChars[j] = c;
						String newWord = String.valueOf(wordChars);

						if (dict.contains(newWord)) {
							queue.offer(newWord);
							dict.remove(newWord);
						}
					}

					wordChars[j] = originalChar; // Restore the original character
				}
			}

			level++;
		}

		return 0; // No transformation sequence exists
	}

	public static void main(String[] args) {
		WordLadder wordLadder = new WordLadder();

		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

		int ladderLength = wordLadder.ladderLength(beginWord, endWord, wordList);
		System.out.println("Minimum ladder length: " + ladderLength);
	}
}
