/*
 * 56. Merge Intervals
 * Medium
 * Topics
 * Companies
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 * 
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * 
 * Constraints:
 * 
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge case: If there are no intervals, return an empty array
        if (intervals.length == 0) {
            return new int[0][];
        }

        // Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Create a list to hold the merged intervals
        List<int[]> merged = new ArrayList<>();

        // Start with the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // Iterate through the intervals
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // Check if the current interval overlaps with the next interval
            if (currentEnd >= nextStart) {
                // Merge the intervals by updating the end of the current interval
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add the next interval to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        // Convert the merged list back to an array and return
        return merged.toArray(new int[merged.size()][]);
    }
}

/*
 * Explanation:
 * Sorting: The intervals are sorted based on their starting times using
 * Arrays.sort(). This allows us to easily identify overlapping intervals
 * because overlapping intervals will now be adjacent.
 * 
 * Merging:
 * 
 * We initialize the currentInterval with the first interval and start iterating
 * over the intervals.
 * For each interval:
 * If the current interval overlaps with the next interval (i.e., the end time
 * of the current interval is greater than or equal to the start time of the
 * next interval), we merge them by updating the end time of the current
 * interval to the maximum of the current interval's end time and the next
 * interval's end time.
 * If there is no overlap, we add the current interval to the list of merged
 * intervals and move on to the next interval.
 * Result: After iterating through all the intervals, the merged intervals are
 * stored in the merged list. We convert this list to an array and return it as
 * the final result.
 */