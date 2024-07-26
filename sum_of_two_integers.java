/*
 * 371. Sum of Two Integers
 * Medium
 * Topics
 * Companies
 * Given two integers a and b, return the sum of the two integers without using
 * the operators + and -.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 * 
 * Input: a = 2, b = 3
 * Output: 5
 * 
 * 
 * Constraints:
 * 
 * -1000 <= a, b <= 1000
 */



 class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // carry now contains common set bits of a and b
            int carry = a & b;

            // sum of bits of a and b where at least one of the bits is not set
            a = a ^ b;

            // carry is shifted by one so that adding it to a gives the required sum
            b = carry << 1;
        }
        return a;

    }
}

/*
 * 
 * 
 * Approach
 * 
 * 1. start the while loop till b!= 0
 * 2. store carry using & operator (bitwise and)
 * 3. store sum back into a using ^ operator (bitwise XOR)
 * 4. The carry is then left-shifted by one (carry << 1) to add it to the next higher bit position in the next iteration.
 * 5. The loop continues until b becomes 0, indicating there are no more carry bits left.
 */