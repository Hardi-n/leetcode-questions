/*
 * 
 * 539. Minimum Time Difference
 * Medium
 * Topics
 * Companies
 * Given a list of 24-hour clock time points in "HH:MM" format, return the
 * minimum minutes difference between any two time-points in the list.
 * 
 * 
 * Example 1:
 * 
 * Input: timePoints = ["23:59","00:00"]
 * Output: 1
 * Example 2:
 * 
 * Input: timePoints = ["00:00","23:59","00:00"]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 2 <= timePoints.length <= 2 * 104
 * timePoints[i] is in the format "HH:MM".
 */

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // Step 1: Convert the time points to minutes
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int mins = Integer.parseInt(parts[1]);
            minutes.add(hours * 60 + mins);
        }

        // Step 2: Sort the time points
        Collections.sort(minutes);

        // Step 3: Compute the minimum difference
        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            minDifference = Math.min(minDifference, minutes.get(i) - minutes.get(i - 1));
        }

        // Step 4: Check the circular difference between the last and the first time
        // point
        int circularDifference = (1440 - minutes.get(minutes.size() - 1)) + minutes.get(0);
        minDifference = Math.min(minDifference, circularDifference);

        return minDifference;
    }
}

/*
 * 
 * Explanation:
 * Convert time to minutes:
 * 
 * For example, "23:59" is converted to 23 * 60 + 59 = 1439 minutes.
 * "00:00" is converted to 0 minutes.
 * Sort the times:
 * 
 * Sorting helps us easily find the difference between consecutive times.
 * Calculate the difference:
 * 
 * After sorting, calculate the difference between each consecutive time point.
 * Also, calculate the circular difference (i.e., from the last time to the
 * first time, wrapping around).
 * Return the minimum difference.
 * 
 * 
 */