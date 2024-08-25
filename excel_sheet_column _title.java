/*
 * 
 * 168. Excel Sheet Column Title
 * Easy
 * Topics
 * Companies
 * Given an integer columnNumber, return its corresponding column title as it
 * appears in an Excel sheet.
 * 
 * For example:
 * 
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 
 * 
 * Example 1:
 * 
 * Input: columnNumber = 1
 * Output: "A"
 * Example 2:
 * 
 * Input: columnNumber = 28
 * Output: "AB"
 * Example 3:
 * 
 * Input: columnNumber = 701
 * Output: "ZY"
 * 
 * 
 * Constraints:
 * 
 * 1 <= columnNumber <= 231 - 1
 */

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder columnTitle = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust to zero-indexed
            int remainder = columnNumber % 26;
            columnTitle.append((char) (remainder + 'A'));
            columnNumber /= 26;
        }

        return columnTitle.reverse().toString();
    }
}

/*
 * 
 * Explanation:
 * Adjust to Zero-Indexed:
 * 
 * columnNumber--: This makes the problem easier by converting to zero-indexed.
 * Calculate the Character:
 * 
 * remainder = columnNumber % 26: This gives the current character index.
 * columnTitle.append((char) (remainder + 'A')): Convert the index to the
 * corresponding character and append to the result.
 * Divide and Repeat:
 * 
 * columnNumber /= 26: Move to the next significant "digit".
 * Continue this until all characters are processed.
 * Reverse the Result:
 * 
 * Since we calculate characters from right to left, the final step is to
 * reverse the StringBuilder content.
 * Example:
 * For columnNumber = 1, the output is "A".
 * For columnNumber = 28, the output is "AB".
 * For columnNumber = 701, the output is "ZY".
 * This method efficiently converts any positive integer to its corresponding
 * Excel column title.
 */