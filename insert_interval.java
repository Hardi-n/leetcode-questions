/*
 * 
 * 57. Insert Interval
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the ith
 * interval and intervals is sorted in ascending order by starti. You are also
 * given an interval newInterval = [start, end] that represents the start and
 * end of another interval.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by starti and intervals still does not have any overlapping
 * intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion.
 * 
 * Note that you don't need to modify intervals in-place. You can make a new
 * array and return it.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * 
 * 
 * Constraints:
 * 
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int count = 0;

        // Calculate the size of the result array
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0] || interval[0] > newInterval[1]) {
                count++;
            }
        }

        // The new array size will be the original size + 1 if no intervals merge with
        // the new interval
        // otherwise the size remains the same
        int[][] result = new int[n - count + 1][2];

        int index = 0;
        int i = 0;

        // Add intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result[index++] = intervals[i++];
        }

        // Merge overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result[index++] = newInterval; // Add the merged interval

        // Add remaining intervals that come after the new interval
        while (i < n) {
            result[index++] = intervals[i++];
        }

        // Resize result array if necessary
        if (index < result.length) {
            int[][] resizedResult = new int[index][2];
            System.arraycopy(result, 0, resizedResult, 0, index);
            return resizedResult;
        }

        return result;
    }
}

/*
 * 
 * Step-by-Step Explanation:
 * Initial Setup:
 * 
 * n stores the length of the intervals array.
 * count is initialized to 0 and will be used to count the number of intervals
 * that do not overlap with the newInterval.
 * Calculate the Size of the Result Array:
 * 
 * A loop iterates over the intervals to count the intervals that do not overlap
 * with the newInterval.
 * If an interval ends before the new interval starts or starts after the new
 * interval ends, it does not overlap, so count is incremented.
 * Determine the Result Array Size:
 * 
 * The result array size is determined based on count. If there are no
 * overlapping intervals, the result array will have one additional interval
 * (for the newInterval), so the size is n - count + 1. Otherwise, it remains
 * the same.
 * Insert and Merge Intervals:
 * 
 * Add Non-overlapping Intervals Before the New Interval:
 * 
 * The first while loop adds intervals to the result array that end before the
 * newInterval starts (non-overlapping intervals before the new interval).
 * Merge Overlapping Intervals with the New Interval:
 * 
 * The second while loop handles the merging of overlapping intervals with the
 * newInterval.
 * The start of the newInterval is updated to the minimum start between
 * newInterval and the current interval.
 * The end of the newInterval is updated to the maximum end between newInterval
 * and the current interval.
 * This merged interval is then added to the result.
 * Add Remaining Non-overlapping Intervals After the New Interval:
 * 
 * The third while loop adds the remaining intervals that start after the
 * newInterval ends (non-overlapping intervals after the new interval).
 * Resize Result Array if Necessary:
 * 
 * If index (the number of intervals added to result) is less than the length of
 * result, the result array is resized to remove any unused space. This is done
 * using System.arraycopy.
 * If no resizing is needed, the original result array is returned.
 */