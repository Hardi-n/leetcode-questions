/*
 * 1937. Maximum Number of Points with Cost
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an m x n integer matrix points (0-indexed). Starting with 0
 * points, you want to maximize the number of points you can get from the
 * matrix.
 * 
 * To gain points, you must pick one cell in each row. Picking the cell at
 * coordinates (r, c) will add points[r][c] to your score.
 * 
 * However, you will lose points if you pick a cell too far from the cell that
 * you picked in the previous row. For every two adjacent rows r and r + 1
 * (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2)
 * will subtract abs(c1 - c2) from your score.
 * 
 * Return the maximum number of points you can achieve.
 * 
 * abs(x) is defined as:
 * 
 * x for x >= 0.
 * -x for x < 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[1,2,3],[1,5,1],[3,1,1]]
 * Output: 9
 * Explanation:
 * The blue cells denote the optimal cells to pick, which have coordinates (0,
 * 2), (1, 1), and (2, 0).
 * You add 3 + 5 + 3 = 11 to your score.
 * However, you must subtract abs(2 - 1) + abs(1 - 0) = 2 from your score.
 * Your final score is 11 - 2 = 9.
 * Example 2:
 * 
 * 
 * Input: points = [[1,5],[2,3],[4,2]]
 * Output: 11
 * Explanation:
 * The blue cells denote the optimal cells to pick, which have coordinates (0,
 * 1), (1, 1), and (2, 0).
 * You add 5 + 3 + 4 = 12 to your score.
 * However, you must subtract abs(1 - 1) + abs(1 - 0) = 1 from your score.
 * Your final score is 12 - 1 = 11.
 * 
 * 
 * Constraints:
 * 
 * m == points.length
 * n == points[r].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 0 <= points[r][c] <= 105
 */

class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length; // Number of rows
        int n = points[0].length; // Number of columns

        // dp array to store the maximum points for the previous row
        long[] dp = new long[n];

        // Initialize dp with the points from the first row
        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }

        // Iterate through the rows starting from the second row
        for (int i = 1; i < m; i++) {
            // Temporary arrays to store maximum values when moving from left to right and
            // right to left
            long[] leftMax = new long[n];
            long[] rightMax = new long[n];
            long[] newDp = new long[n];

            // Compute leftMax array
            leftMax[0] = dp[0];
            for (int j = 1; j < n; j++) {
                leftMax[j] = Math.max(leftMax[j - 1] - 1, dp[j]);
            }

            // Compute rightMax array
            rightMax[n - 1] = dp[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1] - 1, dp[j]);
            }

            // Compute the new dp values for the current row
            for (int j = 0; j < n; j++) {
                newDp[j] = points[i][j] + Math.max(leftMax[j], rightMax[j]);
            }

            // Update dp with newDp for the next row
            dp = newDp;
        }

        // Find the maximum value in the last row
        long result = 0;
        for (long value : dp) {
            result = Math.max(result, value);
        }

        return result;
    }
}

/*
 * Explanation:
 * Initialization:
 * 
 * We start by initializing the dp array with the values from the first row of
 * the points matrix. This represents the maximum points obtainable by starting
 * from any cell in the first row.
 * Left-to-Right and Right-to-Left Traversal:
 * 
 * For each row after the first, we calculate two auxiliary arrays: leftMax and
 * rightMax.
 * leftMax[j] stores the maximum points obtainable if we move from the leftmost
 * column to column j, considering the cost of moving between columns.
 * rightMax[j] stores the maximum points obtainable if we move from the
 * rightmost column to column j, considering the cost of moving between columns.
 * DP Update:
 * 
 * For each cell in the current row, the maximum points are calculated as the
 * sum of the points in the current cell and the maximum of leftMax[j] and
 * rightMax[j].
 * The new DP values (newDp) are stored and then used as the DP array for the
 * next iteration.
 * Final Result:
 * 
 * After processing all the rows, the maximum value in the DP array represents
 * the maximum points that can be obtained.
 */