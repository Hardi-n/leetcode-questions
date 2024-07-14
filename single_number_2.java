/*
 * 137. Single Number II
Medium
Topics
Companies
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 

Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
 */



 class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);  // Sort the array

        // Iterate through the array in steps of 3
        for (int i = 0; i < nums.length; i += 3) {
            // If the next element is different, the current element is the single one
            if (i + 1 >= nums.length || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        // This return statement is unreachable, as there must be one unique element
        return -1;
    }
}



/*
 * 
 * 
 * Approach 
 * 
 * 
 * 1.   Firsly sort the array
 * 2.   iterate through the array in steps of 3
 * 3.   now check the out of bound condition and also next element is not same
 * 4.   return the element if both the conditions are satisfied
 * 
 */