package com.venkat.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryGap {
	public static int solution(int N) {
        String value = Integer.toBinaryString(N);
        int counter = 0;
        List<Integer> counters = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            char current = value.charAt(i);
            if (current == '0') {
                counter += 1;
            } else {
                counters.add(counter);
                counter = 0;
            }
        }
        return Collections.max(counters);
    }

	public static void main(String[] args) {
		System.out.println(solution(1041));
		System.out.println(solution(15));
		System.out.println(solution(32));
	}
}
