/*
 * 
Code


Testcase
Testcase
Test Result
206. Reverse Linked List
Easy
Topics
Companies
Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        int size = 0;
        ListNode ptr = head;
        while (ptr != null) {
            size++;
            ptr = ptr.next;
        }
        
        int[] arr = new int[size];
        ptr = head;
        for (int i = 0; i < size; i++) {
            arr[i] = ptr.val;
            ptr = ptr.next;
        }
        
        ListNode newHead = new ListNode(arr[size - 1]);
        ListNode current = newHead;
        for (int i = size - 2; i >= 0; i--) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        
        return newHead;
    }
}



/*
 * 
 * 1. Go through the list and find size 
 * 2. initialise array of that size 
 * 3. fill the array with elements in linked list
 * 4. make a new list and add elements of reversed array in the list
 */