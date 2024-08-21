/*
 * 120. Triangle
 * Medium
 * Topics
 * Companies
 * Given a triangle array, return the minimum path sum from top to bottom.
 * 
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are on index i on the current row, you may move to either
 * index i or index i + 1 on the next row.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined
 * above).
 * Example 2:
 * 
 * Input: triangle = [[-10]]
 * Output: -10
 * 
 * 
 * Constraints:
 * 
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * 
 * 
 * 
 */


 class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Start from the second-to-last row and move upwards
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // Choose the minimum of the two paths from the row below
                int minPath = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                // Add the minimum path sum to the current element
                triangle.get(i).set(j, triangle.get(i).get(j) + minPath);
            }
        }
        // The top element now contains the minimum path sum
        return triangle.get(0).get(0);
    }
}


/*
 * 
 * Explanation of the Code
Triangle Traversal: We start from the second-to-last row (triangle.size() - 2) and iterate upwards (i--), ensuring that we consider all elements in each row.

Minimum Path Calculation: For each element in the current row, we calculate the minimum of the two possible paths to the row below (triangle.get(i + 1).get(j) and triangle.get(i + 1).get(j + 1)). We add this minimum to the current element.

In-Place Update: The current element is updated to reflect the minimum path sum up to that point. This allows us to store the result directly in the input triangle, saving space.

Final Result: After processing all rows, the top element (triangle.get(0).get(0)) contains the minimum path sum for the entire triangle.

Example Walkthrough
For the input triangle:

csharp
Copy code
[
     [2],
    [3, 4],
   [6, 5, 7],
  [4, 1, 8, 3]
]
Start from the bottom row [4, 1, 8, 3].
Moving up to the second-to-last row [6, 5, 7]:
For 6: min(4, 1) + 6 = 7
For 5: min(1, 8) + 5 = 6
For 7: min(8, 3) + 7 = 10
Continue up to [3, 4]:
For 3: min(7, 6) + 3 = 9
For 4: min(6, 10) + 4 = 10
Finally, for the top row [2]:
2 + min(9, 10) = 11
Thus, the minimum path sum is 11.
 */


/*
 * Approach
 * Dynamic Programming (Bottom-Up Approach):
 * 
 * Start from the bottom of the triangle and move upwards.
 * For each element, consider the two possible paths to the row below and take
 * the minimum.
 * Update the current element to store the minimum path sum to that point.
 * By the time you reach the top, the top element will contain the minimum path
 * sum for the entire triangle.
 * In-place Modification:
 * 
 * To save space, modify the input triangle directly to store the minimum path
 * sum.
 */