/*
 * 
 * 650. 2 Keys Keyboard
 * Medium
 * Topics
 * Companies
 * Hint
 * There is only one character 'A' on the screen of a notepad. You can perform
 * one of two operations on this notepad for each step:
 * 
 * Copy All: You can copy all the characters present on the screen (a partial
 * copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * Given an integer n, return the minimum number of operations to get the
 * character 'A' exactly n times on the screen.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: Initially, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * Example 2:
 * 
 * Input: n = 1
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 1000
 */

class Solution {
    public int minSteps(int n) {
        // If n is 1, we don't need any operations.
        if (n == 1) {
            return 0;
        }

        // dp[i] will hold the minimum number of steps to get i 'A's.
        int[] dp = new int[n + 1];
        
        // Initialize dp[1] = 0 because we already start with one 'A'
        dp[1] = 0;

        // Fill dp array for each number of 'A's from 2 to n
        for (int i = 2; i <= n; i++) {
            dp[i] = i; // Maximum steps could be i (all pastes)
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i / j); // Add steps to get j and paste (i/j - 1) times
                    break;
                }
            }
        }
        return dp[n];--
    }
}

/*
 * 
 * Explanation:
 * Base Case: dp[1] = 0 because no operations are needed if you already have one
 * 'A'.
 * 
 * Iterative DP:
 * 
 * For each i from 2 to n, initialize dp[i] = i because in the worst case, you
 * can reach i by copying and pasting one 'A' i-1 times.
 * For each divisor j of i, calculate the number of operations needed to reach i
 * from j. If i % j == 0, it means you can get i by copying j and pasting (i/j)
 * times. The minimum operations to reach i will be dp[j] + (i/j).
 * Optimization: The loop for checking divisors runs backward from i-1 to 2,
 * ensuring that you find the smallest divisor first and break early.
 * 
 * 
 * 
 * Qoution explaination ------------------------>>>>>>>>>>>>>>>>>>>>>.
 * 
 * 
 * 
 * The problem is about determining the minimum number of operations needed to
 * get exactly n 'A's on a screen, starting with just one 'A'. You can only
 * perform two operations:
 * 
 * Copy All: Copies all the 'A's currently on the screen.
 * Paste: Pastes the copied 'A's onto the screen.
 * The challenge is to find the minimum sequence of these operations to reach
 * exactly n 'A's.
 * 
 * Example:
 * Example 1:
 * For n = 3, the minimum operations would be:
 * 
 * Start with one 'A':
 * Screen: "A"
 * Copy All (1 operation):
 * Copied: "A"
 * Screen: "A"
 * Paste (1 operation):
 * Screen: "AA"
 * Paste (1 operation):
 * Screen: "AAA"
 * Total operations: 3 (Copy All + Paste + Paste)
 * 
 * Example 2:
 * For n = 4, the minimum operations would be:
 * 
 * Start with one 'A':
 * Screen: "A"
 * Copy All (1 operation):
 * Copied: "A"
 * Screen: "A"
 * Paste (1 operation):
 * Screen: "AA"
 * Copy All (1 operation):
 * Copied: "AA"
 * Screen: "AA"
 * Paste (1 operation):
 * Screen: "AAAA"
 * Total operations: 4 (Copy All + Paste + Copy All + Paste)
 * 
 * Key Idea:
 * The goal is to strategically copy and paste to minimize the total number of
 * operations.
 * For example, in the case of n = 4, you realize that copying after reaching
 * "AA" is more efficient than pasting one 'A' at a time.
 */