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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // First, calculate the size of the list
        ListNode ptr = head;
        int size = 0;
        while (ptr != null) {
            size++;
            ptr = ptr.next;
        }
        
        // If we need to remove the head node
        if (n == size) {
            return head.next;
        }
        
        // Find the node just before the one we need to remove
        int stepsToMove = size - n - 1;
        ListNode current = head;
        for (int i = 0; i < stepsToMove; i++) {
            current = current.next;
        }
        
        // Remove the nth node from the end
        if (current.next != null) {
            current.next = current.next.next;
        }

        return head;
    }

    // Helper method to print the list (for testing purposes)
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        
        System.out.print("Original list: ");
        solution.printList(head);

        // Remove the 2nd node from the end, the list should become 1 -> 2 -> 3 -> 5
        head = solution.removeNthFromEnd(head, 2);

        System.out.print("After removing 2nd node from end: ");
        solution.printList(head);
    }
}
