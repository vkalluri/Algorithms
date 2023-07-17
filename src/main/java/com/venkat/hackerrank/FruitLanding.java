package com.venkat.hackerrank;

import java.util.List;

public class FruitLanding {
    public static void countFruits(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleCount = 0;
        int orangeCount = 0;

        for (int apple : apples) {
            int position = a + apple;
            if (position >= s && position <= t) {
                appleCount++;
            }
        }

        for (int orange : oranges) {
            int position = b + orange;
            if (position >= s && position <= t) {
                orangeCount++;
            }
        }

        System.out.println("Apples: " + appleCount);
        System.out.println("Oranges: " + orangeCount);
    }

    public static void countFruits(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int appleCount = 0;
        int orangeCount = 0;

        for (int apple : apples) {
            int position = a + apple;
            if (position >= s && position <= t) {
                appleCount++;
            }
        }

        for (int orange : oranges) {
            int position = b + orange;
            if (position >= s && position <= t) {
                orangeCount++;
            }
        }

        System.out.println("Apples: " + appleCount);
        System.out.println("Oranges: " + orangeCount);
    }

    public static void main(String[] args) {
        int s = 7; // House start point
        int t = 11; // House endpoint
        int a = 5; // Apple tree position
        int b = 15; // Orange tree position
        int[] apples = {-2, 2, 1}; // Positions where apples fall relative to the apple tree
        int[] oranges = {5, -6}; // Positions where oranges fall relative to the orange tree

        countFruits(s, t, a, b, apples, oranges);

//        List<Integer> appleList = Arrays.asList(apples);

//        countFruits(s, t, a, b, Arrays.asList(apples), oranges);
    }
}
