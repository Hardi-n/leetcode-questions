/*
 * 392. Is Subsequence
 * Easy
 * Topics
 * Companies
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise.
 * 
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * 
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0; // Pointer for s
        int tIndex = 0; // Pointer for t

        // Iterate through t
        while (sIndex < s.length() && tIndex < t.length()) {
            // If characters match, move pointer for s
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            // Always move pointer for t
            tIndex++;
        }

        // If sIndex reached the end of s, all characters of s are found in t in order
        return sIndex == s.length();
    }
}

/*
 * 
 * Explanation:
 * Pointers:
 * 
 * sIndex: Keeps track of the current character in s.
 * tIndex: Keeps track of the current character in t.
 * Iteration:
 * 
 * Loop through t using tIndex.
 * If the current characters of s and t match (s.charAt(sIndex) ==
 * t.charAt(tIndex)), increment sIndex to check the next character in s.
 * Always increment tIndex to move to the next character in t.
 * Check Completion:
 * 
 * After the loop, if sIndex equals the length of s, it means all characters of
 * s were found in t in the correct order, so return true.
 * Otherwise, return false.
 */