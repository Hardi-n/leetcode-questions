/*
 * 141. Linked List Cycle
 * Easy
 * Topics
 * Companies
 * Given head, the head of a linked list, determine if the linked list has a
 * cycle in it.
 * 
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is connected
 * to. Note that pos is not passed as a parameter.
 * 
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to
 * the 1st node (0-indexed).
 * Example 2:
 * 
 * 
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to
 * the 0th node.
 * Example 3:
 * 
 * 
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * 
 * 
 * Constraints:
 * 
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * 
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class has_cycle {
    public boolean hasCycle(ListNode head) {
        // Initialize two pointers, slow and fast
        ListNode slow = head;
        ListNode fast = head;

        // Loop until fast or fast.next is null (end of list)
        while (fast != null && fast.next != null) {
            // Move slow pointer by one step
            slow = slow.next;
            // Move fast pointer by two steps
            fast = fast.next.next;

            // If slow and fast meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches the end, there is no cycle
        return false;
    }
}

/*
 * Explanation of the Code:
 * ListNode Class: The ListNode class represents a node in the linked list. Each
 * node has an integer value (val) and a reference to the next node (next).
 * 
 * hasCycle Method: This method checks whether the linked list contains a cycle.
 * 
 * Slow and Fast Pointers: Two pointers, slow and fast, are initialized to the
 * head of the list.
 * Movement:
 * The slow pointer moves one step at a time (slow = slow.next).
 * The fast pointer moves two steps at a time (fast = fast.next.next).
 * Cycle Detection:
 * If there is a cycle, the slow and fast pointers will eventually meet at the
 * same node.
 * If fast reaches the end of the list (fast == null or fast.next == null), the
 * list doesn't contain a cycle.
 * Return Value:
 * 
 * If slow and fast meet, the method returns true, indicating a cycle.
 * If fast reaches the end of the list, the method returns false, indicating no
 * cycle.
 * 
 */