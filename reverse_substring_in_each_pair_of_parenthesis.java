/*
 * 1190. Reverse Substrings Between Each Pair of Parentheses
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a string s that consists of lower case English letters and
 * brackets.
 * 
 * Reverse the strings in each pair of matching parentheses, starting from the
 * innermost one.
 * 
 * Your result should not contain any brackets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "(abcd)"
 * Output: "dcba"
 * Example 2:
 * 
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Explanation: The substring "love" is reversed first, then the whole string is
 * reversed.
 * Example 3:
 * 
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Explanation: First, we reverse the substring "oc", then "etco", and finally,
 * the whole string.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2000
 * s only contains lower case English characters and parentheses.
 * It is guaranteed that all parentheses are balanced.
 */

class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        // Traverse the string
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Push the current StringBuilder onto the stack and start a new one
                stack.push(current);
                current = new StringBuilder();
            } else if (c == ')') {
                // Reverse the current StringBuilder and append it to the one on top of the
                // stack
                current.reverse();
                current = stack.pop().append(current);
            } else {
                // Append regular characters to the current StringBuilder
                current.append(c);
            }
        }

        // Return the result as a string
        return current.toString();
    }
}

/*
 * Explanation:
 * Stack and StringBuilder:
 * 
 * We use a stack to keep track of the strings before encountering each '('.
 * current is a StringBuilder that accumulates characters between parentheses.
 * Processing each character:
 * 
 * If we encounter '(', we push the current string onto the stack and start a
 * new StringBuilder for the substring inside the parentheses.
 * If we encounter ')', we reverse the substring that we've built so far
 * (between the matching parentheses), pop the top string from the stack, and
 * append the reversed substring to it.
 * For other characters, we simply append them to current.
 * Result:
 * 
 * After processing the entire string, current will contain the final result
 * with all substrings inside parentheses reversed.
 */