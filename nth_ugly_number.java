/*
 * 264. Ugly Number II
 * Medium
 * Topics
 * Companies
 * Hint
 * An ugly number is a positive integer whose prime factors are limited to 2, 3,
 * and 5.
 * 
 * Given an integer n, return the nth ugly number.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10
 * ugly numbers.
 * Example 2:
 * 
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are
 * limited to 2, 3, and 5.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 1690
 */

class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        // Initialize the array to store ugly numbers
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        // Initialize pointers for multiples of 2, 3, and 5
        int i2 = 0, i3 = 0, i5 = 0;

        // Initialize the next values for multiples of 2, 3, and 5
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; i++) {
            // Find the minimum of next2, next3, and next5
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            uglyNumbers[i] = nextUgly;

            // Update pointers and next values
            if (nextUgly == next2) {
                i2++;
                next2 = uglyNumbers[i2] * 2;
            }
            if (nextUgly == next3) {
                i3++;
                next3 = uglyNumbers[i3] * 3;
            }
            if (nextUgly == next5) {
                i5++;
                next5 = uglyNumbers[i5] * 5;
            }
        }

        return uglyNumbers[n - 1];
    }
}

/*
 * Key Components
 * Initialization:
 * 
 * uglyNumbers array: This array stores the ugly numbers in order. The first
 * ugly number is set to 1 because 1 is considered an ugly number by definition.
 * i2, i3, i5: Pointers used to track the position in the uglyNumbers array for
 * which the next multiple of 2, 3, and 5 should be calculated.
 * next2, next3, next5: Variables to store the next potential ugly numbers by
 * multiplying the numbers at the pointers i2, i3, and i5 with 2, 3, and 5,
 * respectively.
 * Generating Ugly Numbers:
 * 
 * Loop through: The loop runs from 1 to n-1 because the first ugly number
 * (uglyNumbers[0]) is already initialized.
 * Find the smallest next ugly number:
 * nextUgly is the smallest number among next2, next3, and next5. This ensures
 * that the next ugly number is correctly selected.
 * Update the uglyNumbers array:
 * uglyNumbers[i] is set to nextUgly, which is the next ugly number.
 * Update pointers and next values:
 * If nextUgly equals next2, increment i2 and calculate the next potential value
 * for next2 by multiplying uglyNumbers[i2] by 2.
 * Similarly, if nextUgly equals next3, increment i3 and calculate the next
 * potential value for next3.
 * If nextUgly equals next5, increment i5 and calculate the next potential value
 * for next5.
 * Return the Result:
 * 
 * After exiting the loop, uglyNumbers[n - 1] contains the n-th ugly number,
 * which is returned.
 * Example
 * Let's walk through a quick example with n = 10:
 * 
 * Initialization:
 * 
 * uglyNumbers[0] is 1.
 * Pointers: i2 = 0, i3 = 0, i5 = 0.
 * Next values: next2 = 2, next3 = 3, next5 = 5.
 * Loop Execution:
 * 
 * Iteration 1:
 * nextUgly is 2 (smallest of 2, 3, 5).
 * uglyNumbers[1] = 2.
 * Update i2 to 1, next2 to 4 (since 2 * 2 = 4).
 * Iteration 2:
 * nextUgly is 3.
 * uglyNumbers[2] = 3.
 * Update i3 to 1, next3 to 6 (since 3 * 2 = 6).
 * Continue this process until the 10th ugly number is computed.
 */