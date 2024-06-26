/*
 * 38. Count and Say
Medium
Topics
Companies
Hint
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the run-length encoding of countAndSay(n - 1).
Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

Given a positive integer n, return the nth element of the count-and-say sequence.

 

Example 1:

Input: n = 4

Output: "1211"

Explanation:

countAndSay(1) = "1"
countAndSay(2) = RLE of "1" = "11"
countAndSay(3) = RLE of "11" = "21"
countAndSay(4) = RLE of "21" = "1211"
Example 2:

Input: n = 1

Output: "1"

Explanation:

This is the base case.

 

Constraints:

1 <= n <= 30
 */

class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String result = "1";

        for (int i = 1; i < n; i++) {
            result = getNextSequence(result);
        }

        return result;
    }

    private String getNextSequence(String sequence) {
        StringBuilder nextSequence = new StringBuilder();
        int count = 1;

        for (int i = 1; i < sequence.length(); i++) {
            if (sequence.charAt(i) == sequence.charAt(i - 1)) {
                count++;
            } else {
                nextSequence.append(count).append(sequence.charAt(i - 1));
                count = 1;
            }
        }

        nextSequence.append(count).append(sequence.charAt(sequence.length() - 1));
        return nextSequence.toString();
    }
}

/*
added git config --global user.email "subhgyachhabra18718@gmail.com"
added git config --global user.name "Hardi-n"
updated email id
 * Approach
 * 1.Start with the First Term: Initialize the sequence with "1".
 * 2.Generate Each Term: Use a loop to generate each term from the previous term
 *      until reaching the nth term.
 * 3.Read Off the Digits: For each term, read off the digits, count the number
 *      of consecutive digits, and construct the next term.
 */