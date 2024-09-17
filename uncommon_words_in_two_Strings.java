/*
 * 
 * 884. Uncommon Words from Two Sentences
 * Easy
 * Topics
 * Companies
 * A sentence is a string of single-space separated words where each word
 * consists only of lowercase letters.
 * 
 * A word is uncommon if it appears exactly once in one of the sentences, and
 * does not appear in the other sentence.
 * 
 * Given two sentences s1 and s2, return a list of all the uncommon words. You
 * may return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "this apple is sweet", s2 = "this apple is sour"
 * 
 * Output: ["sweet","sour"]
 * 
 * Explanation:
 * 
 * The word "sweet" appears only in s1, while the word "sour" appears only in
 * s2.
 * 
 * Example 2:
 * 
 * Input: s1 = "apple apple", s2 = "banana"
 * 
 * Output: ["banana"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s1.length, s2.length <= 200
 * s1 and s2 consist of lowercase English letters and spaces.
 * s1 and s2 do not have leading or trailing spaces.
 * All the words in s1 and s2 are separated by a single space.
 */


public class uncommon_words_in_two_Strings {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Split sentences into words
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
        // Create a HashMap to store the frequency of each word
        HashMap<String, Integer> frequencyMap = new HashMap<>();

        // Count frequency of words in s1
        for (String word : words1) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Count frequency of words in s2
        for (String word : words2) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Create a set to store uncommon words
        HashSet<String> uncommonWords = new HashSet<>();

        // Add words from words1 with frequency 1
        for (String word : words1) {
            if (frequencyMap.get(word) == 1) {
                uncommonWords.add(word);
            }
        }

        // Add words from words2 with frequency 1
        for (String word : words2) {
            if (frequencyMap.get(word) == 1) {
                uncommonWords.add(word);
            }
        }

        // Convert the final set to an array
        String[] result = uncommonWords.toArray(new String[0]);
        
        return result;
    }
}


/*
 * 
 * Approach
 * 1. split the given strings
 * 2. add the words for both arrays in hashmap for calculating frequency of each word
 * 3. if the frequency is 1 then add it in hashset 
 * 4. convert hashset into string array and return it
 *  
 */