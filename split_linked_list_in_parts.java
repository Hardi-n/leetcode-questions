/*
 * 725. Split Linked List in Parts
 * Medium
 * Topics
 * Companies
 * Hint
 * Given the head of a singly linked list and an integer k, split the linked
 * list into k consecutive linked list parts.
 * 
 * The length of each part should be as equal as possible: no two parts should
 * have a size differing by more than one. This may lead to some parts being
 * null.
 * 
 * The parts should be in the order of occurrence in the input list, and parts
 * occurring earlier should always have a size greater than or equal to parts
 * occurring later.
 * 
 * Return an array of the k parts.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but its string representation as a
 * ListNode is [].
 * Example 2:
 * 
 * 
 * Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * Output: [[1,2,3,4],[5,6,7],[8,9,10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most
 * 1, and earlier parts are a larger size than the later parts.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 1000].
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        // Step 1: Calculate the length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Step 2: Calculate the size of each part and the number of extra nodes
        int partSize = length / k; // Minimum size of each part
        int extraNodes = length % k; // Parts that will have an extra node

        // Step 3: Split the list into parts
        current = head;
        for (int i = 0; i < k; i++) {
            result[i] = current; // Set the head of the current part
            int currentPartSize = partSize + (extraNodes > 0 ? 1 : 0); // Extra node for the first 'extraNodes' parts
            extraNodes--;

            // Step 4: Traverse the current part and disconnect the end
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) {
                    current = current.next;
                }
            }

            // Disconnect the current part from the rest of the list
            if (current != null) {
                ListNode nextPartHead = current.next;
                current.next = null;
                current = nextPartHead; // Move to the next part
            }
        }

        return result;
    }
}

/*
 * 
 * Explanation:
 * Calculate the length of the linked list: Traverse the linked list to compute
 * its total length.
 * 
 * Determine part sizes:
 * 
 * Each part has a base size of length / k.
 * The first remainder = length % k parts get one extra node to distribute nodes
 * evenly.
 * 
 * 
 * Traverse and split:
 * 
 * For each part, assign the head node and traverse the linked list up to the
 * size of the part.
 * Disconnect the last node of each part from the rest of the list by setting
 * its next pointer to null.
 * Return: Return an array of ListNode[] where each entry is the head of one of
 * the k parts.
 */