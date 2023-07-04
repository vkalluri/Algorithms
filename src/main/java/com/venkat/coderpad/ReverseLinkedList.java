package com.venkat.coderpad;

public class ReverseLinkedList {
	 public static void main(String[] args) {
	        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
	        ListNode head = new ListNode(1);
	        head.next = new ListNode(2);
	        head.next.next = new ListNode(3);
	        head.next.next.next = new ListNode(4);
	        head.next.next.next.next = new ListNode(5);

	        System.out.println("Original Linked List:");
	        printLinkedList(head);

	        ListNode reversedHead = reverseLinkedList(head);

	        System.out.println("Reversed Linked List:");
	        printLinkedList(reversedHead);
	    }

	    public static ListNode reverseLinkedList(ListNode head) {
	        ListNode prev = null;
	        ListNode current = head;
	        ListNode next = null;

	        while (current != null) {
	            next = current.next; // Store the next node
	            current.next = prev; // Reverse the pointer direction
	            prev = current; // Move prev and current one step ahead
	            current = next; // Move prev and current one step ahead
	        }

	        return prev; // Prev will be the new head of the reversed list
	    }

	    public static void printLinkedList(ListNode head) {
	        ListNode current = head;

	        while (current != null) {
	            System.out.print(current.val + " ");
	            current = current.next;
	        }

	        System.out.println();
	    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

