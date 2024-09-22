/*
 * 68. Text Justification
 * Hard
 * Topics
 * Companies
 * Given an array of strings words and a width maxWidth, format the text such
 * that each line has exactly maxWidth characters and is fully (left and right)
 * justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line does not divide evenly between words, the
 * empty slots on the left will be assigned more spaces than the slots on the
 * right.
 * 
 * For the last line of text, it should be left-justified, and no extra space is
 * inserted between words.
 * 
 * Note:
 * 
 * A word is defined as a character sequence consisting of non-space characters
 * only.
 * Each word's length is guaranteed to be greater than 0 and not exceed
 * maxWidth.
 * The input array words contains at least one word.
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["This", "is", "an", "example", "of", "text",
 * "justification."], maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Example 2:
 * 
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth =
 * 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of
 * "shall     be", because the last line must be left-justified instead of
 * fully-justified.
 * Note that the second line is also left-justified because it contains only one
 * word.
 * Example 3:
 * 
 * Input: words =
 * ["Science","is","what","we","understand","well","enough","to","explain","to",
 * "a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        // Process each line
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;

            // Determine how many words can fit in this line
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth)
                    break;
                totalChars += 1 + words[last].length();
                last++;
            }

            // Build the line
            StringBuilder line = new StringBuilder();
            int numberOfWords = last - index;
            int numberOfSpaces = maxWidth - totalChars;

            // If it's the last line or contains only one word, left-justify
            if (last == words.length || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i != last - 1) {
                        line.append(" ");
                    }
                }

                // Fill the remaining space with spaces
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // Fully justify the line by distributing spaces
                int spaces = numberOfSpaces / (numberOfWords - 1);
                int extraSpaces = numberOfSpaces % (numberOfWords - 1);

                for (int i = index; i < last - 1; i++) {
                    line.append(words[i]);
                    line.append(" ");

                    // Add spaces evenly
                    for (int j = 0; j < spaces; j++) {
                        line.append(" ");
                    }

                    // Add an extra space to the left-most slots if necessary
                    if (extraSpaces > 0) {
                        line.append(" ");
                        extraSpaces--;
                    }
                }
                // Add the last word in the line
                line.append(words[last - 1]);
            }

            result.add(line.toString());
            index = last; // Move to the next line
        }

        return result;
    }
}

/*
 * 
 * Explanation:
 * Greedy Line Construction:
 * 
 * For each line, starting from the current index, try to fit as many words as
 * possible by checking the total characters and spaces.
 * Left-justify the Last Line:
 * 
 * If it’s the last line or there’s only one word in the line, the words are
 * left-justified, and the remaining spaces are filled with spaces at the end.
 * Fully Justify Other Lines:
 * 
 * For all other lines, spaces are distributed evenly between words. If the
 * number of spaces doesn't divide evenly between words, extra spaces are added
 * to the left-most slots.
 * Edge Case:
 * 
 * When there's only one word in the line, it’s left-justified by default.
 */