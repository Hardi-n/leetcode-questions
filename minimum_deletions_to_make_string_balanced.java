/*1653. Minimum Deletions to Make String Balanced
Medium
Topics
Companies
Hint
You are given a string s consisting only of characters 'a' and 'b'​​​​.

You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Return the minimum number of deletions needed to make s balanced.

 

Example 1:

Input: s = "aababbab"
Output: 2
Explanation: You can either:
Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
Example 2:

Input: s = "bbaaaaabb"
Output: 2
Explanation: The only solution is to delete the first two characters.
 

Constraints:

1 <= s.length <= 105
s[i] is 'a' or 'b'​​.
 */

class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0; // To count the number of 'b's before the current position
        int deletions = 0; // Minimum deletions to make string balanced

        // Traverse the string
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++; // Increment b count for each 'b' encountered
            } else { // If the current character is 'a'
                if (bCount > 0) {
                    // We have encountered an 'a' after some 'b's, so we need to delete either this
                    // 'a' or one 'b'
                    deletions++;
                    bCount--; // Pretend we deleted one 'b' instead of the current 'a'
                }
            }
        }

        return deletions;
    }
}

/*
 * 
 * Explanation:
 * bCount: Keeps track of the number of 'b's before the current position.
 * deletions: Tracks how many deletions have been made.
 */