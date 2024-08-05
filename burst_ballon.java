/*
 * 
 * 312. Burst Balloons
 * Hard
 * Topics
 * Companies
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted
 * with a number on it represented by an array nums. You are asked to burst all
 * the balloons.
 * 
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i +
 * 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as
 * if there is a balloon with a 1 painted on it.
 * 
 * Return the maximum coins you can collect by bursting the balloons wisely.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins = 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
 * Example 2:
 * 
 * Input: nums = [1,5]
 * Output: 10
 * 
 * 
 * Constraints:
 * 
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 */


 class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] extendedNums = new int[n + 2];
        extendedNums[0] = extendedNums[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            extendedNums[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                            dp[left][k - 1] + extendedNums[left - 1] * extendedNums[k] * extendedNums[right + 1]
                                    + dp[k + 1][right]);
                }
            }
        }

        return dp[1][n];
    }
}



/*
 * 
 * 
 * Nested Loop Structure:
The provided nested loops are used to fill in the dp array, which is a dynamic programming table. The loops systematically consider all possible subarrays (ranges) within the extendedNums array and compute the maximum coins that can be obtained by bursting all the balloons in those subarrays.

Outer Loop (Length of Subarray):
java
Copy code
for (int len = 1; len <= n; len++) {
    // Loop over all possible lengths of subarrays (from 1 to n)
len represents the length of the subarray.
This loop runs from 1 to n, covering all possible lengths of subarrays (starting from length 1 up to the full length n).
Middle Loop (Left Boundary of Subarray):
java
Copy code
for (int left = 1; left <= n - len + 1; left++) {
    // Loop over all possible starting points of the subarray of length `len`
    int right = left + len - 1;
left represents the starting index of the subarray.
This loop runs from 1 to n - len + 1, ensuring that the subarray fits within the bounds of the array.
right is calculated as left + len - 1, which gives the ending index of the subarray.
Inner Loop (Last Balloon to Burst in Subarray):
java
Copy code
for (int k = left; k <= right; k++) {
    dp[left][right] = Math.max(dp[left][right],
            dp[left][k - 1] + extendedNums[left - 1] * extendedNums[k] * extendedNums[right + 1]
                    + dp[k + 1][right]);
}
k represents the index of the last balloon to be burst in the current subarray.
This loop runs from left to right, considering each possible balloon within the subarray as the last balloon to be burst.
dp[left][right] is updated by considering the coins collected when balloon k is the last one to burst in the subarray. The update involves:
The coins collected from bursting all balloons in the subarray from left to k-1 (dp[left][k-1]).
The coins obtained from bursting the balloon k itself (extendedNums[left - 1] * extendedNums[k] * extendedNums[right + 1]).
The coins collected from bursting all balloons in the subarray from k+1 to right (dp[k+1][right]).
Putting It All Together:
The outer loop ensures that all subarray lengths are considered, starting from the smallest subarray (length 1) to the largest (length n).
The middle loop ensures that all starting positions for subarrays of the current length are considered.
The inner loop ensures that each possible balloon within the current subarray is considered as the last balloon to burst, allowing the DP table to capture the optimal strategy for each subarray.
Visual Example:
For example, let's say nums = [4, 3, 2, 6]:

For len = 1:

Consider subarrays of length 1: [4], [3], [2], [6].
Each subarray is just one balloon, so the coins collected are straightforward.
For len = 2:

Consider subarrays of length 2: [4, 3], [3, 2], [2, 6].
For each subarray, consider bursting each balloon last and update the DP table.
For len = 3:

Consider subarrays of length 3: [4, 3, 2], [3, 2, 6].
Again, for each subarray, consider bursting each balloon last and update the DP table.
For len = 4 (the full array):

Consider the entire array [4, 3, 2, 6].
For the entire array, consider bursting each balloon last and update the DP table.
By systematically filling the DP table this way, the algorithm ensures that all possible strategies are considered, leading to the optimal solution for the entire array.
 */


 