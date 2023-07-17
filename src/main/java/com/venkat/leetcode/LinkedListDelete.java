package com.venkat.leetcode;


/**
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 *
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start
 * using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
 *
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,3,4,7,1,2,6]
 * Output: [1,3,4,1,2,6]
 * Explanation:
 * The above figure represents the given linked list. The indices of the nodes are written below.
 * Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
 * We return the new list after removing this node.
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [1,2,4]
 * Explanation:
 * The above figure represents the given linked list.
 * For n = 4, node 2 with value 3 is the middle node, which is marked in red.
 * Example 3:
 *
 *
 * Input: head = [2,1]
 * Output: [2]
 * Explanation:
 * The above figure represents the given linked list.
 * For n = 2, node 1 with value 1 is the middle node, which is marked in red.
 * Node 0 with value 2 is the only node remaining after removing node 1.
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 1 <= Node.val <= 105
 */
public class LinkedListDelete {


    /**
     * To delete the middle node from a linked list, we can use the
     * two-pointer technique to find the middle node and remove it.
     *
     * We'll use two pointers, slow and fast, initially set to the head of the linked list.
     * slow moves one step at a time, while fast moves two steps at a time. This way, when fast
     * reaches the end of the linked list, slow will be at the middle node.
     *
     * To delete the middle node, we need to update the next pointer of the node before the
     * middle node, making it point to the node after the middle node.
     *
     * In the example above, the output is 1 2 4 5, which represents the modified linked list after
     * deleting the middle node from the original linked list 1 -> 2 -> 3 -> 4 -> 5. The algorithm uses
     * the two-pointer technique to find the middle node and updates the next pointer of the previous node to skip the middle node, effectively deleting it.
     *
     * @param head
     * @return
     */
    public static ListNode deleteMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;  // No middle node to delete
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = slow.next;  // Delete the middle node

        return head;
    }

    public static void main(String[] args) {

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = deleteMiddleNode(head);

        // Print the modified linked list
        while (result != null) {
            System.out.print(result.val + " ");  // Output: 1 2 4 5
            result = result.next;
        }
        System.out.println();
    }
}


