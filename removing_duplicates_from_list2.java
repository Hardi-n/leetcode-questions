/*
 * 
 * 82. Remove Duplicates from Sorted List II
Medium
Topics
Companies
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy; // Pointer to the last node before the sequence of duplicates
        
        while (head != null) {
            // If current node is a start of duplicates
            if (head.next != null && head.val == head.next.val) {
                // Move head forward while there are duplicates
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Skip all duplicates
                prev.next = head.next;
            } else {
                // If no duplicate, just move prev pointer
                prev = prev.next;
            }
            // Move head pointer
            head = head.next;
        }
        
        return dummy.next;
    }
}


/*
 * Approach
1.Dummy Node:
    Use a dummy node to simplify edge cases, especially when the head itself might need to be removed.

2.Two Pointers:
    Use two pointers: one (prev) pointing to the last node known to have a unique value, and another (current) to traverse the list.

3.Traverse and Detect Duplicates:
    As you traverse the list with current, check if the current node's value is the same as the next node's value.
    If a duplicate is found, skip all nodes with this value.
    If no duplicate is found, move the prev pointer to the current node.

4.Linking Non-Duplicate Nodes:
    Ensure that prev always points to the last node with a unique value.
 */