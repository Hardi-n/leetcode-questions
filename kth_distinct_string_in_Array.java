/*
 * 2053. Kth Distinct String in an Array
 * Easy
 * Topics
 * Companies
 * Hint
 * A distinct string is a string that is present only once in an array.
 * 
 * Given an array of strings arr, and an integer k, return the kth distinct
 * string present in arr. If there are fewer than k distinct strings, return an
 * empty string "".
 * 
 * Note that the strings are considered in the order in which they appear in the
 * array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = ["d","b","c","b","c","a"], k = 2
 * Output: "a"
 * Explanation:
 * The only distinct strings in arr are "d" and "a".
 * "d" appears 1st, so it is the 1st distinct string.
 * "a" appears 2nd, so it is the 2nd distinct string.
 * Since k == 2, "a" is returned.
 * Example 2:
 * 
 * Input: arr = ["aaa","aa","a"], k = 1
 * Output: "aaa"
 * Explanation:
 * All strings in arr are distinct, so the 1st string "aaa" is returned.
 * Example 3:
 * 
 * Input: arr = ["a","b","a"], k = 3
 * Output: ""
 * Explanation:
 * The only distinct string is "b". Since there are fewer than 3 distinct
 * strings, we return an empty string "".
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= arr.length <= 1000
 * 1 <= arr[i].length <= 5
 * arr[i] consists of lowercase English letters.
 */

class Solution {
    public String kthDistinct(String[] arr, int k) {
        // Step 1: Count the frequency of each string
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String s : arr) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }

        // Step 2: Collect distinct strings
        ArrayList<String> distinctStrings = new ArrayList<>();
        for (String s : arr) {
            if (frequencyMap.get(s) == 1) {
                distinctStrings.add(s);
            }
        }

        // Step 3: Return the k-th distinct string, if it exists
        if (k <= distinctStrings.size()) {
            return distinctStrings.get(k - 1); // k is 1-based, so use k-1
        } else {
            return ""; // Return an empty string if k is out of bounds
        }
    }
}

/*
 * 
 * Explanation:
 * Step 1: Frequency Counting:
 * We create a HashMap to store the frequency of each string in the array. For
 * each string, if it's already in the map, we increase its count; otherwise, we
 * add it to the map with a count of 1.
 * Step 2: Collect Distinct Strings:
 * We go through the array again and check for strings that have a frequency of
 * 1 (distinct). These distinct strings are added to a list in the order they
 * appear in the array.
 * Step 3: Return the k-th Distinct String:
 * If k is less than or equal to the size of the distinct strings list, we
 * return the k-th string (1-based index). Otherwise, we return an empty string.
 */