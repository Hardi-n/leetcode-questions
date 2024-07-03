/*
 * 
 * 172. Factorial Trailing Zeroes
Medium
Topics
Companies
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

 

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 104
 
 
*/



class Solution {
    public int trailingZeroes(int n) {
        long result = factorialIterative(n);
        int returningvariable = countTrailingZeros(result);
        return returningvariable;
    }
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static int countTrailingZeros(long n) {
        int count = 0;
        // Continue dividing by 10 until the number is no longer divisible by 10
        while (n % 10 == 0 && n != 0) {
            count++;
            n /= 10;
        }
        return count;
    }
}



/*
 * Approach
 * 
 * 1. firstly calculate the factorial of a number
 * 2. calculate trailing zeros by checking how many times a number can be divided by 10
 * 3. return the result
 */