/*
 * 86. Partition List
Medium
Topics
Companies
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // Create two dummy nodes
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        // Create two pointers to build the two lists
        ListNode less = lessHead;
        ListNode greater = greaterHead;

        // Traverse the original list
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        // Connect the less list with the greater list
        less.next = greaterHead.next;

        // Terminate the list to avoid cycle
        greater.next = null;

        // Return the head of the less list, which is now the new head
        return lessHead.next;
    }
}

/*
 * Approach\
 * 
 * 
 * 1.Create Two Dummy Nodes:
    * Use two dummy nodes to simplify the process: one for the list of nodes less
    * than x, and one for the list of nodes greater than or equal to x.
 * 
 * 2.Partition the List:
    * Traverse the original list and partition the nodes into two separate lists
    * based on the value x.
 * 
 * 3.Merge the Lists:
    * Connect the less-than list to the greater-than-or-equal-to list.
 * 
 * 4.Handle the Tail:
    * Ensure the end of the merged list points to null.
 */