/*
 * 
 * 624. Maximum Distance in Arrays
 * Medium
 * Topics
 * Companies
 * You are given m arrays, where each array is sorted in ascending order.
 * 
 * You can pick up two integers from two different arrays (each array picks one)
 * and calculate the distance. We define the distance between two integers a and
 * b to be their absolute difference |a - b|.
 * 
 * Return the maximum distance.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arrays = [[1,2,3],[4,5],[1,2,3]]
 * Output: 4
 * Explanation: One way to reach the maximum distance 4 is to pick 1 in the
 * first or third array and pick 5 in the second array.
 * Example 2:
 * 
 * Input: arrays = [[1],[1]]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * m == arrays.length
 * 2 <= m <= 105
 * 1 <= arrays[i].length <= 500
 * -104 <= arrays[i][j] <= 104
 * arrays[i] is sorted in ascending order.
 * There will be at most 105 integers in all the arrays.
 */

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // Initialize the global minimum and maximum with the first array's elements
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        // Initialize the maximum distance to 0
        int maxDistance = 0;

        // Iterate through the rest of the arrays
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);

            // Calculate the maximum distance considering the current array
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - min));
            maxDistance = Math.max(maxDistance, Math.abs(max - currentMin));

            // Update the global minimum and maximum
            min = Math.min(min, currentMin);
            max = Math.max(max, currentMax);
        }

        return maxDistance;
    }
}

/*
 * 
 * Step-by-Step Explanation:
 * Initialization:
 * 
 * The code starts by initializing two variables, min and max, to store the
 * minimum and maximum values of the first array in the list.
 * min = arrays.get(0).get(0); stores the first element of the first array (the
 * minimum value in a sorted array).
 * max = arrays.get(0).get(arrays.get(0).size() - 1); stores the last element of
 * the first array (the maximum value in a sorted array).
 * The variable maxDistance is initialized to 0. This will store the maximum
 * distance found as the program iterates through the arrays.
 * Iterate Through the Rest of the Arrays:
 * 
 * The for loop starts from the second array (i = 1) and iterates through the
 * rest of the arrays in the list.
 * For each array (currentArray), it calculates:
 * currentMin = currentArray.get(0); - the first element, which is the smallest
 * in that sorted array.
 * currentMax = currentArray.get(currentArray.size() - 1); - the last element,
 * which is the largest in that sorted array.
 * Calculate Maximum Distance:
 * 
 * Inside the loop, the code computes two possible maximum distances using the
 * current array:
 * maxDistance = Math.max(maxDistance, Math.abs(currentMax - min));:
 * This calculates the distance between the largest element of the current array
 * (currentMax) and the smallest element encountered so far (min).
 * maxDistance = Math.max(maxDistance, Math.abs(max - currentMin));:
 * This calculates the distance between the smallest element of the current
 * array (currentMin) and the largest element encountered so far (max).
 * The Math.max function is used to keep the largest distance found so far.
 * Update Global Min and Max:
 * 
 * After calculating the potential maximum distances, the global minimum (min)
 * and maximum (max) values are updated:
 * min = Math.min(min, currentMin);: Updates min to the smallest value between
 * the current min and currentMin.
 * max = Math.max(max, currentMax);: Updates max to the largest value between
 * the current max and currentMax.
 * Return the Result:
 * 
 * After the loop completes, the maximum distance found (maxDistance) is
 * returned as the result.
 */