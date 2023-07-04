package com.venkat.test;

public class Node {
	int value;
	Node left;
	Node right;

	Node(int value) {
		this.value = value;
		System.out.println(value);
		right = null;
		left = null;
	}

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public void add(int value) {
		
		Node root = addRecursive(null, value);
	}
	
	public static void main(String[] args) {
		Node node = new Node(10);
		node.add(7);
		node.add(15);
		node.add(5);
		node.add(9);
	}

}
