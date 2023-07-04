package com.venkat.codility;

import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {
	public int[] solution(String S, int[] P, int[] Q) {
		int[] impactFactors = new int[S.length()];
		int[] result = new int[P.length];

		// Calculate the impact factors for each nucleotide in the DNA sequence
		for (int i = 0; i < S.length(); i++) {
			char nucleotide = S.charAt(i);
			switch (nucleotide) {
			case 'A':
				impactFactors[i] = 1;
				break;
			case 'C':
				impactFactors[i] = 2;
				break;
			case 'G':
				impactFactors[i] = 3;
				break;
			case 'T':
				impactFactors[i] = 4;
				break;
			}
			
			Map<String, String> myMap = new HashMap<String, String>();
		}

		// Process each query range
		for (int i = 0; i < P.length; i++) {
			int start = P[i];
			int end = Q[i];

			// Find the minimal impact factor within the query range
			for (int j = start; j <= end; j++) {
				if (impactFactors[j] < result[i] || result[i] == 0) {
					result[i] = impactFactors[j];
				}

				// Early exit if we find the minimum possible impact factor
				if (result[i] == 1) {
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		GenomicRangeQuery query = new GenomicRangeQuery();
		String S = "CAGCCTA";
		int[] P = { 2, 5, 0 };
		int[] Q = { 4, 5, 6 };
		int[] result = query.solution(S, P, Q);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
