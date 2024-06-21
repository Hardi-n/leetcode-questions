/*
 * Reorder List
    Medium
    Topics
    Companies
    You are given the head of a singly linked-list. The list can be represented as:

    L0 → L1 → … → Ln - 1 → Ln
    Reorder the list to be on the following form:

    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    You may not modify the values in the list's nodes. Only nodes themselves may be changed.

    

    Example 1:


    Input: head = [1,2,3,4]
    Output: [1,4,2,3]
    Example 2:


    Input: head = [1,2,3,4,5]
    Output: [1,5,2,4,3]
    
 */

 
//   Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the linked list
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        // Step 3: Merge the first half and the reversed second half alternately
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ListNode nextFirst = first.next;
            ListNode nextSecond = second.next;
            first.next = second;
            second.next = nextFirst;
            first = nextFirst;
            second = nextSecond;
        }
    }
}

/*
 * 
Certainly! Let's break down the code step by step:

Find the Middle of the Linked List:

We use the slow and fast pointer technique to find the middle of the linked list. The slow pointer moves one step at a time while the fast pointer moves two steps at a time. When the fast pointer reaches the end of the list, the slow pointer will be at the middle node (or the first node of the second half if the total number of nodes is odd).
Reverse the Second Half of the Linked List:

Once we find the middle of the list, we split the list into two halves. The first half remains unchanged, and the second half needs to be reversed.
We iterate through the second half of the list and reverse its links to make it point in the opposite direction.
Merge the First and Reversed Second Halves Alternately:

Now that we have the first half and the reversed second half of the list, we merge them alternately.
We maintain two pointers, first pointing to the head of the first half and second pointing to the head of the reversed second half.
We iterate through both halves, adjusting the pointers to interleave the nodes from the first and second halves.
Completing the Reordering:

After merging, the reordered list will be as described: the first element is at the front, the second element is at the back, the third element is at the second position, the fourth element is at the second to last position, and so on.
 */