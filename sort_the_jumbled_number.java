/*
 * 
 * 2191. Sort the Jumbled Numbers
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a 0-indexed integer array mapping which represents the mapping
 * rule of a shuffled decimal system. mapping[i] = j means digit i should be
 * mapped to digit j in this system.
 * 
 * The mapped value of an integer is the new integer obtained by replacing each
 * occurrence of digit i in the integer with mapping[i] for all 0 <= i <= 9.
 * 
 * You are also given another integer array nums. Return the array nums sorted
 * in non-decreasing order based on the mapped values of its elements.
 * 
 * Notes:
 * 
 * Elements with the same mapped values should appear in the same relative order
 * as in the input.
 * The elements of nums should only be sorted based on their mapped values and
 * not be replaced by them.
 * 
 * 
 * Example 1:
 * 
 * Input: mapping = [8,9,4,0,2,1,3,5,7,6], nums = [991,338,38]
 * Output: [338,38,991]
 * Explanation:
 * Map the number 991 as follows:
 * 1. mapping[9] = 6, so all occurrences of the digit 9 will become 6.
 * 2. mapping[1] = 9, so all occurrences of the digit 1 will become 9.
 * Therefore, the mapped value of 991 is 669.
 * 338 maps to 007, or 7 after removing the leading zeros.
 * 38 maps to 07, which is also 7 after removing leading zeros.
 * Since 338 and 38 share the same mapped value, they should remain in the same
 * relative order, so 338 comes before 38.
 * Thus, the sorted array is [338,38,991].
 * Example 2:
 * 
 * Input: mapping = [0,1,2,3,4,5,6,7,8,9], nums = [789,456,123]
 * Output: [123,456,789]
 * Explanation: 789 maps to 789, 456 maps to 456, and 123 maps to 123. Thus, the
 * sorted array is [123,456,789].
 * 
 * 
 * Constraints:
 * 
 * mapping.length == 10
 * 0 <= mapping[i] <= 9
 * All the values of mapping[i] are unique.
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] < 109
 */

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // List to store the mapped numbers along with their original values
        List<int[]> mappedList = new ArrayList<>();

        // Apply mapping to each number
        for (int num : nums) {
            mappedList.add(new int[] { getMappedValue(mapping, num), num });
        }

        // Sort based on the mapped values
        mappedList.sort(Comparator.comparingInt(a -> a[0]));

        // Extract the original numbers in sorted order
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = mappedList.get(i)[1];
        }

        return sortedNums;
    }

    // Function to convert a number to its mapped value
    private static int getMappedValue(int[] mapping, int num) {
        StringBuilder mappedValue = new StringBuilder();
        if (num == 0) {
            return mapping[0];
        }
        while (num > 0) {
            int digit = num % 10;
            mappedValue.append(mapping[digit]);
            num /= 10;
        }
        return Integer.parseInt(mappedValue.reverse().toString());
    }
}

/*
 * 
 * Explanation:
 * Mapping Array: The mapping[] array defines how each digit (0-9) should be
 * transformed. For example, mapping[0] = 9, mapping[1] = 8, etc., implies that
 * the number 0 is mapped to 9, and 1 is mapped to 8.
 * 
 * Transforming Numbers: The getMappedValue method takes each number, breaks it
 * into its digits, applies the mapping to each digit, and then forms the new
 * mapped number.
 * 
 * Sorting: Once all numbers are transformed, they are sorted based on their
 * mapped values.
 * 
 * Restoring Original Numbers: After sorting the transformed numbers, we use the
 * second value in each pair (the original number) to get the sorted result.
 */

/*
 * Approach:
 * Create a mapping array that defines the custom order of the numbers.
 * Iterate through the list of jumbled numbers and replace them with their
 * corresponding positions in the custom order.
 * Sort the numbers based on this mapping.
 * Convert them back to their original values using the reverse of the mapping.
 * 
 */