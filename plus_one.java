/*
 * 66. Plus One
 * Easy
 * Topics
 * Companies
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the ith digit of the integer. The digits are ordered from
 * most significant to least significant in left-to-right order. The large
 * integer does not contain any leading 0's.
 * 
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 * 
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 * 
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * 
 * 
 * Constraints:
 * 
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit and work backwards
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If the digit is 9, set it to 0 and move to the next digit
            digits[i] = 0;
        }

        // If we reached here, it means all digits were 9
        // We need to add an additional digit at the beginning
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}


/*
 * Explanation of the Code:
Loop from the End:

We start looping from the last element (rightmost digit) of the array. If the digit is less than 9, we increment it and return the updated array immediately.
Handling the Digit 9:

If a digit is 9, it becomes 0 because adding 1 to 9 results in 10, which means the current digit should be 0, and we need to carry over 1 to the next digit.
Adding a New Digit:

If all digits are 9 (e.g., 999), after the loop, the array will be all zeros. We need to create a new array of size n+1 with the first element as 1 and the rest as zeros, representing the new number (e.g., 1000).
Return the Result:

The function returns either the modified original array or the new array based on the situation.
 */