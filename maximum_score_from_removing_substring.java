/*
 * 1717. Maximum Score From Removing Substrings
Medium
Topics
Companies
Hint
You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.

 

Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20
 

Constraints:

1 <= s.length <= 105
1 <= x, y <= 104
s consists of lowercase English letters.
 */



 class Solution {
    public int maximumGain(String s, int x, int y) {
        // Decide the order of removal based on scores
        if (x < y) {
            // return maximumGainHelper(s, 'b', 'a', y) + maximumGainHelper(s, 'a', 'b', x);
            Stack<Character> stack = new Stack<>();
            int totalScore = 0;
            int score = y;
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                    stack.pop();
                    totalScore += score;
                } else {
                    stack.push(c);
                }
            }

            // Process the remaining characters to form the remaining string
            StringBuilder remaining = new StringBuilder();
            while (!stack.isEmpty()) {
                remaining.append(stack.pop());
            }
            remaining.reverse();

            String remainingstr= remaining.toString();
            Stack<Character> stackk = new Stack<>();
            score = x;
            for (char c : remainingstr.toCharArray()) {
                if (!stackk.isEmpty() && stackk.peek() == 'a' && c == 'b') {
                    stackk.pop();
                    totalScore += score;
                } else {
                    stackk.push(c);
                }
            }

            // Process the remaining characters to form the remaining string
            StringBuilder remainingg = new StringBuilder();
            while (!stackk.isEmpty()) {
                remainingg.append(stackk.pop());
            }
            remainingg.reverse();
            return totalScore;

        } else {
            // return maximumGainHelper(s, 'a', 'b', x) + maximumGainHelper(s, 'b', 'a', y);
            Stack<Character> stack = new Stack<>();
            int totalScore = 0;
            int score = x;
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == 'a' && c == 'b') {
                    stack.pop();
                    totalScore += score;
                } else {
                    stack.push(c);
                }
            }

            // Process the remaining characters to form the remaining string
            StringBuilder remaining = new StringBuilder();
            while (!stack.isEmpty()) {
                remaining.append(stack.pop());
            }
            remaining.reverse();

            String remainingstr= remaining.toString();
            Stack<Character> stackk = new Stack<>();
            score = y;
            for (char c : remainingstr.toCharArray()) {
                if (!stackk.isEmpty() && stackk.peek() == 'b' && c == 'a') {
                    stack.pop();
                    totalScore += score;
                } else {
                    stackk.push(c);
                }
            }

            // Process the remaining characters to form the remaining string
            StringBuilder remainingg = new StringBuilder();
            while (!stackk.isEmpty()) {
                remainingg.append(stackk.pop());
            }
            remainingg.reverse();
            return totalScore;
        }
    }

}



/*
 * 
 * 
 * Approach
 * 
 * 
 * 1. check the max score for x and y 
 * 2. use stack for this push until the pattern not reached
 * 3. when pattern found pop and increment the score
 * 4. return the score
 */