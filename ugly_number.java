/*
 * 263. Ugly Number
Easy
Topics
Companies
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.

 

Example 1:

Input: n = 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: n = 1
Output: true
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
Example 3:

Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.
 

Constraints:

-231 <= n <= 231 - 1
 */

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        // Divide by 2, 3, and 5 while possible
        int[] factors = { 2, 3, 5 };
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }

        // If the number is reduced to 1, it's an ugly number
        return n == 1;
    }
}

/*
 * 
 * Approach
 * 
 * 1. if number is smaller than 1 return false
 * 2. check the number is divisible by 2,3,5
 * 3. then if num==1 return true else return false
 */