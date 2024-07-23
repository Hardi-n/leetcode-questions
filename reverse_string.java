/*
 * 
 * 344. Reverse String
 * Easy
 * Topics
 * Companies
 * Hint
 * Write a function that reverses a string. The input string is given as an
 * array of characters s.
 * 
 * You must do this by modifying the input array in-place with O(1) extra
 * memory.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * 
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */

class Solution {
    public void reverseString(char[] s) {
        reverseArray(s);
    }

    public static void reverseArray(char[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            // Swap the elements at index i and n-i-1
            char temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }
}

/*
 * 
 * 
 * Approach
 * 
 * Explanation:
 * 1.Initialization: The length of the array is stored in the variable n.
 * 2.Looping: The for loop iterates from 0 to n/2, ensuring that each element from
 *      the start is swapped with the corresponding element from the end.
 * 3.Swapping: Inside the loop, the elements at index i and n-i-1 are swapped
 *      using a temporary variable temp.
 * 4.Output: After reversing the array, the main method prints out the reversed
 *      array.
 */