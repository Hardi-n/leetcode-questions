/*
 * 
 * 171. Excel Sheet Column Number
Easy
Topics
Companies
Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
 

Constraints:

1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].
 */



 class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            int value = c - 'A' + 1;
            result = result * 26 + value;
        }
        return result;
    }
}


/*
 * titleToNumber Method:

    1.The method takes a string columnTitle as input and returns the corresponding column number.

    2.Initialize result to 0.

    3.Iterate over each character of the string:
        ->  Convert the character to its corresponding value (where 'A' is 1, 'B' is 2, ..., 'Z' is 26).
        ->  Update result using the formula result = result * 26 + value.
 */