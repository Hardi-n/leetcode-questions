/*
 * int n = nums.length;
 * int sum_nums = 0;
 * int F = 0;
 * 
 * // Calculate sum of all elements and initial F(0)
 * for (int i = 0; i < n; i++) {
 * sum_nums += nums[i];
 * F += i * nums[i];
 * }
 * 
 * // Track maximum value of F
 * int maxF = F;
 * 
 * // Calculate F(k) for k = 1 to n-1 using the relationship
 * for (int k = 1; k < n; k++) {
 * // F(k) = F(k-1) + sum_nums - n * nums[n-k]
 * F = F + sum_nums - n * nums[n - k];
 * maxF = Math.max(maxF, F);
 * }
 * 
 * return maxF;
 */

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum_nums = 0;
        int F = 0;

        // Calculate sum of all elements and initial F(0)
        for (int i = 0; i < n; i++) {
            sum_nums += nums[i];
            F += i * nums[i];
        }

        // Track maximum value of F
        int maxF = F;

        // Calculate F(k) for k = 1 to n-1 using the relationship
        for (int k = 1; k < n; k++) {
            // F(k) = F(k-1) + sum_nums - n * nums[n-k]
            F = F + sum_nums - n * nums[n - k];
            maxF = Math.max(maxF, F);
        }

        return maxF;
    }
}

/*
 * Explanation:
 * Initialization:
 * 
 * We calculate the total sum of the array sum_nums and the initial rotation
 * function value
 * 𝐹
 * (
 * 0
 * )
 * F(0).
 * Loop Through Rotations:
 * 
 * For each rotation
 * 𝑘
 * k from 1 to
 * 𝑛
 * −
 * 1
 * n−1, we update
 * 𝐹
 * F using the derived relationship and keep track of the maximum
 * 𝐹
 * F value.
 * This approach ensures that we only iterate through the array a couple of
 * times, making it efficient with a time complexity of
 * 𝑂
 * (
 * 𝑛
 * )
 * O(n).
 */