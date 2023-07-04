package com.venkat.leetcode.challenges;

/**
 * 25. Reverse Nodes in k-Group Hard 11.5K 587 Companies Given the head of a
 * linked list, reverse the nodes of the list k at a time, and return the
 * modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes, in
 * the end, should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may
 * be changed.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 2 Output: [2,1,4,3,5] Example 2:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 3 Output: [3,2,1,4,5]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is n. 1 <= k <= n <= 5000 0 <= Node.val <=
 * 1000
 * 
 * 
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 * 
 * @author vkall
 *
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}

public class ReverseNodesInKGroup {
	/**
	 * In this implementation, we define a ListNode class to represent each node of
	 * the linked list. The reverseKGroup function takes the head of the linked list
	 * and the group size k as parameters.
	 * 
	 * The function recursively reverses the list in groups of size k. It first
	 * checks if there are at least k nodes remaining in the list. If so, it
	 * recursively calls reverseKGroup on the remaining portion of the list after
	 * the current group. This ensures that the subsequent groups are also reversed.
	 * 
	 * Next, it reverses the current group by adjusting the next pointers of the
	 * nodes. It maintains three pointers: head (the current group's head), current
	 * (the current node being processed), and nextNode (the next node to process).
	 * 
	 * Inside the loop, it updates the nextNode pointer, reverses the next pointer
	 * of the current node to point to the current node, and updates the current
	 * node and nextNode pointers accordingly. This process continues until the
	 * group is reversed.
	 * 
	 * Finally, it updates the head to the last node of the reversed group and
	 * returns it.
	 * 
	 * In the main method, an example linked list is created, and the reverseKGroup
	 * function is called to reverse the list in groups of size k. The original and
	 * reversed lists are then printed to the console for verification.
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode current = head;
		int count = 0;
		while (current != null && count < k) {
			current = current.next;
			count++;
		}
		if (count == k) {
			current = reverseKGroup(current, k);
			while (count > 0) {
				ListNode nextNode = head.next;
				head.next = current;
				current = head;
				head = nextNode;
				count--;
			}
			head = current;
		}
		return head;
	}

	public static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		int k = 2;

		System.out.println("Original List:");
		printList(head);

		ListNode reversed = reverseKGroup(head, k);

		System.out.println("Reversed List:");
		printList(reversed);
	}
}
