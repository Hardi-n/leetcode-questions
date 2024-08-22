/*
 * 
 * 128. Longest Consecutive Sequence
 * Medium
 * Topics
 * Companies
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * Example 2:
 * 
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Only start a sequence from numbers that are not part of a larger sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the current sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}

/*
 * 
 * Explanation of the Code
 * Initialization:
 * 
 * We use a HashSet to store all elements from the array for quick lookup.
 * We initialize longestStreak to track the length of the longest consecutive
 * sequence found.
 * Checking Each Element:
 * 
 * For each number, we first check if it could be the start of a sequence by
 * seeing if num - 1 exists in the set. If it doesn't, then the current number
 * is the start of a new sequence.
 * We then count the length of the sequence starting from that number by
 * checking how many consecutive numbers follow.
 * Updating the Longest Streak:
 * 
 * After counting the sequence length, we update longestStreak if the current
 * sequence is longer than the previously recorded maximum.
 * 
 */