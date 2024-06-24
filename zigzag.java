/*
 * 6. Zigzag Conversion
Medium
Topics
Companies
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */



 class Solution {
    public String convert(String s, int numRows) {
        // If numRows is 1, return the original string
        if (numRows == 1) {
            return s;
        }

        // Create an array of StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse each character in the input string
        for (char c : s.toCharArray()) {
            // Append the current character to the current row's StringBuilder
            rows[currentRow].append(c);

            // If we're at the top or bottom row, reverse direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Update currentRow based on the direction
            currentRow += goingDown ? 1 : -1;
        }

        // Concatenate all rows to form the final result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}




/*
 * Explanation of the Approach
1.Initialization:
    If numRows is 1, the zigzag pattern is just the original string since there's only one row. Return the original string in this case.
    Create an array of StringBuilder objects, where each StringBuilder represents a row in the zigzag pattern.

2.Iteration Through the String:
    We will use two variables: currentRow to keep track of the current row index and goingDown to determine the direction of movement (either downwards or upwards in the zigzag pattern).
    Traverse each character in the input string:
    Append the character to the StringBuilder corresponding to the currentRow.
    If the currentRow is at the top (0) or bottom (numRows - 1), reverse the direction (goingDown = !goingDown).
    Update the currentRow based on the direction (increment if going down, decrement if going up).

3.Construct the Final Result:
    After populating the StringBuilder rows, concatenate all the rows to form the final result string.
 */