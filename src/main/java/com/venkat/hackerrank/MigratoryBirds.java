package com.venkat.hackerrank;


import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type. If more than 1 type has been spotted that maximum amount, return the smallest of their ids.
 *
 * Example
 * arr = [1,1,2,2,3]
 *
 * There are two each of types 1 and 2, and one sighting of type 3. Pick the lower of the two types seen twice: type 1.
 *
 * Function Description
 * Complete the migratoryBirds function in the editor below.
 *
 * migratoryBirds has the following parameter(s):
 *
 * int arr[n]: the types of birds sighted
 *
 * Returns
 * int: the lowest type id of the most frequently sighted birds
 *
 * Input Format
 * The first line contains an integer, n, the size of arr.
 * The second line describes arr as n space-separated integers, each a type number of the bird sighted.
 *
 * Constraints
 * 5 <= n <= 2 * 10^5
 * It is guaranteed that each type is 1, 2, 3, 4, or 6.
 *
 * Sample Input 0
 * 6
 * 1 4 4 4 5 3
 *
 * Sample Output 0
 * 4
 * Explanation 0
 *
 * The different types of birds occur in the following frequencies:
 *
 * Type 1: 1 bird
 * Type 2: 0 birds
 * Type 3: 1 bird
 * Type 4: 3 birds
 * Type 5: 1 bird
 * The type number that occurs at the highest frequency is type 4, so we print 4 as our answer.
 */
public class MigratoryBirds {


    /**
     * This implementation uses a HashMap to count the frequency of each bird type in the given array.
     * Then, it iterates through the frequencyMap to find the most frequent bird type(s).
     * If there are multiple bird types with the maximum frequency, it selects the one with the smallest id.
     * Finally, it returns the lowest type id of the most frequently sighted birds.
     *
     * You can use this function by creating an instance of the Solution class and calling migratoryBirds(arr)
     * on that instance, where arr is the array of bird sightings. It will return the lowest type id of the most frequently sighted birds.
     */
    public static int migratoryBirds(int[] arr) {

        // Count the frequency of each bird type
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int bird : arr) {
            frequencyMap.put(bird, frequencyMap.getOrDefault(bird, 0) + 1);
        }

        // Find the most frequent bird type(s)
        int maxFrequency = 0;
        int minBirdType = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int birdType = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency || (frequency == maxFrequency && birdType < minBirdType)) {
                maxFrequency = frequency;
                minBirdType = birdType;
            }
        }
        

        return minBirdType;
    }

    public static void main(String[] args){
        int[] birds = {1,4,4,4,5,3};
        System.out.println(migratoryBirds(birds));
    }
}
