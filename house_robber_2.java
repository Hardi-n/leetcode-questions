/*
 * 213. House Robber II
Medium
Topics
Companies
Hint
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */


 class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return nums[0];
        }
        
        // Helper function to rob a linear sequence of houses
        
        
        // Rob houses from 0 to size-2
        int robFirst = robLinear(nums, 0, size - 2);
        
        // Rob houses from 1 to size-1
        int robSecond = robLinear(nums, 1, size - 1);
        
        // Return the maximum of the two cases
        return Math.max(robFirst, robSecond);
    }
    private int robLinear(int[] nums, int start, int end) {
            int prev2 = 0; // dp[i-2]
            int prev1 = 0; // dp[i-1]
            
            for (int i = start; i <= end; i++) {
                int current = Math.max(prev1, prev2 + nums[i]);
                prev2 = prev1;
                prev1 = current;
            }
            return prev1;
        }
}





/*
 * 
 * 1.Base Cases:
    If the array is empty (size == 0), return 0.
    If there is only one house (size == 1), return the value of that house.

2.Helper Function (robLinear):
    This function handles the case of robbing a linear sequence of houses from index start to end.
    It uses two variables, prev2 and prev1, to keep track of the maximum amounts robbed up to the previous two houses.
    For each house i from start to end, determine the maximum amount that can be robbed:
    If the current house is robbed, add its value to prev2.
    If the current house is not robbed, the maximum amount is prev1.
    Update prev2 to prev1 and prev1 to current for the next iteration.
    Return the maximum amount robbed, which is stored in prev1.

3.Subproblems:
    Calculate the maximum amount robbed from houses 0 to size-2 using robLinear(nums, 0, size - 2).
    Calculate the maximum amount robbed from houses 1 to size-1 using robLinear(nums, 1, size - 1).

4.Result:
    The final result is the maximum of the two cases, robFirst and robSecond.
 */