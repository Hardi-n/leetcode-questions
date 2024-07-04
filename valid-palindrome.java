/*
 * 
 * 125. Valid Palindrome
Easy
Topics
Companies
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */




 class Solution {
    public boolean isPalindrome(String s) {
         StringBuilder filteredString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredString.append(Character.toLowerCase(c));
            }
        }

        // Step 2: Check if the normalized string is a palindrome
        String normalized = filteredString.toString();
        String reversed = filteredString.reverse().toString();

        return normalized.equals(reversed);
    }
}



/*
 * APPROACH
 1. Filter the String:
    Remove non-alphanumeric characters.
    Convert all characters to the same case (lowercase or uppercase).

2.Check Palindromicity:
    Compare the filtered string with its reverse.
 */