/*
 * 92. Reverse Linked List II
Medium
Topics
Companies
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 */


    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Dummy node to handle case when 'left' is 1
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevLeft = dummy;

        // Move prevLeft to the node just before left
        for (int i = 1; i < left; i++) {
            prevLeft = prevLeft.next;
        }

        // Node to reverse
        ListNode curr = prevLeft.next;
        ListNode next = null;
        ListNode prev = null;

        // Reverse nodes from left to right
        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Connect the reversed sublist
        prevLeft.next.next = curr; // Connect the end of reversed part to the node after 'right'
        prevLeft.next = prev; // Connect the beginning of reversed part to prev

        return dummy.next;
    }
}