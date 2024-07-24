/*
 * 345. Reverse Vowels of a String
 * Easy
 * Topics
 * Companies
 * Given a string s, reverse only all the vowels in the string and return it.
 * 
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower
 * and upper cases, more than once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 * 
 * Input: s = "leetcode"
 * Output: "leotcede"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */

class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0)
            return s;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }

            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }
}

/*
 * 
 * 
 * Approach
 * 
 * 
 * 
 * Explanation:
 *      1.Set of Vowels: A HashSet is used to store the vowels for quick look-up.
 *      2.Two Pointers: The algorithm uses two pointers (left and right) starting
 *          from the beginning and end of the string respectively.
 *      3.Find Vowels: The pointers move towards each other until they find vowels.
 *      4.Swap Vowels: When both pointers point to vowels, they are swapped.
 *      5.Move Pointers: After swapping, the pointers are moved inward.
 * 
 */