package com.venkat.hackerrank;

public class UtopianTree {
    public static int calculateTreeHeight(int cycles) {
        int height = 1;

        for (int i = 1; i <= cycles; i++) {
            if (i % 2 == 1) {
                // Spring cycle: double the height
                height *= 2;
            } else {
                // Summer cycle: increase height by 1
                height += 1;
            }
        }

        return height;
    }

    public static void main(String[] args) {
        int cycles = 4;

        int treeHeight = calculateTreeHeight(cycles);
        System.out.println("Height of the Utopian Tree after " + cycles + " cycles: " + treeHeight);
    }
}
