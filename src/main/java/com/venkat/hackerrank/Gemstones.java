package com.venkat.hackerrank;

import java.util.Arrays;
import java.util.List;

public class Gemstones {
    public static int countGemstones(List<String> rocks) {
        int[] mineralCount = new int[26]; // Assuming only lowercase letters from 'a' to 'z'

        // Iterate through each rock
        for (String rock : rocks) {
            boolean[] present = new boolean[26]; // Track the occurrence of minerals in the current rock
            for (char mineral : rock.toCharArray()) {
                present[mineral - 'a'] = true;
            }

            // Update the mineral count
            for (int i = 0; i < 26; i++) {
                if (present[i]) {
                    mineralCount[i]++;
                }
            }
        }

        // Count the gemstones
        int gemstoneCount = 0;
        for (int count : mineralCount) {
            if (count == rocks.size()) {
                gemstoneCount++;
            }
        }

        return gemstoneCount;
    }

    public static void main(String[] args) {
        List<String> rocks = Arrays.asList("abc", "def", "ghi", "ajk");

        int gemstoneCount = countGemstones(rocks);
        System.out.println("Number of gemstones: " + gemstoneCount);
    }
}
