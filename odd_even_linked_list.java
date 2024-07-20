/*
 * 
 * 328. Odd Even Linked List
 * Medium
 * Topics
 * Companies
 * Given the head of a singly linked list, group all the nodes with odd indices
 * together followed by the nodes with even indices, and return the reordered
 * list.
 * 
 * The first node is considered odd, and the second node is even, and so on.
 * 
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 * 
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * Example 2:
 * 
 * 
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the linked list is in the range [0, 104].
 * -106 <= Node.val <= 106
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        // Step 1: Count the number of nodes in the linked list
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        // Step 2: Create an array of the same size as the number of nodes
        int[] array = new int[count];

        // Step 3: Fill the array with node values
        current = head;
        int index = 0;
        while (current != null) {
            array[index] = current.val;
            current = current.next;
            index++;
        }

        // Step 4: Create a new array for the rearranged values
        int[] newArray = new int[count];
        int evenIndex = 0;
        int oddIndex = (count + 1) / 2;

        // Populate newArray with even-indexed elements followed by odd-indexed elements
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                newArray[evenIndex++] = array[i];
            } else {
                newArray[oddIndex++] = array[i];
            }
        }

        // Step 5: Create a new linked list from newArray
        ListNode newHead = new ListNode(newArray[0]);
        ListNode newCurrent = newHead;
        for (int i = 1; i < count; i++) {
            newCurrent.next = new ListNode(newArray[i]);
            newCurrent = newCurrent.next;
        }

        return newHead;
    }
}



/*
 * 
 * Approach
 * 
 * 1.   convert linked list into array
 * 2.   add even index element of array in new array then add odd index elements in newarray
 * 3.   convert back this array into linked list
 * 4.   return the head of the linked list
 */