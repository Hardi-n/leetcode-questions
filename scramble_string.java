/*
 * 87. Scramble String
 * Hard
 * Topics
 * Companies
 * We can scramble a string s to get a string t using the following algorithm:
 * 
 * If the length of the string is 1, stop.
 * If the length of the string is > 1, do the following:
 * Split the string into two non-empty substrings at a random index, i.e., if
 * the string is s, divide it to x and y where s = x + y.
 * Randomly decide to swap the two substrings or to keep them in the same order.
 * i.e., after this step, s may become s = x + y or s = y + x.
 * Apply step 1 recursively on each of the two substrings x and y.
 * Given two strings s1 and s2 of the same length, return true if s2 is a
 * scrambled string of s1, otherwise, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Explanation: One possible scenario applied on s1 is:
 * "great" --> "gr/eat" // divide at random index.
 * "gr/eat" --> "gr/eat" // random decision is not to swap the two substrings
 * and keep them in order.
 * "gr/eat" --> "g/r / e/at" // apply the same algorithm recursively on both
 * substrings. divide at random index each of them.
 * "g/r / e/at" --> "r/g / e/at" // random decision was to swap the first
 * substring and to keep the second substring in the same order.
 * "r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively,
 * divide "at" to "a/t".
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both
 * substrings in the same order.
 * The algorithm stops now, and the result string is "rgeat" which is s2.
 * As one possible scenario led s1 to be scrambled to s2, we return true.
 * Example 2:
 * 
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 * Example 3:
 * 
 * Input: s1 = "a", s2 = "a"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * s1.length == s2.length
 * 1 <= s1.length <= 30
 * s1 and s2 consist of lowercase English letters.
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        // If strings are equal, they are trivially scrambled
        if (s1.equals(s2)) {
            return true;
        }

        // If the lengths are different, they cannot be scrambled versions
        if (s1.length() != s2.length()) {
            return false;
        }

        // Use the memoized result if available
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Check if the two strings have the same characters
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int count : letters) {
            if (count != 0) {
                memo.put(key, false);
                return false;
            }
        }

        int n = s1.length();

        // Try to split the string into two parts and check both possibilities:
        // 1. Without swapping
        // 2. With swapping
        for (int i = 1; i < n; i++) {
            // Case 1: No swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }
            // Case 2: Swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        // If none of the above cases match, the strings are not scrambled versions
        memo.put(key, false);
        return false;
    }
}

/*
 * 
 * Approach
 * A recursive approach is commonly used to solve the problem by considering all
 * possible ways to split the strings and checking if swapping the parts yields
 * the second string.
 * 
 * 
 * 
 * Explanation of Optimized Code:
 * Memoization:
 * 
 * A Map<String, Boolean> is used to store the results of subproblems. The key
 * is a combination of the two strings being compared, and the value is the
 * result (true or false).
 * Before any computation, the code checks if the result is already in the memo.
 * If it is, it returns the stored result immediately.
 * Base Case:
 * 
 * The base cases remain the same as in the previous solution.
 * Character Frequency Check:
 * 
 * This step ensures that both strings have the same characters before checking
 * further.
 * Recursive Check:
 * 
 * The recursive check also remains the same, but now the results are stored in
 * the memoization map to avoid redundant computations.
 * Return Stored Result:
 * 
 * After computing the result for a particular pair of strings, the result is
 * stored in the memoization map.
 */