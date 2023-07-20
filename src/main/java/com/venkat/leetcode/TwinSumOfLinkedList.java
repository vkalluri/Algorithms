package com.venkat.leetcode;


/**
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the
 * linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 *
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 *
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [5,4,2,1]
 * Output: 6
 * Explanation:
 * Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
 * There are no other nodes with twins in the linked list.
 * Thus, the maximum twin sum of the linked list is 6.
 * Example 2:
 *
 *
 * Input: head = [4,2,2,3]
 * Output: 7
 * Explanation:
 * The nodes with twins present in this linked list are:
 * - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
 * - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
 * Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
 * Example 3:
 *
 *
 * Input: head = [1,100000]
 * Output: 100001
 * Explanation:
 * There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is an even integer in the range [2, 105].
 * 1 <= Node.val <= 105
 */
public class TwinSumOfLinkedList {


    /**
     * To find the maximum twin sum in a linked list with an even length, we can follow these steps:
     *
     * Initialize the maximum twin sum (maxSum) as 0.
     * Traverse the linked list and calculate the twin sum for each pair of nodes.
     * For each node at index i, calculate the twin sum by adding the values of the current node and its twin node at index (n - 1 - i).
     * Update maxSum if the current twin sum is greater than the current maxSum.
     * Return the maxSum
     *
     * @param head
     * @return
     */
    public static int maxTwinSum(ListNode head) {
        int maxSum = 0;
        ListNode current = head;
        int index = 0;
        int size = getSize(head);

        while (current != null && index < size / 2) {
            int twinIndex = size - 1 - index;
            ListNode twinNode = getNodeAt(head, twinIndex);

            int twinSum = current.val + twinNode.val;
            maxSum = Math.max(maxSum, twinSum);

            current = current.next;
            index++;
        }

        return maxSum;
    }

    private static int getSize(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    private static ListNode getNodeAt(ListNode head, int index) {
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public static void main(String[] args) {

        // Create a sample linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Find the maximum twin sum
        int maxTwinSum = maxTwinSum(head);

        System.out.println(maxTwinSum);
        // Output: 5 (The maximum twin sum is 4 + 1 = 5)
    }
}
