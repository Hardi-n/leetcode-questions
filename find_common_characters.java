/*
 * 1002. Find Common Characters
 * Easy
 * Topics
 * Companies
 * Given a string array words, return an array of all characters that show up in
 * all strings within the words (including duplicates). You may return the
 * answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 * 
 * Input: words = ["cool","lock","cook"]
 * Output: ["c","o"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of lowercase English letters.
 */

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] charCount = new int[26];
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charCount[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add("" + (char) (i + 'a'));
                minFreq[i]--;
            }
        }

        return result;
    }
}

/*
 * 
 * Explanation:
 * minFreq Array: Keeps track of the minimum frequency of each character ('a' to
 * 'z') across all strings.
 * charCount Array: Used to count the frequency of each character in the current
 * string.
 * Update minFreq: After processing each string, the minFreq array is updated
 * with the minimum frequency of each character encountered so far.
 * Construct Result: The result list is constructed by adding characters based
 * on their frequency in minFreq.
 * 
 * 
 * 
 * 
 * approach
 * 
 * 
 * To find common characters in an array of strings in Java, you can follow this
 * approach:
 * 
 * Initialize an array to keep track of the minimum frequency of each character
 * across all strings.
 * Iterate through each string and count the frequency of each character.
 * Update the minimum frequency array with the minimum frequency found across
 * all strings.
 * Finally, construct a list of common characters based on the minimum
 * frequencies.
 */