package com.venkat.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.add(t);

        // Remove outdated requests
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.remove();
        }

        return requests.size();
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(100));   // Output: 1
        System.out.println(counter.ping(300));   // Output: 2
        System.out.println(counter.ping(600));   // Output: 3
        System.out.println(counter.ping(1000));  // Output: 4
        System.out.println(counter.ping(1200));  // Output: 3
    }
}
