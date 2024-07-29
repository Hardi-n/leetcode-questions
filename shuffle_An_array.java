/*
 * 
 * 384. Shuffle an Array
 * Medium
 * Topics
 * Companies
 * Hint
 * Given an integer array nums, design an algorithm to randomly shuffle the
 * array. All permutations of the array should be equally likely as a result of
 * the shuffling.
 * 
 * Implement the Solution class:
 * 
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 * 
 * 
 * Example 1:
 * 
 * Input
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * Output
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * 
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle(); // Shuffle the array [1,2,3] and return its result.
 * // Any permutation of [1,2,3] must be equally likely to be returned.
 * // Example: return [3, 1, 2]
 * solution.reset(); // Resets the array back to its original configuration
 * [1,2,3]. Return [1, 2, 3]
 * solution.shuffle(); // Returns the random shuffling of array [1,2,3].
 * Example: return [1, 3, 2]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 50
 * -106 <= nums[i] <= 106
 * All the elements of nums are unique.
 * At most 104 calls in total will be made to reset and shuffle.
 */

class Solution {
    private int[] original;
    private int[] array;
    private Random rand;

    public Solution(int[] nums) {
        this.original = nums.clone();
        this.array = nums.clone();
        this.rand = new Random();
    }

    public int[] reset() {
        array = original.clone();
        return array;
    }

    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(array, i, j);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

/*
 * 
 * Explanation:
 * Constructor (Solution(int[] nums)):
 * 
 * Initializes the original array with a copy of the input array using clone().
 * Initializes the array with another copy of the input array using clone().
 * Initializes a Random object to generate random numbers.
 * reset() Method:
 * 
 * Resets the array to its original configuration by cloning the original array.
 * Returns the reset array.
 * shuffle() Method:
 * 
 * Uses the Fisher-Yates shuffle algorithm to shuffle the elements of the array.
 * Iterates from the end of the array to the beginning.
 * For each element, generates a random index j and swaps the current element
 * with the element at the random index.
 * Returns the shuffled array.
 * swap(int[] array, int i, int j) Method:
 * 
 * A helper method to swap elements at indices i and j in the array.
 */