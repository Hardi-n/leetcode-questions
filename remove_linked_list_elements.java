/*
203. Remove Linked List Elements
Easy
Topics
Companies
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:


Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50
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
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to handle edge cases such as removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        // Iterate through the list
        while (current.next != null) {
            if (current.next.val == val) {
                // Remove the node
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        // Return the new head, which is dummy.next
        return dummy.next;
    }
}

/*
 * 
 * 
To remove elements from a linked list in Java, you can define a method that iterates through the list and removes nodes with a specific value. Here's a comprehensive example to illustrate how to remove elements from a linked list.

Problem Statement
Given the head of a linked list and an integer val, remove all the nodes of the linked list that have Node.val == val, and return the new head.

Example
Input:

bash
Copy code
head = [1,2,6,3,4,5,6], val = 6
Output:

csharp
Copy code
[1,2,3,4,5]
Solution
Here's the Java implementation:

java
Copy code
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to handle edge cases such as removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        // Iterate through the list
        while (current.next != null) {
            if (current.next.val == val) {
                // Remove the node
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        // Return the new head, which is dummy.next
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        
        // Value to be removed
        int val = 6;
        
        // Remove elements
        ListNode newHead = removeElements(head, val);
        
        // Print the resulting linked list
        printList(newHead);
    }

    // Utility method to print a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
Explanation
1.ListNode Class:
    A simple definition of a linked list node.

2.removeElements Method:

    *Dummy Node: A dummy node is used to simplify edge cases where the head node itself needs to be removed.
    *Iteration: The method iterates through the linked list using a pointer current.
    *Removal: If current.next.val equals val, the node is skipped by setting current.next to current.next.next.
    *Continuation: If the value doesn't match, current is moved to the next node.
    *The method returns dummy.next, which is the new head of the list.
 */