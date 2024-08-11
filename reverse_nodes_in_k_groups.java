/*
 * 
 * 25. Reverse Nodes in k-Group
 * Hard
 * Topics
 * Companies
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes, in
 * the end, should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may
 * be changed.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prevGroupEnd = dummy;
        
        while (true) {
            // Check if there are k nodes left to reverse
            ListNode kthNode = prevGroupEnd;
            for (int i = 0; i < k; i++) {
                kthNode = kthNode.next;
                if (kthNode == null) {
                    return dummy.next; // If less than k nodes left, return the list as it is
                }
            }
            
            // Reverse k nodes
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kthNode.next;
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;
            
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            // Connect with the previous part
            prevGroupEnd.next = prev;
            prevGroupEnd = groupStart;
        }
    }
}



/*
 * 
 * 
 * 
 * Approach
 * 
 * 
 * Steps to Solve:
 * Count the Length: First, count the length of the linked list. If the length
 * is less than k, no reversing is needed.
 * Reverse in Groups: Traverse the linked list and reverse every k nodes.
 * Connect the Nodes: After reversing each group, connect it to the previous
 * group.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Code Structure Overview:
 * ListNode Definition:
 * 
 * The ListNode class represents a node in the linked list, with an integer
 * value (val) and a pointer to the next node (next).
 * Dummy Node:
 * 
 * A dummy node is created to act as a placeholder before the start of the list.
 * This helps simplify edge cases, like when the head of the list itself changes
 * after reversing the first k nodes.
 * Iterative Reversal in Groups:
 * 
 * prevGroupEnd: Tracks the end of the previous reversed group. Initially, it
 * points to the dummy node.
 * kthNode: Used to check if there are enough nodes (k nodes) left in the list
 * to reverse. If not, the list remains unchanged for that part.
 * Reversing the Group:
 * groupStart: Marks the beginning of the current group to be reversed.
 * nextGroupStart: The node right after the k nodes, which will be the start of
 * the next group or the rest of the list.
 * Reversal Process: The for loop inside the reversal process iteratively
 * reverses the pointers of the k nodes.
 * Connecting Reversed Groups:
 * 
 * After reversing the current group of k nodes, the group is connected to the
 * previous part of the list using prevGroupEnd.next = prev.
 * prevGroupEnd is then updated to the end of the reversed group to prepare for
 * the next reversal.
 * Loop Until All Groups Are Processed:
 * 
 * The process repeats for the next group of k nodes until fewer than k nodes
 * remain, at which point the loop ends, and the modified list is returned.
 * Key Points:
 * Dummy Node: Simplifies handling edge cases.
 * prevGroupEnd: Maintains the connection between reversed groups.
 * Reversing Logic: Efficiently reverses nodes within each group.
 * Edge Handling: Automatically stops reversing if fewer than k nodes are left.
 * Example Walkthrough:
 * For a list [1, 2, 3, 4, 5] and k = 2:
 * 
 * First Group: Reverse [1, 2] to get [2, 1].
 * Second Group: Reverse [3, 4] to get [4, 3].
 * Final Result: Connect the groups to get [2, 1, 4, 3, 5].
 * This code provides a clean and efficient way to reverse nodes in groups of k
 * within a linked list.
 */