/*
 * 16. 3Sum Closest
Medium
Topics
Companies
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Update the closestSum if the currentSum is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    // If the currentSum is exactly equal to the target
                    return currentSum;
                }
            }
        }

        return closestSum;
    }
}

/*
 * Approach
 * 1.Sort the Array: Sorting helps in using the two-pointer technique
 *   effectively.
 * 2.Iterate Through the Array: Use a loop to fix the first element and apply
 *   the two-pointer technique to find pairs that sum to a value closest to the
 *   target minus the fixed element.
 * 3.Two-Pointer Technique: For each fixed element, use two pointers to find the
 *   pair that, along with the fixed element, forms the sum closest to the target.
 * 4.Track the Closest Sum: Maintain a variable to track the closest sum found
 *   so far and update it whenever a closer sum is found.
 */