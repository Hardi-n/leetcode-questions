/*
 * 167. Two Sum II - Input Array Is Sorted
 * Medium
 * Topics
 * Companies
 * Given a 1-indexed array of integers numbers that is already sorted in
 * non-decreasing order, find two numbers such that they add up to a specific
 * target number. Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length.
 * 
 * Return the indices of the two numbers, index1 and index2, added by one as an
 * integer array [index1, index2] of length 2.
 * 
 * The tests are generated such that there is exactly one solution. You may not
 * use the same element twice.
 * 
 * Your solution must use only constant extra space.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We
 * return [1, 2].
 * Example 2:
 * 
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We
 * return [1, 3].
 * Example 3:
 * 
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We
 * return [1, 2].
 * 
 * 
 * Constraints:
 * 
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        // Loop through each number in the array
        for (int i = 0; i < numbers.length; i++) {
            // Loop through the numbers after the current one
            for (int j = i + 1; j < numbers.length; j++) {
                // Check if the sum equals the target
                if (numbers[i] + numbers[j] == target) {
                    // Store the 1-based indices in the result array
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result; // Return immediately after finding the pair
                }
            }
        }

        return result; // Return the result
    }
}

/*
 * 
 * Explanation:
 * Inner Loop Starting Point: The inner loop starts from j = i + 1 to avoid
 * checking the same pair twice and to ensure that the same element is not used
 * twice.
 * Return After Finding Pair: The function immediately returns the result after
 * finding the correct pair to avoid unnecessary iterations.
 * 1-Based Index: Since the problem might expect 1-based indices, the indices
 * are incremented by 1 before storing them in the result array.
 * This code will now correctly find and return the indices of the two numbers
 * that add up to the target value.
 */