package com.venkat.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradingPolicy {
    public static List<Integer> roundGrades(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();

        for (int grade : grades) {
            if (grade < 38) {
                roundedGrades.add(grade);
            } else {
                int nextMultipleOf5 = ((grade / 5) + 1) * 5;
                int difference = nextMultipleOf5 - grade;

                if (difference < 3) {
                    roundedGrades.add(nextMultipleOf5);
                } else {
                    roundedGrades.add(grade);
                }
            }
        }

        return roundedGrades;
    }

    public static void main(String[] args) {
        List<Integer> grades = Arrays.asList(73, 67, 38, 33);

        List<Integer> roundedGrades = roundGrades(grades);
        System.out.println("Original Grades: " + grades);
        System.out.println("Rounded Grades: " + roundedGrades);
    }
}
