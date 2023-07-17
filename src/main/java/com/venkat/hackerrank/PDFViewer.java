package com.venkat.hackerrank;

import java.util.List;

public class PDFViewer {

    public static int designerPdfViewer(List<Integer> h, String word){
        int maxHeight = 0;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            int height = h.get(index);
            if (height > maxHeight) {
                maxHeight = height;
            }
        }

        int area = word.length() * maxHeight;

        return area;
    }

    public static int calculateHighlightArea(int[] heights, String word) {
        int maxHeight = 0;

        // Find the maximum height among the characters in the word
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            int height = heights[index];
            if (height > maxHeight) {
                maxHeight = height;
            }
        }

        // Calculate the area of the rectangle highlight
        int area = word.length() * maxHeight;

        return area;
    }

    public static void main(String[] args) {
        int[] heights = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};
        String word = "abc";

//        List<Integer> arr = Arrays.asList(heights);

        int highlightArea = calculateHighlightArea(heights, word);
        System.out.println("Area of rectangle highlight: " + highlightArea);
    }
}
