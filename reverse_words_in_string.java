/*
 * 
 * 151. Reverse Words in a String
Medium
Topics
Companies
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */


 class Solution {
    public String reverseWords(String s) {
        // Step 1: remove spaces from first and last
        s = s.trim();
        // Step 2: Split the string into words array
        String[] words = s.split("\\s+");
        //Step3: Reverese the array of string 
        reverseArray(words);
        
        // Step4: Join the words back into a single string
        return String.join(" ", words);
    }
    public static void reverseArray(String[] array) {
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            // Swap elements at left and right
            String temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            
            // Move pointers towards the center
            left++;
            right--;
        }
    }
}


/*
 * 
 * Approach
 * 
 * 1.Remove forward and backword spaces
 *      using trim();
 * 
 * 2. Split the string into array based on the condition where there is a space in between the string
 *      using split("\\s+");
 * 
 * 3.Reverse the array
 *      using the two pointer approach
 * 
 * 4.join the array back into string
 *      using String.join(" ",array);   with the delimeter space 
 */