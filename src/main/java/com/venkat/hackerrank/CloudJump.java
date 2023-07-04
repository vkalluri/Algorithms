package com.venkat.hackerrank;

import java.util.List;

public class CloudJump {

	/**
	 * In this code, the minJumps method takes an integer array clouds as input,
	 * representing the clouds in the game. It starts from the first cloud (position
	 * 0) and uses a while loop to iterate until it reaches the last cloud.
	 * 
	 * Within each iteration, it checks if a double jump is possible by looking at
	 * the cloud two steps ahead. If a double jump is possible and the cloud is a
	 * cumulus cloud (represented by 0), the position is updated by jumping two
	 * steps. Otherwise, a single jump is performed by moving one step.
	 * 
	 * The jumps variable keeps track of the number of jumps performed. Finally, the
	 * method returns the total number of jumps required to reach the last cloud.
	 * 
	 * In the main method, we provide an example array clouds representing the
	 * sequence of clouds in the game. The minJumps method is called to find the
	 * minimum number of jumps, and the result is printed
	 * 
	 * @param clouds
	 * @return
	 */
	public static int minJumps(int[] clouds) {

		int position = 0;
		int jumps = 0;

		while (position < clouds.length - 1) {
			// Check if a double jump is possible
			if (position + 2 < clouds.length && clouds[position + 2] == 0) {
				position += 2;
			}
			// If double jump is not possible, perform a single jump
			else {
				position += 1;
			}

			jumps++;
		}

		return jumps;
	}

	public static void main(String[] args) {
		int[] clouds = { 0, 0, 1, 0, 0, 1, 0 };

		int minJumps = minJumps(clouds);
		System.out.println("Minimum number of jumps: " + minJumps);
	}
	
	public static int jumpingOnClouds(List<Integer> c) {
	    // Write your code here
	    int position = 0, jumps = 0;

	    while(position < c.size()-1){
	        if(position + 2 < c.size() &&  c.get(position + 2) == 0){
	            position += 2;
	        }else{
	            position+= 1;
	        }
	        jumps++;
	    } 
	    return jumps;
	       

	    }
}
