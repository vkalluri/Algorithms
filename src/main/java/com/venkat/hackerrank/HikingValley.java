package com.venkat.hackerrank;

/**
 * An avid hiker keeps meticulous records of their hikes. During the last hike
 * that took exactly steps, for every step it was noted if it was an uphill, ,
 * or a downhill, step. Hikes always start and end at sea level, and each step
 * up or down represents a unit change in altitude. We define the following
 * terms:
 * 
 * A mountain is a sequence of consecutive steps above sea level, starting with
 * a step up from sea level and ending with a step down to sea level. A valley
 * is a sequence of consecutive steps below sea level, starting with a step down
 * from sea level and ending with a step up to sea level. Given the sequence of
 * up and down steps during a hike, find and print the number of valleys walked
 * through.
 * 
 * @author vkall
 *
 */
public class HikingValley {
	/**
	 * In this code, the countValleys method takes the number of steps (steps) and
	 * the sequence of uphill and downhill steps (path) as input. It iterates over
	 * each step in the path string and keeps track of the current altitude.
	 * 
	 * If the step is an uphill step ('U'), the altitude is incremented. If the
	 * altitude becomes 0, it means that the hiker has completed a valley, and the
	 * valleyCount is incremented.
	 * 
	 * If the step is a downhill step ('D'), the altitude is decremented.
	 * 
	 * The method returns the final valleyCount as the number of valleys walked
	 * through.
	 * 
	 * In the main method, we provide an example number of steps (steps) and the
	 * sequence of steps (path) as inputs. The countValleys method is called to find
	 * the number of valleys, and the result is printed.
	 * 
	 * @param steps
	 * @param path
	 * @return
	 */
	public static int countValleys(int steps, String path) {
		int altitude = 0;
		int valleyCount = 0;

		for (int i = 0; i < steps; i++) {
			char step = path.charAt(i);

			if (step == 'U') {
				altitude++;
				if (altitude == 0) {
					// Reached sea level, completed a valley
					valleyCount++;
				}
			} else if (step == 'D') {
				altitude--;
			}
		}

		return valleyCount;
	}

	public static void main(String[] args) {
		int steps = 12;
		String path = "DDUUDDUUUDUU";

		int valleyCount = countValleys(steps, path);
		System.out.println("Number of valleys walked through: " + valleyCount);
	}

}
