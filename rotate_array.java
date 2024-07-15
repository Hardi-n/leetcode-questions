/*
 * 
 * 189. Rotate Array
Medium
Topics
Companies
Hint
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // In case k is larger than the length of the array

        // Step 1: Create an auxiliary array
        int[] temp = new int[n];

        // Step 2: Copy elements to the auxiliary array in rotated positions
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        // Step 3: Copy elements back from the auxiliary array to nums
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}

/*
 * 
 * Approach
 * 
 * 
 * Example
 * Consider the array nums = [1, 2, 3, 4, 5, 6, 7] and k = 3. The goal is to
 * rotate the array to the right by 3 positions, resulting in [5, 6, 7, 1, 2, 3,
 * 4].
 * 
 * Step-by-Step Process
 * Initial Array
 * makefile
 * Copy code
 * nums = [1, 2, 3, 4, 5, 6, 7]
 * n = 7 (length of the array)
 * k = 3
 * Step 1: Create an Auxiliary Array
 * Create a new array temp of the same length n:
 * 
 * css
 * Copy code
 * temp = [_, _, _, _, _, _, _]
 * Step 2: Copy Elements to the Auxiliary Array in Rotated Positions
 * For each element in nums, we calculate the new index in the temp array using
 * the formula (i + k) % n. This formula ensures that the indices wrap around
 * when they exceed the length of the array.
 * 
 * Here's how each element from nums is placed in temp:
 * 
 * i = 0: nums[0] = 1
 * 
 * New index: (0 + 3) % 7 = 3
 * temp[3] = 1
 * temp = [_, _, _, 1, _, _, _]
 * i = 1: nums[1] = 2
 * 
 * New index: (1 + 3) % 7 = 4
 * temp[4] = 2
 * temp = [_, _, _, 1, 2, _, _]
 * i = 2: nums[2] = 3
 * 
 * New index: (2 + 3) % 7 = 5
 * temp[5] = 3
 * temp = [_, _, _, 1, 2, 3, _]
 * i = 3: nums[3] = 4
 * 
 * New index: (3 + 3) % 7 = 6
 * temp[6] = 4
 * temp = [_, _, _, 1, 2, 3, 4]
 * i = 4: nums[4] = 5
 * 
 * New index: (4 + 3) % 7 = 0
 * temp[0] = 5
 * temp = [5, _, _, 1, 2, 3, 4]
 * i = 5: nums[5] = 6
 * 
 * New index: (5 + 3) % 7 = 1
 * temp[1] = 6
 * temp = [5, 6, _, 1, 2, 3, 4]
 * i = 6: nums[6] = 7
 * 
 * New index: (6 + 3) % 7 = 2
 * temp[2] = 7
 * temp = [5, 6, 7, 1, 2, 3, 4]
 * Now, the temp array contains the elements of nums in their rotated positions:
 * 
 * css
 * Copy code
 * temp = [5, 6, 7, 1, 2, 3, 4]
 * Step 3: Copy Elements Back from the Auxiliary Array to nums
 * Finally, copy the elements from temp back to nums:
 * 
 * i = 0: nums[0] = temp[0] = 5
 * i = 1: nums[1] = temp[1] = 6
 * i = 2: nums[2] = temp[2] = 7
 * i = 3: nums[3] = temp[3] = 1
 * i = 4: nums[4] = temp[4] = 2
 * i = 5: nums[5] = temp[5] = 3
 * i = 6: nums[6] = temp[6] = 4
 * After copying, the nums array is:
 * 
 */