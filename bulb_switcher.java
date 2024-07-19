/*
 * 
 * 319. Bulb Switcher
 * Medium
 * Topics
 * Companies
 * There are n bulbs that are initially off. You first turn on all the bulbs,
 * then you turn off every second bulb.
 * 
 * On the third round, you toggle every third bulb (turning on if it's off or
 * turning off if it's on). For the ith round, you toggle every i bulb. For the
 * nth round, you only toggle the last bulb.
 * 
 * Return the number of bulbs that are on after n rounds.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output: 1
 * Explanation: At first, the three bulbs are [off, off, off].
 * After the first round, the three bulbs are [on, on, on].
 * After the second round, the three bulbs are [on, off, on].
 * After the third round, the three bulbs are [on, off, off].
 * So you should return 1 because there is only one bulb is on.
 * Example 2:
 * 
 * Input: n = 0
 * Output: 0
 * Example 3:
 * 
 * Input: n = 1
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 0 <= n <= 109
 */

class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}

/*
 * Approach
 * 1. return math.sqrt(n)
 */

/*
 * Example: n = 10
 * We have 10 bulbs initially turned off. We will go through 10 rounds of
 * toggling:
 * 
 * Round 1: Toggle every bulb. Bulbs: [on, on, on, on, on, on, on, on, on, on]
 * Round 2: Toggle every 2nd bulb. Bulbs: [on, off, on, off, on, off, on, off,
 * on, off]
 * Round 3: Toggle every 3rd bulb. Bulbs: [on, off, off, off, on, on, on, off,
 * off, off]
 * Round 4: Toggle every 4th bulb. Bulbs: [on, off, off, on, on, on, on, on,
 * off, off]
 * Round 5: Toggle every 5th bulb. Bulbs: [on, off, off, on, off, on, on, on,
 * off, on]
 * Round 6: Toggle every 6th bulb. Bulbs: [on, off, off, on, off, off, on, on,
 * off, on]
 * Round 7: Toggle every 7th bulb. Bulbs: [on, off, off, on, off, off, off, on,
 * off, on]
 * Round 8: Toggle every 8th bulb. Bulbs: [on, off, off, on, off, off, off, off,
 * off, on]
 * Round 9: Toggle every 9th bulb. Bulbs: [on, off, off, on, off, off, off, off,
 * on, on]
 * Round 10: Toggle every 10th bulb. Bulbs: [on, off, off, on, off, off, off,
 * off, on, off]
 * At the end of the 10th round, the bulbs that remain on are those at positions
 * 1, 4, and 9. These positions correspond to perfect squares (1², 2², and 3²).
 * 
 * Why Only Perfect Squares?
 * A bulb ends up being on if it is toggled an odd number of times. Typically,
 * bulbs are toggled in pairs, which results in an even number of toggles.
 * However, for perfect squares, there is one unique pair that is not a pair but
 * a single value (e.g., the divisors of 9 are 1, 3, and 9 - here, 3 pairs with
 * itself).
 * 
 * Counting Perfect Squares
 * To find the number of bulbs that remain on after n rounds, we need to count
 * how many perfect squares are less than or equal to n. This is equivalent to
 * finding the integer part of the square root of n because:
 * 
 * For n = 10, the perfect squares are 1, 4, and 9.
 * sqrt(10) is approximately 3.16, and taking the integer part gives us 3.
 */