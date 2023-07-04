package com.venkat.codility;

public class Amptitude {
	static boolean check(int a[], int n) {
		int ma = a[1] - a[0];

		// Check for both sides adjacent
		// elements that both must be less
		// or both must be greater
		// than current element
		for (int i = 1; i < n - 1; i++) {
			if ((a[i] > a[i - 1] && a[i + 1] < a[i]) || (a[i] < a[i - 1] && a[i + 1] > a[i]))

				// Update amplitude with max value
				ma = Math.max(ma, Math.abs(a[i] - a[i + 1]));

			else
				return false;
		}

		// Print the Amplitude
		System.out.print("Amplitude = " + ma);
		System.out.println();
		return true;
	}

	// Driver Code
	public static void main(String[] args) {
		// Given array a[]
		int a[] = { 1, 2, 1, 5, 0, 7, -6 };
		int n = a.length;

		// Calculate number of waves
		int wave = (n - 1) / 2;

		// Function Call
		if (check(a, n))
			System.out.print("Waves = " + wave);
		else
			System.out.print("-1");
		
	}
}
