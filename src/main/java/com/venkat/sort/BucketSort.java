package com.venkat.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Bucket Sort is a distribution-based sorting algorithm that divides
 * the input into a fixed number of equally-sized buckets. Elements are
 * distributed into the buckets based on their values, and each bucket
 * is sorted individually, either using another sorting algorithm or
 * recursively applying bucket sort.
 */
public class BucketSort {
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        ArrayList<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.25f, 0.12f, 0.38f, 0.52f, 0.17f, 0.62f};
        bucketSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
