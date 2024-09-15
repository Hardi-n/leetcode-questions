/*
 * 
 * 3217. Delete Nodes From Linked List Present in Array
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an array of integers nums and the head of a linked list. Return
 * the head of the modified linked list after removing all nodes from the linked
 * list that have a value that exists in nums.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3], head = [1,2,3,4,5]
 * 
 * Output: [4,5]
 * 
 * Explanation:
 * 
 * 
 * 
 * Remove the nodes with values 1, 2, and 3.
 * 
 * Example 2:
 * 
 * Input: nums = [1], head = [1,2,1,2,1,2]
 * 
 * Output: [2,2,2]
 * 
 * Explanation:
 * 
 * 
 * 
 * Remove the nodes with value 1.
 * 
 * Example 3:
 * 
 * Input: nums = [5], head = [1,2,3,4]
 * 
 * Output: [1,2,3,4]
 * 
 * Explanation:
 * 
 * 
 * 
 * No node has value 5.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * All elements in nums are unique.
 * The number of nodes in the given list is in the range [1, 105].
 * 1 <= Node.val <= 105
 * The input is generated such that there is at least one node in the linked
 * list that has a value not present in nums.
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        List<Integer> list = new ArrayList<>();

        // Step 1: Traverse the linked list and collect the values
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        // Convert the list to an array (values from the linked list)
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        // Use a HashSet to store the values of the linked list (result array)
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Create a list to collect elements from nums that are not in result (linked
        // list values)
        List<Integer> filteredNums = new ArrayList<>();
        for (int num : result) {
            if (!set.contains(num)) {
                filteredNums.add(num);
            }
        }

        // Create the modified linked list from the filtered elements
        ListNode dummy = new ListNode(0); // Dummy node to simplify node creation
        ListNode currentNew = dummy;

        for (int i = 0; i < filteredNums.size(); i++) {
            currentNew.next = new ListNode(filteredNums.get(i));
            currentNew = currentNew.next;
        }

        // Return the next of the dummy node, which is the head of the modified list
        return dummy.next;
    }
}

/*
 * 
 * Explanation:
 * Collecting values from the linked list: The values from the linked list are
 * collected into a List<Integer>, then converted to an array (result[]).
 * HashSet for fast lookups: All the values from the linked list (result[]) are
 * stored in a HashSet<Integer> to allow quick lookups.
 * Filtering the nums[] array: Elements from nums[] that are not in the HashSet
 * are added to the filteredNums list.
 * Building the new linked list: A dummy node is used to simplify linked list
 * creation. For each element in filteredNums, a new node is created and linked
 * to the previous node. The method then returns dummy.next, which is the head
 * of the new list.
 */