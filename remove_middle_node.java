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
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: If the list is empty or has only one node, return null
        if (head == null || head.next == null) {
            return null;
        }

        // First, calculate the size of the list
        int size = 0;
        ListNode ptr = head;
        while (ptr != null) {
            size++;
            ptr = ptr.next;
        }

        // Find the middle index
        int mid = size / 2;

        // Move to the node just before the middle node
        ListNode current = head;
        for (int i = 0; i < mid - 1; i++) {
            current = current.next;
        }

        // Remove the middle node
        current.next = current.next.next;

        return head;
    }

    
}
