/*
 * 400. Nth Digit
 * Medium
 * Topics
 * Companies
 * Given an integer n, return the nth digit of the infinite integer sequence [1,
 * 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3
 * Output: 3
 * Example 2:
 * 
 * Input: n = 11
 * Output: 0
 * Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
 * 11, ... is a 0, which is part of the number 10.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 231 - 1
 */


 class Solution {
    public int findNthDigit(int n) {
        long start = 1;
        long length = 1;
        long count = 9;

        // Determine the range where the nth digit is located
        while (n > length * count) {
            n -= length * count;
            length++;
            count *= 10;
            start *= 10;
        }

        // Determine the exact number where the nth digit is located
        start += (n - 1) / length;
        String s = Long.toString(start);
        // Cast (n - 1) and length to int to avoid the incompatible types error
        return Character.getNumericValue(s.charAt((int)((n - 1) % length)));
    }
}


/*
 * 
 * Step-by-Step Explanation
Initialization:

java
Copy code
long start = 1;
long length = 1;
long count = 9;
start represents the smallest number in the current range of numbers being considered.
length represents the number of digits in the numbers of the current range.
count represents the total number of digits contributed by the numbers in the current range.
Determine the Range:

java
Copy code
while (n > length * count) {
    n -= length * count;
    length++;
    count *= 10;
    start *= 10;
}
This loop identifies the range of numbers where the nth digit is located. It does this by reducing n by the total number of digits in each range until n falls within the range of numbers with the same number of digits.
For example, if n is larger than the total number of digits in the range of single-digit numbers, the loop will reduce n by 9 (1 digit * 9 numbers), then proceed to the next range (two-digit numbers), and so on.
Find the Exact Number:

java
Copy code
start += (n - 1) / length;
After the loop, start is updated to the exact number where the nth digit is located.
(n - 1) / length calculates the offset within the current range of numbers to find the specific number.
Convert Number to String:

java
Copy code
String s = Long.toString(start);
The number is converted to a string to access its digits easily.
Find and Return the Digit:

java
Copy code
return Character.getNumericValue(s.charAt((int)((n - 1) % length)));
(n - 1) % length calculates the position of the digit within the number.
charAt retrieves the character at this position.
Character.getNumericValue converts the character to its numeric value.
The result is the nth digit.
Example Walkthrough
Let's go through an example to see how this works.

Example 1:
Input: n = 11
Initialization:

java
Copy code
long start = 1;
long length = 1;
long count = 9;
Determine the Range:

java
Copy code
while (n > length * count) {
    n -= length * count;
    length++;
    count *= 10;
    start *= 10;
}
First iteration: n = 11, length = 1, count = 9
11 > 1 * 9, so update:
n -= 9 → n = 2
length++ → length = 2
count *= 10 → count = 90
start *= 10 → start = 10
Now 2 <= 2 * 90, so exit the loop.
Find the Exact Number:

java
Copy code
start += (n - 1) / length;
start += (2 - 1) / 2 → start += 0 → start = 10
Convert Number to String:

java
Copy code
String s = Long.toString(start);
s = "10"
Find and Return the Digit:

java
Copy code
return Character.getNumericValue(s.charAt((int)((n - 1) % length)));
(n - 1) % length → (2 - 1) % 2 → 1
s.charAt(1) → '0'
Character.getNumericValue('0') → 0
Return 0
Therefore, the 11th digit in the concatenated sequence is 0.
 */