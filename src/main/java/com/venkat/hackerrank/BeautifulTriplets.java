package com.venkat.hackerrank;


import java.util.List;

/**
 * Given a sequence of integers a, a triplet (a[i], a[j], a[k])  is beautiful if:
 * i < j < k
 * a[j] - a[i] = a[k] - a[j] = d
 *
 * Given an increasing sequenc of integers and the value of , count the number of beautiful triplets in the sequence.
 *
 * Example
 * arr = [2,2,3,4,5]
 * d = 1
 *
 *
 * There are three beautiful triplets, by index: [i,j,k] = [0,2,3],[1,2,3],[2,3,4]. To test the first triplet, arr[j] - arr[i] = 3 - 2 and arr[k] - arr[j] = 4 - 3 = 1.
 *
 * Function Description
 *
 * Complete the beautifulTriplets function in the editor below.
 *
 * beautifulTriplets has the following parameters:
 *
 * int d: the value to match
 * int arr[n]: the sequence, sorted ascending
 * Returns
 *
 * int: the number of beautiful triplets
 * Input Format
 *
 * The first line contains 2 space-separated integers, n and d, the length of the sequence and the beautiful difference.
 * The second line contains n space-separated integers arr[i].
 *
 * Constraints
 * 1 <= n <= 10^4
 * 1 <= d = 20
 * 0 <= arr[i] <= 2 * 10^4
 * arr[i] >= arr[i - 1]
 */
public class BeautifulTriplets {

    /**
     * To count the number of beautiful triplets in a given sequence, we can use a nested loop to iterate
     * through all possible combinations of triplets and check if they satisfy the conditions.
     * @param d
     * @param arr
     * @return
     */
    static int beautifulTriplets(int d, int[] arr) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[j] - arr[i] == d) {
                    for (int k = j + 1; k < n; k++) {
                        if (arr[k] - arr[j] == d) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    static int beautifulTriplets(int d, List<Integer> arr) {
        int count = 0;
        int n = arr.size();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (arr.get(j) - arr.get(i) == d) {
                    for (int k = j + 1; k < n; k++) {
                        if (arr.get(k) - arr.get(j) == d) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int d = 1;
        int[] arr = {2, 2, 3, 4, 5};

        int count = beautifulTriplets(d, arr);
        System.out.println("Count: " + count);
    }
}
