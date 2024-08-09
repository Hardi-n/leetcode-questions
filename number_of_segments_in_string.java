/*
 * 
 * 434. Number of Segments in a String
Easy
Topics
Companies
Given a string s, return the number of segments in the string.

A segment is defined to be a contiguous sequence of non-space characters.

 

Example 1:

Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
Example 2:

Input: s = "Hello"
Output: 1
 

Constraints:

0 <= s.length <= 300
s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:".
The only space character in s is ' '.
 */



 class Solution {
    public int countSegments(String s) {
        String arr[] = s.split(" ");
        return arr.length;
    }
}





/**
 * 
 * Approach
 *  
 * 
 * 1. split the string into array using split(" ")
 * 2. return the size of the array
 */




 /*updated code-------------->>>>>>>>>>>>>>>>>>>>>>>>>>*/
 class Solution {
    public int countSegments(String s) {
        // Trim the string to remove leading and trailing spaces
        // Use a regular expression to split on one or more spaces
        String arr[] = s.trim().split("\\s+");

        // If the string is empty after trimming, return 0
        if (s.trim().isEmpty()) {
            return 0;
        }

        return arr.length;
    }
}





/*
 * 
 * Approach
 * 1. use trim for the extra spaces on both ends
 * 2. split(" ")
 * 3. return size of array using array.length;
 */