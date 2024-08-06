/*
 * 409. Longest Palindrome
 * Easy
 * Topics
 * Companies
 * Given a string s which consists of lowercase or uppercase letters, return the
 * length of the longest
 * palindrome
 * that can be built with those letters.
 * 
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 * Example 2:
 * 
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is
 * 1.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 */


 class Solution {
    public int longestPalindrome(String s) {
        int[] charCount = new int[52]; // 26 for lowercase + 26 for uppercase

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                charCount[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                charCount[c - 'A' + 26]++;
            }
        }

        int length = 0;
        boolean hasOddFrequency = false;

        // Calculate the maximum length of the palindrome
        for (int count : charCount) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1; // Add the even part of the odd frequency
                hasOddFrequency = true;
            }
        }

        // If there is any character with an odd frequency, we can place one in the center
        if (hasOddFrequency) {
            length++;
        }

        return length;
    }
}


/*
 * Explanation:
Character Frequency Count:

Use an array charCount of size 52 to count the frequency of each character.
Characters from 'a' to 'z' are stored in charCount[0] to charCount[25].
Characters from 'A' to 'Z' are stored in charCount[26] to charCount[51].
Calculate Maximum Palindrome Length:

Iterate through the charCount array.
If a character count is even, add it entirely to the palindrome length.
If a character count is odd, add its even part (i.e., count - 1) to the palindrome length and set hasOddFrequency to true.
Center Character for Odd Frequencies:

If there is any character with an odd frequency, add one to the palindrome length to account for a center character.
Return Result:

The resulting length is the length of the longest possible palindrome that can be built from the given string.
 */