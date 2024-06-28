/*
 * 
 * 147. Insertion Sort List
Medium
Topics
Companies
Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.


 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
 

Constraints:

The number of nodes in the list is in the range [1, 5000].
-5000 <= Node.val <= 5000
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
    public ListNode insertionSortList(ListNode head) {
        // Create a dummy node to act as the head of the sorted linked list
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        
        // Traverse the original list and insert each node into the new list
        while (curr != null) {
            // At each iteration, curr is the node to be inserted into the sorted part
            ListNode prev = dummy;
            
            // Find the position to insert the current node
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            
            // Save the next node to be processed
            ListNode next = curr.next;
            
            // Insert the current node into the sorted list
            curr.next = prev.next;
            prev.next = curr;
            
            // Move to the next node in the original list
            curr = next;
        }
        
        return dummy.next;
    }
}




/*
 * Steps of Insertion Sort for Linked List
1.Create a Dummy Node:
    A dummy node acts as the head of the new sorted linked list. It simplifies insertion at the beginning of the list.

2.Traverse the Original List:
    Use a pointer (curr) to iterate through each node of the original linked list.

3.Find the Correct Position:
    For each node (curr), find the position in the sorted part where it should be inserted. This is done using another pointer (prev).

4.Insert the Node:
    Save the next node to be processed (next).
    Insert the curr node in the correct position by adjusting pointers.
    Move to the next node (curr = next).

5.Return the Sorted List:
    The head of the sorted list is dummy.next.
 */