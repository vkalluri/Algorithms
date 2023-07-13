package com.venkat.leetcode;


/**
 * 2. Add Two Numbers
 * Medium
 * 26.9K
 * 5.2K
 * Companies
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoLinkedLists {

    /**
     * In this implementation, we iterate through the two input linked lists simultaneously,
     * starting from the head nodes. We keep track of the current sum and carry value as we move forward.
     *
     * At each step, we add the current values of the nodes from the two lists,
     * along with the carry value from the previous step. We calculate the new carry
     * and the value to be stored in the new node of the result list.
     *
     * We create a dummy node to serve as the head of the result list, and we maintain a
     * current pointer to keep track of the last node in the result list. We append each
     * new node to the result list by setting the next pointer of the current node to the new node.
     *
     * After iterating through both lists, if there is still a non-zero carry, we create a new node for it and append it to the result list.
     *
     * Finally, we return the next pointer of the dummy node, which points to the actual result list.
     *
     * You can use this solution by creating an instance of the AddTwoLinkedLists class and calling the addTwoNumbers
     * method with the two input linked lists as parameters. The method will return the resulting linked list representing the sum of the two numbers.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            current.next = new ListNode(sum);
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
