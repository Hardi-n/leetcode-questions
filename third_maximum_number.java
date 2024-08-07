/*
 * 
 * 414. Third Maximum Number
 * Easy
 * Topics
 * Companies
 * Given an integer array nums, return the third distinct maximum number in this
 * array. If the third maximum does not exist, return the maximum number.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * Example 2:
 * 
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned
 * instead.
 * Example 3:
 * 
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they
 * have the same value).
 * The third distinct maximum is 1.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * 
 * 
 * Follow up: Can you find an O(n) solution?
 */


 class Solution {
    public int thirdMax(int[] nums) {
       Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : nums) {
            uniqueNumbers.add(num);
        }
        
        Integer[] uniqueArray = uniqueNumbers.toArray(new Integer[0]);
        Arrays.sort(uniqueArray, (a, b) -> b - a); // Sort in descending order
        
        return uniqueArray.length >= 3 ? uniqueArray[2] : uniqueArray[0]; 
    }
}


/*
 * 
 * Explanation:
HashSet for Unique Numbers:
Use a HashSet to store unique numbers from the input array.
Convert to Array and Sort:
Convert the HashSet to an array and sort it in descending order.
Return the Fourth Maximum:
Check if the array length is at least 4. If so, return the fourth element (index 3). Otherwise, return the maximum number (index 0).
 */