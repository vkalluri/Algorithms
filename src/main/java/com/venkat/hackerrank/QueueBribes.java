package com.venkat.hackerrank;

/**
 * 
 * Example
 * 
 * 
 * If person bribes person , the queue will look like this: . Only bribe is
 * required. Print 1.
 * 
 * 
 * Person had to bribe people to get to the current position. Print Too chaotic.
 * 
 * Function Description
 * 
 * Complete the function minimumBribes in the editor below.
 * 
 * minimumBribes has the following parameter(s):
 * 
 * int q[n]: the positions of the people after all bribes Returns
 * 
 * No value is returned. Print the minimum number of bribes necessary or Too
 * chaotic if someone has bribed more than people. Input Format
 * 
 * The first line contains an integer , the number of test cases.
 * 
 * Each of the next pairs of lines are as follows: - The first line contains an
 * integer , the number of people in the queue - The second line has
 * space-separated integers describing the final state of the queue.
 * 
 * Constraints
 * 
 * Subtasks
 * 
 * For score For score
 * 
 * @author vkall
 *
 */
public class QueueBribes {

	/*
	 * In this code, the minimumBribes method takes an integer array queue as input
	 * and calculates the minimum number of bribes that took place to reach the
	 * given queue order.
	 * 
	 * The method iterates over each person in the queue in reverse order. For each
	 * person, it calculates the expected position based on their sticker value.
	 * 
	 * If the expected position minus the current position is greater than 2, it
	 * means the person has bribed more than two others, so "Too chaotic" is printed
	 * and the method returns.
	 * 
	 * Otherwise, it counts the number of bribes the person has received by
	 * iterating from the maximum of 0 and the person's sticker value minus 2, up to
	 * the current position. If a person in this range has a higher sticker value
	 * than the current person, it means they received a bribe, and the bribes
	 * counter is incremented.
	 * 
	 * Finally, the method prints the number of bribes.
	 * 
	 * In the main method, we provide an example queue order queue as input. The
	 * minimumBribes method is called to calculate the minimum number of bribes and
	 * print the result.
	 */
	public static void minimumBribes(int[] queue) {
		int bribes = 0;

		// Iterate over each person in the queue
		for (int i = queue.length - 1; i >= 0; i--) {
			int person = queue[i];
			int expectedPosition = person - 1;

			// Check if the person has moved more than two positions forward
			if (expectedPosition - i > 2) {
				System.out.println("Too chaotic");
				return;
			}

			// Count the number of bribes the person has received
			for (int j = Math.max(0, person - 2); j < i; j++) {
				if (queue[j] > person) {
					bribes++;
				}
			}
		}

		System.out.println(bribes);
	}

	public static void main(String[] args) {
		int[] queue = { 2, 1, 5, 3, 4 };
		minimumBribes(queue);
	}

}
