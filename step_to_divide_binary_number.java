/*
 * 1404. Number of Steps to Reduce a Number in Binary Representation to One
Medium
Topics
Companies
Hint
Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:

If the current number is even, you have to divide it by 2.

If the current number is odd, you have to add 1 to it.

It is guaranteed that you can always reach one for all test cases.

 

Example 1:

Input: s = "1101"
Output: 6
Explanation: "1101" corressponds to number 13 in their decimal representation.
Step 1) 13 is odd, add 1 and obtain 14. 
Step 2) 14 is even, divide by 2 and obtain 7.
Step 3) 7 is odd, add 1 and obtain 8.
Step 4) 8 is even, divide by 2 and obtain 4.  
Step 5) 4 is even, divide by 2 and obtain 2. 
Step 6) 2 is even, divide by 2 and obtain 1.  
Example 2:

Input: s = "10"
Output: 1
Explanation: "10" corresponds to number 2 in their decimal representation.
Step 1) 2 is even, divide by 2 and obtain 1.  
Example 3:

Input: s = "1"
Output: 0
 

Constraints:

1 <= s.length <= 500
s consists of characters '0' or '1'
s[0] == '1'
 */




 class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        // Start from the end of the string (least significant bit)
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0' + carry;

            if (bit == 1) {
                // If the bit is 1 (odd), it will become even by adding 1
                steps += 2; // One step for addition, one step for division by 2
                carry = 1;  // Carry over the 1 to the next bit
            } else {
                // If the bit is 0 (even), it will just be divided by 2
                steps += 1;
            }
        }

        // Handle the most significant bit
        return steps + carry;
    }
}






/*
 * Loop through the string:

Start from the end (least significant bit) and move to the beginning (most significant bit).
Check each bit:

If the bit is 1 (odd), increment the steps by 2 (one for addition, one for division by 2).
Set the carry to 1, because adding 1 to an odd number will produce an even number, and a carry will affect the next bit.
If the bit is 0 (even), just increment the steps by 1 for the division by 2.
Handle the most significant bit:

After the loop, add the carry to the total steps. If there was a carry left after processing all bits, it means we had an odd number that needed to be incremented at the start.
 */