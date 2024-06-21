/*
 * Swap Nodes in Pairs
    Medium
    Topics
    Companies
    Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

    

    Example 1:


    Input: head = [1,2,3,4]
    Output: [2,1,4,3]
    Example 2:

    Input: head = []
    Output: []
    Example 3:

    Input: head = [1]
    Output: [1]
    

    Constraints:

    The number of nodes in the list is in the range [0, 100].
    0 <= Node.val <= 100
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
    public ListNode swapPairs(ListNode head) {
        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        
        // Continue swapping pairs as long as there are at least two nodes remaining
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            
            // Swap the nodes
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            // Move pointers to the next pair
            prev = first;
            head = first.next;
        }
        
        return dummy.next;
        
        
    }
}