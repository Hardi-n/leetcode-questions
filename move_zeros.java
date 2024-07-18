/*
 * 283. Move Zeroes
 * Easy
 * Topics
 * Companies
 * Hint
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * 
 * Input: nums = [0]
 * Output: [0]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * 
 */

 class Solution {
    public void moveZeroes(int[] nums) {
        // Pointer for the position of the last non-zero element
        int lastNonZeroIndex = 0;
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero, move it to the lastNonZeroIndex position
            if (nums[i] != 0) {
                // Swap the elements
                int temp = nums[lastNonZeroIndex];
                nums[lastNonZeroIndex] = nums[i];
                nums[i] = temp;
                // Increment the lastNonZeroIndex
                lastNonZeroIndex++;
            }
        }
    }
}


/*
 * Approach
 * 
 * 1. set the pointer to the first element...
 * 2. check that elements are zero or non zero..
 * 3. if non-zero swap it with pointer  and pointer ++
 * 4. else do nothing
 */