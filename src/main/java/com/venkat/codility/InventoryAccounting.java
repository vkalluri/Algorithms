package com.venkat.codility;

import java.util.HashMap;
import java.util.Map;

public class InventoryAccounting {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();

		inventory.addItem("Apple", 10);
		inventory.addItem("Banana", 5);
		inventory.addItem("Orange", 3);

		inventory.printInventory();

		inventory.sellItem("Apple", 5);
		inventory.sellItem("Banana", 3);

		inventory.printInventory();

		inventory.sellItem("Orange", 5); // Insufficient quantity

		inventory.printInventory();
	}
}

class Inventory {
	private Map<String, Integer> items;

	public Inventory() {
		items = new HashMap<>();
	}

	public void addItem(String itemName, int quantity) {
		int currentQuantity = items.getOrDefault(itemName, 0);
		items.put(itemName, currentQuantity + quantity);
	}

	public void sellItem(String itemName, int quantity) {
		if (!items.containsKey(itemName)) {
			System.out.println("Item not found in inventory.");
			return;
		}

		int currentQuantity = items.get(itemName);
		if (quantity > currentQuantity) {
			System.out.println("Insufficient quantity in inventory.");
			return;
		}

		items.put(itemName, currentQuantity - quantity);
	}

	public void printInventory() {
		System.out.println("Current Inventory:");

		for (Map.Entry<String, Integer> entry : items.entrySet()) {
			String itemName = entry.getKey();
			int quantity = entry.getValue();
			System.out.println(itemName + ": " + quantity);
		}
	}
}
