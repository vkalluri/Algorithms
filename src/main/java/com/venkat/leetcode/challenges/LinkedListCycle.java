package com.venkat.leetcode.challenges;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * Example 2:
 *
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * Example 3:
 *
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 * Constraints:
 *
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 *
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListCycle {
    /**
     * In this program, the hasCycle method takes the head of a linked list as input and returns
     * a boolean value indicating whether the linked list contains a cycle or not. It uses two pointers,
     * tortoise and hare, initially pointing to the head and head.next nodes, respectively.
     * The algorithm iterates through the linked list, moving the tortoise one step at a time and the hare two steps at a time.
     * If there is a cycle, the hare will eventually catch up to the tortoise, and they will meet at the same node.
     * If the hare reaches the end of the linked list (null) or the next node is null, it means there is no cycle
     * and the method returns false. Finally, the main method demonstrates an example usage of the hasCycle
     * method by creating a linked list with a cycle and checking if it has a cycle.
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode1 head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode1 tortoise = head;
        ListNode1 hare = head.next;

        while (tortoise != hare) {
            if (hare == null || hare.next == null) {
                return false;
            }

            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = head.next; // Create a cycle

        boolean result = hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + result);
    }
}
class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int val) {
        this.val = val;
        this.next = null;
    }
}
