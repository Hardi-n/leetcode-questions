/*
 * 1140. Stone Game II
 * Medium
 * Topics
 * Companies
 * Hint
 * Alice and Bob continue their games with piles of stones. There are a number
 * of piles arranged in a row, and each pile has a positive integer number of
 * stones piles[i]. The objective of the game is to end with the most stones.
 * 
 * Alice and Bob take turns, with Alice starting first. Initially, M = 1.
 * 
 * On each player's turn, that player can take all the stones in the first X
 * remaining piles, where 1 <= X <= 2M. Then, we set M = max(M, X).
 * 
 * The game continues until all the stones have been taken.
 * 
 * Assuming Alice and Bob play optimally, return the maximum number of stones
 * Alice can get.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: piles = [2,7,9,4,4]
 * Output: 10
 * Explanation: If Alice takes one pile at the beginning, Bob takes two piles,
 * then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total.
 * If Alice takes two piles at the beginning, then Bob can take all three piles
 * left. In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since
 * it's larger.
 * Example 2:
 * 
 * Input: piles = [1,2,3,4,5,100]
 * Output: 104
 * 
 * 
 * Constraints:
 * 
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 104
 */

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1]; // DP table, where dp[i][M] is the max stones Alice can get starting from index
                                        // i with M
        int[] suffixSum = new int[n]; // Suffix sum array to store the sum of stones from i to the end

        // Build the suffix sum array
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        // Compute the dp table
        for (int i = n - 1; i >= 0; i--) {
            for (int M = 1; M <= n; M++) {
                // If i + 2 * M >= n, Alice can take all remaining piles
                if (i + 2 * M >= n) {
                    dp[i][M] = suffixSum[i];
                } else {
                    for (int X = 1; X <= 2 * M; X++) {
                        dp[i][M] = Math.max(dp[i][M], suffixSum[i] - dp[i + X][Math.max(M, X)]);
                    }
                }
            }
        }

        return dp[0][1]; // Return the result starting from index 0 with M = 1
    }
}

/*
 * Dynamic Programming Approach
 * State Representation:
 * 
 * Let dp[i][M] represent the maximum number of stones Alice can collect
 * starting from the i-th pile with the current value of M.
 * We will iterate backward from the last pile to the first one to calculate the
 * DP table.
 * Transition:
 * 
 * On Alice's turn, she can pick X piles, where 1 <= X <= 2M. We need to
 * evaluate all possible values of X and update dp[i][M].
 * The new value of M after taking X piles will be max(M, X).
 * Goal:
 * 
 * The goal is to compute dp[0][1], which gives us the maximum number of stones
 * Alice can collect when starting from the first pile with M = 1.
 */





 
/*
 * 
 * Explanation of the Code
 * Suffix Sum Array (suffixSum): This array is used to quickly calculate the
 * total stones remaining from a certain pile onward. For example, suffixSum[i]
 * gives the sum of all piles from index i to the end.
 * 
 * DP Table (dp):
 * 
 * dp[i][M] represents the maximum number of stones Alice can collect starting
 * from pile i with the value M.
 * If Alice can take all remaining stones (i + 2 * M >= n), then dp[i][M] =
 * suffixSum[i].
 * Otherwise, for each possible X Alice can pick, we calculate the remaining
 * stones after Bob plays optimally and update dp[i][M] accordingly.
 * Final Result: The result is stored in dp[0][1], which represents the maximum
 * number of stones Alice can collect starting from the first pile with M = 1.
 * 
 * Example Walkthrough
 * For the input piles = [2, 7, 9, 4, 4]:
 * 
 * If Alice picks the first pile (2 stones), Bob will pick the next two piles (7
 * and 9 stones), leaving Alice with the last two piles (4 and 4 stones). In
 * this scenario, Alice gets 2 + 4 + 4 = 10 stones.
 * If Alice picks the first two piles (2 and 7 stones), Bob can pick the
 * remaining piles (9, 4, 4 stones), leaving Alice with just 9 stones.
 * The optimal strategy for Alice is to pick the first pile, as it results in
 * the maximum number of stones (10 stones).
 * This approach ensures that Alice always plays optimally, considering both her
 * and Bob's future moves.
 */