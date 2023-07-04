package com.venkat.coderpad;

import java.util.Arrays;

public class UniqueProduct {
	public static String firstUniqueProduct(String[] products) {
		Arrays.parallelSort(products);
		System.out.println(Arrays.toString(products));
		for (int i = 0; i < products.length; i++) {
			boolean unique = true;
			for (int j = i + 1; j < products.length; j++) {
				if (products[j].equals(products[i])) {
					products[j] = products[products.length - 1];
					unique = false;
					break;
				}
				if (unique) {
					return products[i];
				}
			}

		}
		return null;

	}

	public static void main(String[] args) {
		System.out.println(firstUniqueProduct(new String[] { "Apple", "Computer", "Apple", "Bag" }));
	}
}