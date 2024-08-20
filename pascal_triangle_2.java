/*
 * 119. Pascal's Triangle II
 * Easy
 * Topics
 * Companies
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the
 * Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 * 
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 * 
 * Input: rowIndex = 1
 * Output: [1,1]
 * 
 * 
 * Constraints:
 * 
 * 0 <= rowIndex <= 33
 * 
 */






 class Solution {
    public List<Integer> getRow(int rowIndex) {
       List<List<Integer>> triangle = new ArrayList<>();

        // First row initialization
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // Build the triangle row by row
        for (int i = 1; i <= rowIndex; i++) {
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

        return triangle.get(rowIndex);
    }
}










/*
 * 
 * Approach
 * 
 * 1. created one triangle 2d arraylist of integers
 * 2. firsly add 1 in the first row
 * 3. get the previous row using getfunction(i-1);
 * 4. add the next row elements using previous one's
 * 5. after creating the triangle return the last row 
 * 
 */