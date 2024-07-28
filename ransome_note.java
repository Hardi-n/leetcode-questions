/*
 * 383. Ransom Note
 * Easy
 * Topics
 * Companies
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * 
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * 
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */


 class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Assuming only lowercase letters, we can use an array of size 26
        int[] charCount = new int[26];

        // Count the frequency of each character in the magazine
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Check if the ransom note can be constructed from the magazine
        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false; // Character not found or not enough occurrences
            }
            charCount[c - 'a']--;
        }

        return true;
    }
}




/*
 * 
 * Approach
 * 
 * 1. make an array charcount which will store the ferquency of each character
 * 2. using magazine string count the frequency of each element in magazine and store it into charcount 
 * 3. check from the given string rancsomeNote that every character in ransomeNote can be concstructed by magazine using the charcount array
 * 3. if no return false , else return true
 */