/*
 * 
 * 41. First Missing Positive
 * Hard
 * Topics
 * Companies
 * Hint
 * Given an unsorted integer array nums. Return the smallest positive integer
 * that is not present in nums.
 * 
 * You must implement an algorithm that runs in O(n) time and uses O(1)
 * auxiliary space.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * Example 2:
 * 
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * Example 3:
 * 
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 */


 class Solution {
    public int firstMissingPositive(int[] nums) {
        // Convert the int[] array to Integer[] array to work with HashSet
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        int result = 1; // The first missing positive number we are looking for

        // Iterate starting from 1 upwards
        while (true) {
            // If the result is not in the set, return it as the missing positive
            if (!hashSet.contains(result)) {
                return result;
            }
            result++;
        }
    }
}


/*
 * 
 * Approach
 * 1. convert array to hashset
 * 2. iterate through hashset elements using contains()
 * 3. return the result
 */