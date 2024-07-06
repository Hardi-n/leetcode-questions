/*
 * 
 * 
 * 136. Single Number
Easy
Topics
Companies
Hint
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
 */



 class Solution {
    public int singleNumber(int[] nums) {
        int returningvariable = 0; // Initialize the variable
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int number = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (number == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                returningvariable = number;
                break;
            }
        }
        return returningvariable;
    }
}


/*
 * 
 * 
1.Initialization:
    int returningvariable = 0; initializes the variable to hold the single number.

2.Count Occurrences:
    The outer loop iterates through each number in the array.
    The inner loop counts how many times the current number appears in the array.
    if (count == 1) checks if the number appears exactly once.

3.Break on Finding the Single Number:
    If a number appears exactly once, assign it to returningvariable and break the loop.
    Finally, return returningvariable.
 */