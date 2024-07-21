/*
 * 326. Power of Three
 * Easy
 * Topics
 * Companies
 * Given an integer n, return true if it is a power of three. Otherwise, return
 * false.
 * 
 * An integer n is a power of three, if there exists an integer x such that n ==
 * 3x.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 27
 * Output: true
 * Explanation: 27 = 33
 * Example 2:
 * 
 * Input: n = 0
 * Output: false
 * Explanation: There is no x where 3x = 0.
 * Example 3:
 * 
 * Input: n = -1
 * Output: false
 * Explanation: There is no x where 3x = (-1).
 * 
 * 
 * Constraints:
 * 
 * -231 <= n <= 231 - 1
 */

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}

/*
 * 
 * Approach with example
 * 
 * Initial Check:
 * 
 * java
 * Copy code
 * if (n <= 0) {
 * return false;
 * }
 * This line checks if
 * 𝑛
 * n is less than or equal to 0. If it is, the function immediately returns
 * false because negative numbers and zero cannot be powers of 3.
 * Loop:
 * 
 * java
 * Copy code
 * while (n % 3 == 0) {
 * n /= 3;
 * }
 * This loop continues to divide
 * 𝑛
 * n by 3 as long as
 * 𝑛
 * n is divisible by 3 (i.e., the remainder of
 * 𝑛
 * n divided by 3 is 0).
 * After each division,
 * 𝑛
 * n is updated to the result of the division.
 * Final Check:
 * 
 * java
 * Copy code
 * return n == 1;
 * After exiting the loop, the function checks if
 * 𝑛
 * n has been reduced to 1. If it has, then the original
 * 𝑛
 * n was a power of 3, and the function returns true. Otherwise, it returns
 * false.
 * Examples
 * Example 1:
 * 𝑛
 * =
 * 27
 * n=27
 * Initial check:
 * 27
 * >
 * 0
 * 27>0 (pass)
 * Loop:
 * 27
 * %
 * 3
 * =
 * =
 * 0
 * 27%3==0 (true), so
 * 27
 * /
 * 3
 * =
 * 9
 * 27/3=9
 * 9
 * %
 * 3
 * =
 * =
 * 0
 * 9%3==0 (true), so
 * 9
 * /
 * 3
 * =
 * 3
 * 9/3=3
 * 3
 * %
 * 3
 * =
 * =
 * 0
 * 3%3==0 (true), so
 * 3
 * /
 * 3
 * =
 * 1
 * 3/3=1
 * Now
 * 1
 * %
 * 3
 * ≠
 * 0
 * 1%3
 * 
 * =0, exit loop
 * Final check:
 * 1
 * =
 * =
 * 1
 * 1==1 (true)
 * Return: true
 * Example 2:
 * 𝑛
 * =
 * 10
 * n=10
 * Initial check:
 * 10
 * >
 * 0
 * 10>0 (pass)
 * Loop:
 * 10
 * %
 * 3
 * ≠
 * 0
 * 10%3
 * 
 * =0, exit loop
 * Final check:
 * 10
 * ≠
 * 1
 * 10
 * 
 * =1 (false)
 * Return: false
 * Example 3:
 * 𝑛
 * =
 * 0
 * n=0
 * Initial check:
 * 0
 * ≤
 * 0
 * 0≤0 (fail)
 * Return: false
 * Example 4:
 * 𝑛
 * =
 * −
 * 3
 * n=−3
 * Initial check:
 * −
 * 3
 * ≤
 * 0
 * −3≤0 (fail)
 * Return: false
 * Example 5:
 * 𝑛
 * =
 * 1
 * n=1
 * Initial check:
 * 1
 * >
 * 0
 * 1>0 (pass)
 * Loop:
 * 1
 * %
 * 3
 * ≠
 * 0
 * 1%3
 * 
 * =0, exit loop
 * Final check:
 * 1
 * =
 * =
 * 1
 * 1==1 (true)
 * Return: true
 * 
 * 
 */