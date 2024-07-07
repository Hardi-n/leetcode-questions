/*
 * 148. Sort List
Medium
Topics
Companies
Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
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
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        // Step 1: Find the size of the linked list
        ListNode ptr = head;
        int size = 0;
        while (ptr != null) {
            size++;
            ptr = ptr.next;
        }

        // Step 2: Store the linked list values into an array
        int[] arr = new int[size];
        ptr = head;
        for (int i = 0; i < size; i++) {
            arr[i] = ptr.val;
            ptr = ptr.next;
        }

        // Step 3: Sort the array
        Arrays.sort(arr);

        // Step 4: Create a new sorted linked list using the sorted array
        ListNode sortedHead = new ListNode(arr[0]);
        ListNode current = sortedHead;
        for (int i = 1; i < size; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return sortedHead;
    }
}


/*
 * 
 * 
 * To sort a linked list using an array, you need to follow these steps:

        1.Traverse the linked list to find its size.
        2.Store the values of the linked list nodes into an array.
        3.Sort the array using Arrays.sort().
        4.Create a new sorted linked list using the sorted array.


        
 */