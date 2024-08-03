/*
 * 405. Convert a Number to Hexadecimal
 * Easy
 * Topics
 * Companies
 * Given an integer num, return a string representing its hexadecimal
 * representation. For negative integers, two’s complement method is used.
 * 
 * All the letters in the answer string should be lowercase characters, and
 * there should not be any leading zeros in the answer except for the zero
 * itself.
 * 
 * Note: You are not allowed to use any built-in library method to directly
 * solve this problem.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = 26
 * Output: "1a"
 * Example 2:
 * 
 * Input: num = -1
 * Output: "ffffffff"
 * 
 * 
 * Constraints:
 * 
 * -231 <= num <= 231 - 1
 */




 class Solution {
    public String toHex(int num) {
        String hex = Integer.toHexString(num);
        // System.out.println("Hexadecimal representation: " + hex);
        return hex;
    }
}
/*
 * Explanation
 * Integer.toHexString(number):
 * This method converts an integer to a string representation of its hexadecimal
 * value.
 * For example, 255 will be converted to "ff".
 * Custom Implementation
 * If you want to implement the conversion manually, you can do so by repeatedly
 * dividing the number by 16 and keeping track of the remainders.
 */