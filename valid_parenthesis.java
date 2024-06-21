/*
 * Valid Parentheses
    Easy
    Topics
    Companies
    Hint
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
    

    Example 1:

    Input: s = "()"
    Output: true
    Example 2:

    Input: s = "()[]{}"
    Output: true
    Example 3:

    Input: s = "(]"
    Output: false
    

    Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
 */

 class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
        char[] c=s.toCharArray();
        for (int i=0;i<c.length;i++) {
            if (c[i] == '(' || c[i] == '[' || c[i] == '{') {
                stack.push(c[i]);
            } else {
                if (stack.isEmpty()) {
                    return false; 
                }
                char top = stack.pop();
                if ((c[i] == ')' && top != '(') || (c[i] == ']' && top != '[') || (c[i] == '}' && top != '{')) {
                    return false; 
                }
            }
        }

        return stack.isEmpty();
        
    }
}