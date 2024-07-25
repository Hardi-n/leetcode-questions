/*
 * 
 * 367. Valid Perfect Square
 * Easy
 * Topics
 * Companies
 * Given a positive integer num, return true if num is a perfect square or false
 * otherwise.
 * 
 * A perfect square is an integer that is the square of an integer. In other
 * words, it is the product of some integer with itself.
 * 
 * You must not use any built-in library function, such as sqrt.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = 16
 * Output: true
 * Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
 * Example 2:
 * 
 * Input: num = 14
 * Output: false
 * Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an
 * integer.
 * 
 * 
 * Constraints:
 * 
 * 1 <= num <= 231 - 1
 */



 class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}


/*
 * 
 * Approach
 * 1. check if the given number is less than zero then return null
 * 2. get integer sqrt of a number using math.sqrt 
 * 3. then return (sqrt*sqrt==num) which will return the boolean result 
 */