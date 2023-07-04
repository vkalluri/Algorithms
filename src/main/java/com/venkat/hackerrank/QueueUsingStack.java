package com.venkat.hackerrank;

import java.util.Stack;

public class QueueUsingStack {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public QueueUsingStack() {
		// TODO Auto-generated constructor stub
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void enqueue(int element) {
		stack1.push(element);
	}

	public int dequeue() {
		if (stack2.isEmpty()) {
			transferElements();
		}
		return stack2.pop();
	}

	public int peek() {
		if (stack2.isEmpty()) {
			transferElements();
		}
		return stack2.peek();
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	private void transferElements() {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}

}
