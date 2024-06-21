/*
    Rotate List
    Medium
    Topics
    Companies
    Given the head of a linked list, rotate the list to the right by k places.

    

    Example 1:


    Input: head = [1,2,3,4,5], k = 2
    Output: [4,5,1,2,3]
    Example 2:


    Input: head = [0,1,2], k = 4
    Output: [2,0,1]
    

    Constraints:

    The number of nodes in the list is in the range [0, 500].
    -100 <= Node.val <= 100
    0 <= k <= 2 * 109
 */


 class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        tail.next = head;
        
        k = k % length;
        
        for (int i = 0; i < length - k; i++) {
            tail = tail.next;
        }
        
        head = tail.next;
        tail.next = null;
        
        return head;
    }
}