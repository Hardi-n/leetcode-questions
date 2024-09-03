/*
 * 633. Sum of Square Numbers
 * Medium
 * Topics
 * Companies
 * Given a non-negative integer c, decide whether there're two integers a and b
 * such that a2 + b2 = c.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 * 
 * Input: c = 3
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 0 <= c <= 231 - 1
 */

class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c); // start with the largest possible value for b

        while (left <= right) {
            int sum = left * left + right * right;

            if (sum == c) {
                return true; // Found a and b such that a^2 + b^2 = c
            } else if (sum < c) {
                left++; // Increase a to increase the sum
            } else {
                right--; // Decrease b to decrease the sum
            }
        }

        return false; // No such pair found
    }
}

/*
 * 
 * How the code works:
 * Initialization:
 * 
 * left is initialized to 0 (representing
 * 𝑎
 * a).
 * right is initialized to
 * 𝑐
 * c
 * ​
 * (representing
 * 𝑏
 * b) because
 * 𝑏
 * 2
 * b
 * 2
 * should be less than or equal to
 * 𝑐
 * c.
 * Loop:
 * 
 * The loop continues as long as left is less than or equal to right.
 * Calculate sum = left * left + right * right.
 * If sum equals
 * 𝑐
 * c, then
 * 𝑎
 * =
 * 𝑙
 * 𝑒
 * 𝑓
 * 𝑡
 * a=left and
 * 𝑏
 * =
 * 𝑟
 * 𝑖
 * 𝑔
 * ℎ
 * 𝑡
 * b=right satisfy the equation
 * 𝑎
 * 2
 * +
 * 𝑏
 * 2
 * =
 * 𝑐
 * a
 * 2
 * +b
 * 2
 * =c, and the method returns true.
 * If sum is less than
 * 𝑐
 * c, increment left to increase the sum.
 * If sum is greater than
 * 𝑐
 * c, decrement right to decrease the sum.
 * Conclusion:
 * 
 * If the loop completes without finding such a pair, the method returns false,
 * indicating that
 * 𝑐
 * c cannot be expressed as the sum of two squares.
 */