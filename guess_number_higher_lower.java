/*
 * 374. Guess Number Higher or Lower
 * Easy
 * Topics
 * Companies
 * We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I will tell you whether the number I picked is
 * higher or lower than your guess.
 * 
 * You call a pre-defined API int guess(int num), which returns three possible
 * results:
 * 
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 10, pick = 6
 * Output: 6
 * Example 2:
 * 
 * Input: n = 1, pick = 1
 * Output: 1
 * Example 3:
 * 
 * Input: n = 2, pick = 1
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 */

/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */

public class guess_number_higher_lower extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid potential overflow
            int result = guess(mid);

            if (result == 0) {
                return mid; // Found the number
            } else if (result == -1) {
                right = mid - 1; // Guess is too high
            } else {
                left = mid + 1; // Guess is too low
            }
        }

        return -1;
    }
}

/*
 * 
 * Approach
 * 
 * 
 * 1.Binary Search Initialization:
    * Initialize two pointers: left at 1 and right at n.
 * 
 * 2.Binary Search Loop:
 * 
    * Calculate the middle point mid to avoid potential overflow.

    * Use the guess(mid) API to get feedback:
        * If guess(mid) returns 0, it means the guessed number is correct, so returnmid.
        * If guess(mid) returns -1, it means the guessed number is too high, so adjust the right pointer to mid - 1.
        * If guess(mid) returns 1, it means the guessed number is too low, so adjust the left pointer to mid + 1.



 * 3.End Condition:
    * The loop continues until the correct number is found.
    * If the number is not within the range (though it should be), return -1.
 */