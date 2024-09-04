/*
 * 1552. Magnetic Force Between Two Balls
 * Medium
 * Topics
 * Companies
 * Hint
 * In the universe Earth C-137, Rick discovered a special form of magnetic force
 * between two balls if they are put in his new invented basket. Rick has n
 * empty baskets, the ith basket is at position[i], Morty has m balls and needs
 * to distribute the balls into the baskets such that the minimum magnetic force
 * between any two balls is maximum.
 * 
 * Rick stated that magnetic force between two different balls at positions x
 * and y is |x - y|.
 * 
 * Given the integer array position and the integer m. Return the required
 * force.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: position = [1,2,3,4,7], m = 3
 * Output: 3
 * Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the
 * magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3.
 * We cannot achieve a larger minimum magnetic force than 3.
 * Example 2:
 * 
 * Input: position = [5,4,3,2,1,1000000000], m = 2
 * Output: 999999999
 * Explanation: We can use baskets 1 and 1000000000.
 * 
 * 
 * Constraints:
 * 
 * n == position.length
 * 2 <= n <= 105
 * 1 <= position[i] <= 109
 * All integers in position are distinct.
 * 2 <= m <= position.length
 */

class Solution {
    public int maxDistance(int[] position, int m) {
        // Sort the array to apply binary search on distances
        Arrays.sort(position);

        // Binary search on the distance
        int left = 1, right = position[position.length - 1] - position[0];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlaceBalls(position, m, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean canPlaceBalls(int[] position, int m, int distance) {
        int count = 1; // We place the first ball at the first position
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= distance) {
                count++;
                lastPos = position[i];
                if (count == m)
                    return true;
            }
        }

        return false;
    }
}

/*
 * Explanation:
 * Sorting: We sort the positions to make it easier to calculate the distances
 * between consecutive positions.
 * Binary Search:
 * left starts at 1, representing the smallest possible minimum distance.
 * right is initialized to the difference between the maximum and minimum
 * position, which represents the largest possible minimum distance.
 * We perform binary search to find the maximum possible minimum distance that
 * allows placing m balls.
 * canPlaceBalls Function: This function checks if it's possible to place all m
 * balls with at least distance units apart. It iterates through the positions
 * and places a ball whenever the current position is at least distance away
 * from the last placed ball.
 */