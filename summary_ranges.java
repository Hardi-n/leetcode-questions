/*
 * 
 * 228. Summary Ranges
Easy
Topics
Companies
You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
 

Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
nums is sorted in ascending order.
 */


 class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        int size = nums.length;
        
        if (size == 0) {
            return ranges;
        }

        // Initialize the start of the current range
        int start = nums[0];

        for (int i = 1; i < size; i++) {
            // Check if the current number is not consecutive
            if (nums[i] != nums[i - 1] + 1) {
                // If the start is equal to the previous number, it's a single number range
                if (start == nums[i - 1]) {
                    ranges.add(String.valueOf(start));
                } else {
                    // Otherwise, it's a range
                    ranges.add(start + "->" + nums[i - 1]);
                }
                // Update the start to the current number
                start = nums[i];
            }
        }
        
        // Add the final range or single number
        if (start == nums[size - 1]) {
            ranges.add(String.valueOf(start));
        } else {
            ranges.add(start + "->" + nums[size - 1]);
        }

        return ranges;
    }
}


/*
 * 
 * Initialization:

ranges is an ArrayList to store the summary of ranges.
size is the length of the input array nums.
start keeps track of the beginning of each range.
Edge Case:

If the input array is empty (size == 0), return the empty list.
Main Loop:

Iterate through the array from the second element to the end.
If the current number is not consecutive to the previous number (nums[i] != nums[i - 1] + 1):
Check if the start is equal to the previous number. If yes, it means the range is a single number.
Otherwise, form a range string from start to the previous number and add it to the list.
Update start to the current number.
Final Range:

After exiting the loop, handle the last range or single number. This ensures the last part of the array is considered.
Add the final range or single number to the list.
Return:

Return the list of summarized ranges.
 */