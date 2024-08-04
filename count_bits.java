/*
 * 338. Counting Bits
 * Easy
 * Topics
 * Companies
 * Hint
 * Given an integer n, return an array ans of length n + 1 such that for each i
 * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 * 
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * 
 * 
 * Constraints:
 * 
 * 0 <= n <= 105
 */


 class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;       
    }
}


/*
 * 
To solve the problem of counting the number of 1 bits in the binary representation of each number from 0 to n, you can use the following dynamic programming approach. Here is the complete implementation in Java:

java
Copy code
class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
Explanation:
Initialization:

Create an array result of size n + 1 to store the number of 1 bits for each number from 0 to n.
Dynamic Programming Relation:

For each number i, the number of 1 bits can be derived from the number of 1 bits in i >> 1 (which is i divided by 2) plus the least significant bit of i (which is i & 1).
Loop through 1 to n:

For each number i from 1 to n, calculate result[i] using the formula: result[i] = result[i >> 1] + (i & 1).
Example:
For n = 5:

i = 1: result[1] = result[1 >> 1] + (1 & 1) = result[0] + 1 = 0 + 1 = 1
i = 2: result[2] = result[2 >> 1] + (2 & 1) = result[1] + 0 = 1 + 0 = 1
i = 3: result[3] = result[3 >> 1] + (3 & 1) = result[1] + 1 = 1 + 1 = 2
i = 4: result[4] = result[4 >> 1] + (4 & 1) = result[2] + 0 = 1 + 0 = 1
i = 5: result[5] = result[5 >> 1] + (5 & 1) = result[2] + 1 = 1 + 1 = 2
The final result array will be [0, 1, 1, 2, 1, 2], which gives the number of 1 bits in the binary representation of each number from 0 to 5.
 */