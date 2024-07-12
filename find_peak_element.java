/*
 * 
 * 162. Find Peak Element
Medium
Topics
Companies
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 

Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
 */



 class Solution {
    public int findPeakElement(int[] nums) {
       int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak is in the left half (including mid)
                right = mid;
            } else {
                // Peak is in the right half (excluding mid)
                left = mid + 1;
            }
        }

        // left and right will converge to the peak element
        return left;
    }
}


/*
 * 
 * Approach
 * 
 * Mainly used two pointer and binary search
 * 
 * 1. find the middle element in the array
 * 2. check if it greater than ajacent right element then the peak element must be in left side so set right pointer to the mid
 * 3. if not then the peak element is in right side to update the left pointer to the mid
 * 4. do the same think until left is less than right
 * 5. then return left
 */