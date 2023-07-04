package com.venkat.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SockPairCounter {

	/**
	 * In this updated code, we have added the parameter n representing the number of socks in the pile.
	 *  We no longer rely on the length of the input array to determine the count of socks.

The logic remains the same. We iterate through the socks array and increment the count of each sock color in the countMap. 
Then, we iterate through the values of countMap and calculate the number of pairs by dividing each count by 2 and adding it to the pairCount variable.

In the main method, we provide an example value for n (8) and the array of sock colors socks. 
The countPairs method is called to find the number of pairs, and the result is printed.

This means there are three pairs of socks in the given pile.

Feel free to modify the value of n and the socks array in the main method to test the code with different scenarios.

I hope this clarifies the solution. Let me know if you have any further questions.
	 * @param n
	 * @param socks
	 * @return
	 */
	public static int countPairs(int n, int[] socks) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int pairCount = 0;

        for (int sock : socks) {
            countMap.put(sock, countMap.getOrDefault(sock, 0) + 1);
        }

        for (int count : countMap.values()) {
            pairCount += count / 2;
        }

        return pairCount;
    }

    public static void main(String[] args) {
        int n = 8;
        int[] socks = {1, 2, 1, 2, 3, 1, 2, 2};
        int pairCount = countPairs(n, socks);

        System.out.println("Number of pairs: " + pairCount);
    }
}
