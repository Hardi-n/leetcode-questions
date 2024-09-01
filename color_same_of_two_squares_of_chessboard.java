/*
 * Q1. Check if Two Chessboard Squares Have the Same Color
 * Easy
 * 3 pt.
 * You are given two strings, coordinate1 and coordinate2, representing the
 * coordinates of a square on an 8 x 8 chessboard.
 * 
 * Below is the chessboard for reference.
 * 
 * 
 * 
 * Return true if these two squares have the same color and false otherwise.
 * 
 * The coordinate will always represent a valid chessboard square. The
 * coordinate will always have the letter first (indicating its column), and the
 * number second (indicating its row).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: coordinate1 = "a1", coordinate2 = "c3"
 * 
 * Output: true
 * 
 * Explanation:
 * 
 * Both squares are black.
 * 
 * Example 2:
 * 
 * Input: coordinate1 = "a1", coordinate2 = "h3"
 * 
 * Output: false
 * 
 * Explanation:
 * 
 * Square "a1" is black and "h3" is white.
 * 
 * 
 * 
 * Constraints:
 * 
 * coordinate1.length == coordinate2.length == 2
 * 'a' <= coordinate1[0], coordinate2[0] <= 'h'
 * '1' <= coordinate1[1], coordinate2[1] <= '8'
 */

class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        // Convert the column character to an integer: 'a' -> 1, 'b' -> 2, ..., 'h' -> 8
        int col1 = coordinate1.charAt(0) - 'a' + 1;
        int row1 = coordinate1.charAt(1) - '0';

        int col2 = coordinate2.charAt(0) - 'a' + 1;
        int row2 = coordinate2.charAt(1) - '0';

        // Check if the sum of row and column indices for both squares have the same
        // parity (even or odd)
        return (col1 + row1) % 2 == (col2 + row2) % 2;
    }
}

/*
 * 
 * 
 * A chessboard has alternating colors. If you consider the rows and columns,
 * the color of a square is determined by whether the sum of the row index and
 * column index is even or odd.
 * If the sum of the indices for both squares is either both even or both odd,
 * the squares are the same color. Otherwise, they are different colors.
 */

/*
 * Explanation:
 * Column Conversion: square1.charAt(0) - 'a' + 1 converts the column character
 * ('a'-'h') into a number (1-8).
 * Row Conversion: square1.charAt(1) - '0' converts the row character ('1'-'8')
 * directly into a number (1-8).
 * Color Check: The sum of the row and column indices modulo 2 determines the
 * color. If both squares have the same modulo result, they share the same
 * color.
 * 
 */