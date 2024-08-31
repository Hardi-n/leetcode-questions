/*1071. Greatest Common Divisor of Strings
Easy
Topics
Companies
Hint
For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.*/



public class GCDOfString {

    // Function to find the greatest common divisor of two strings
    public static String gcdOfStrings(String str1, String str2) {
        // If concatenation of the two strings in both orders is not equal,
        // then there is no common divisor string
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // The GCD of the lengths of the two strings will give us the length
        // of the greatest common divisor string
        int gcdLength = gcd(str1.length(), str2.length());

        // Return the substring of str1 (or str2) from 0 to gcdLength
        return str1.substring(0, gcdLength);
    }

    // Helper function to find the GCD of two integers
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        // Test cases
        String str1 = "ABCABC";
        String str2 = "ABC";
        
        System.out.println("GCD of " + str1 + " and " + str2 + " is: " + gcdOfStrings(str1, str2));

        String str3 = "ABABAB";
        String str4 = "ABAB";
        
        System.out.println("GCD of " + str3 + " and " + str4 + " is: " + gcdOfStrings(str3, str4));

        String str5 = "LEET";
        String str6 = "CODE";
        
        System.out.println("GCD of " + str5 + " and " + str6 + " is: " + gcdOfStrings(str5, str6));
    }
}



/*
Explanation:
gcdOfStrings Method:

Concatenation Check: First, it checks whether str1 + str2 is equal to str2 + str1. If not, there's no possible GCD string, and the method returns an empty string. This check ensures that both strings are composed of some repeated pattern.
Length GCD: If the concatenation condition passes, the GCD of the lengths of str1 and str2 is calculated. This GCD gives the length of the largest possible common divisor string.
Return GCD String: The method then returns the substring of str1 (or str2, since they share the same repeated pattern) from index 0 to the calculated GCD length.
gcd Method:

This is a helper method to calculate the GCD of two integers using the Euclidean algorithm.
main Method:

This contains test cases to demonstrate how the gcdOfStrings function works.
Example Outputs:
For the input str1 = "ABCABC" and str2 = "ABC", the output is "ABC" because "ABC" is the greatest common divisor string that can construct both str1 and str2.

For the input str3 = "ABABAB" and str4 = "ABAB", the output is "AB" because "AB" can construct both strings.

For the input str5 = "LEET" and str6 = "CODE", the output is an empty string "" because there is no common substring that can construct both strings.

This approach efficiently determines the greatest common divisor of two strings by leveraging string properties and the Euclidean algorithm.

*/
