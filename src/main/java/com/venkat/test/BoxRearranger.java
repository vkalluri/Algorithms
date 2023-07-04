package com.venkat.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxRearranger {
	public static boolean canFormEqualStacks(int[] boxes) {
		int totalHeight = Arrays.stream(boxes).sum();
		if (totalHeight % 3 != 0) {
			return false; // The total height is not divisible by 3, cannot form equal stacks
		}

		int targetHeight = totalHeight / 3;
		List<Integer> stackHeights = new ArrayList<Integer>();
		return rearrangeBoxes(boxes, 0, 0, targetHeight, targetHeight, targetHeight, stackHeights);
	}

	private static boolean rearrangeBoxes(int[] boxes, int index, int stack1Height, int stack2Height, int stack3Height,
			int targetHeight, List<Integer> stackHeights) {
		if (index == boxes.length) {
			// All boxes have been processed
			return stack1Height == targetHeight && stack2Height == targetHeight && stack3Height == targetHeight;
		}

		// Try putting the box in each stack
		boolean putInStack1 = false;
		if (stack1Height + boxes[index] <= targetHeight) {
			putInStack1 = rearrangeBoxes(boxes, index + 1, stack1Height + boxes[index], stack2Height, stack3Height,
					targetHeight, stackHeights);
		}

		boolean putInStack2 = false;
		if (!putInStack1 && stack2Height + boxes[index] <= targetHeight) {
			putInStack2 = rearrangeBoxes(boxes, index + 1, stack1Height, stack2Height + boxes[index], stack3Height,
					targetHeight, stackHeights);
		}

		boolean putInStack3 = false;
		if (!putInStack1 && !putInStack2 && stack3Height + boxes[index] <= targetHeight) {
			putInStack3 = rearrangeBoxes(boxes, index + 1, stack1Height, stack2Height, stack3Height + boxes[index],
					targetHeight, stackHeights);
		}

		return putInStack1 || putInStack2 || putInStack3;
	}

	public static void main(String[] args) {
//		int[] boxes = { 3, 2, 4, 1, 2, 1 };
//		boolean canFormEqualStacks = canFormEqualStacks(boxes);
//		System.out.println("Can form equal stacks: " + canFormEqualStacks);
		
		int clawPos = 2;
        int[] boxes = {4, 2, 6, 3};
        boolean boxInClaw = true;
        
        String result = solve(clawPos, boxes, boxInClaw);
        System.out.println("Can form equal stacks? " + result);
	}
	
	 public static String solve1(int clawPos, int[] boxes, boolean boxInClaw) {
	        // Calculate the total height of the boxes
	        int totalHeight = 0;
	        for (int height : boxes) {
	            totalHeight += height;
	        }
	        
	        // Check if the total height is divisible by the number of boxes
	        if (totalHeight % boxes.length != 0) {
	            return "NO"; // Cannot form equal stacks
	        }
	        
	        // Calculate the target height for each stack
	        int targetHeight = totalHeight / boxes.length;
	        
	        // Initialize the stack heights
	        int[] stackHeights = new int[boxes.length];
	        
	        // Set the initial claw position
	        int currentPos = clawPos;
	        
	        // If the box is in the claw, add its height to the current stack
	        if (boxInClaw) {
	            stackHeights[currentPos] += boxes[currentPos];
	        }
	        
	        // Iterate through the boxes
	        for (int i = 0; i < boxes.length; i++) {
	            // Move the claw to the next position
	            currentPos = (currentPos + 1) % boxes.length;
	            
	            // Add the box height to the current stack
	            stackHeights[currentPos] += boxes[i];
	            
	            // If the current stack height exceeds the target height, return "NO"
	            if (stackHeights[currentPos] > targetHeight) {
	                return "NO";
	            }
	        }
	        
	        return "YES";
	    }
	 
	 public static String solve(int clawPos, int[] boxes, boolean boxInClaw) {
	        // Calculate the total height of the boxes
	        int totalHeight = 0;
	        for (int height : boxes) {
	            totalHeight += height;
	        }

	        // Check if the total height is divisible by the number of boxes
	        if (totalHeight % boxes.length != 0) {
	            return "NO"; // Cannot form equal stacks
	        }

	        // Calculate the target height for each stack
	        int targetHeight = totalHeight / boxes.length;

	        // Initialize the stack heights
	        int[] stackHeights = new int[boxes.length];

	        // Set the initial claw position
	        int currentPos = clawPos;

	        // If the box is in the claw, add its height to the current stack
	        if (boxInClaw) {
	            stackHeights[currentPos] += boxes[currentPos];
	        }

	        StringBuilder moves = new StringBuilder();
	        
	        // Iterate through the boxes
	        for (int i = 0; i < boxes.length; i++) {
	            // Move the claw to the next position
	            int nextPos = (currentPos + 1) % boxes.length;

	            // Pick or place the box
	            if (stackHeights[currentPos] < targetHeight && stackHeights[nextPos] > 0) {
	                stackHeights[currentPos] += boxes[i];
	                stackHeights[nextPos] -= boxes[i];
	                moves.append("pick ");
	            } else if (stackHeights[currentPos] > 0 && stackHeights[nextPos] < targetHeight) {
	                stackHeights[currentPos] -= boxes[i];
	                stackHeights[nextPos] += boxes[i];
	                moves.append("place ");
	            }

	            // Move the claw
	            if (nextPos < currentPos) {
	                moves.append("left ");
	            } else if (nextPos > currentPos) {
	                moves.append("right ");
	            }
	            currentPos = nextPos;
	        }

	        return moves.toString().trim();
	    }
}
