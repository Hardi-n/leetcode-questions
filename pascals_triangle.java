/*
 * 118. Pascal's Triangle
 * Easy
 * Topics
 * Companies
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * 
 * Input: numRows = 1
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= numRows <= 30
 */


 class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> triangle = new ArrayList<>();

        // Base case; first row is always [1]
        if (numRows <= 0) {
            return triangle;
        }

        // First row
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // Fill the triangle row by row
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);

            // First element in the row is always 1
            row.add(1);

            // Each element in the middle is the sum of the two elements above it
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element in the row is always 1
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}



/*
 * 
 * Approach
 * 
 * 
 * 1. generate(int numRows) Method:
This method generates Pascal's Triangle with a specified number of rows (numRows).

Input: int numRows - the number of rows you want to generate for Pascal's Triangle.
Output: A List<List<Integer>> representing the triangle, where each inner list is a row of the triangle.
Step-by-Step Breakdown:
Initialization:

List<List<Integer>> triangle = new ArrayList<>(); creates a list to hold each row of the triangle.
Base Case:

If numRows is less than or equal to 0, an empty list is returned. This handles edge cases where no rows are requested.
First Row:

The first row of Pascal's Triangle is always [1], so it's added manually using triangle.add(new ArrayList<>()); and triangle.get(0).add(1);.
Generating the Triangle:

A loop runs from 1 to numRows - 1 to generate each subsequent row.
Row Initialization:
List<Integer> row = new ArrayList<>(); creates a new list for the current row.
The first element is always 1, so row.add(1); is called.
Middle Elements:
For each element in the middle of the row, the value is the sum of the two elements directly above it from the previous row.
This is done using row.add(prevRow.get(j - 1) + prevRow.get(j));, where prevRow is the previous row in the triangle.
Last Element:
The last element is always 1, so row.add(1); is added at the end.
The newly generated row is added to the triangle with triangle.add(row);.
Return Value:

The complete triangle is returned as a list of lists.
 */