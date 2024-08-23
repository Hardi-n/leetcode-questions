/*
 * 166. Fraction to Recurring Decimal
 * Medium
 * Topics
 * Companies
 * Hint
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * If multiple answers are possible, return any of them.
 * 
 * It is guaranteed that the length of the answer string is less than 104 for
 * all the given inputs.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 * 
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 * 
 * Input: numerator = 4, denominator = 333
 * Output: "0.(012)"
 * 
 * 
 * Constraints:
 * 
 * -231 <= numerator, denominator <= 231 - 1
 * denominator != 0
 */

import java.util.HashMap;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        StringBuilder result = new StringBuilder();

        // Determine the sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert to absolute values
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append the integer part
        result.append(num / den);
        long remainder = num % den;

        if (remainder == 0)
            return result.toString();

        // Append the decimal part
        result.append(".");
        HashMap<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int start = map.get(remainder);
                result.insert(start, "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }
}

/*
 * 
 * 
 * Explanation:
 * Sign Handling: We use the XOR (^) operator to check if exactly one of the
 * numerator or denominator is negative, which would make the result negative.
 * HashMap for Remainders: We map each remainder to its corresponding position
 * in the decimal part. If the same remainder is encountered again, we know that
 * the decimal sequence has started repeating from that position.
 * Loop for Decimal Calculation: We continue to generate the next digit of the
 * decimal until either the remainder becomes 0 (no repetition), or we detect a
 * repetition using the HashMap.
 */

/*
 * Steps:
 * Determine the Sign:
 * 
 * The result will be negative if either the numerator or denominator is
 * negative, but not both.
 * Convert to Absolute Values:
 * 
 * Work with the absolute values of the numerator and denominator to simplify
 * the calculation.
 * Compute the Integer Part:
 * 
 * Perform integer division to get the integer part of the fraction.
 * Compute the Fractional Part:
 * 
 * Use the remainder from the integer division to compute the decimal part.
 * Detect Recurring Sequence:
 * 
 * Use a HashMap to track each remainder's index in the result string.
 * If a remainder repeats, a cycle is detected, and you can insert parentheses
 * around the repeating part.
 * Return the Result:
 * 
 * If there is no fractional part, return the integer part.
 * If there is a fractional part but no repetition, return the full decimal.
 * If there is a repeating part, enclose the repeating sequence in parentheses.
 */