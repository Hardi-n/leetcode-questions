/*
 * 726. Number of Atoms
 * Hard
 * Topics
 * Companies
 * Hint
 * Given a string formula representing a chemical formula, return the count of
 * each atom.
 * 
 * The atomic element always starts with an uppercase character, then zero or
 * more lowercase letters, representing the name.
 * 
 * One or more digits representing that element's count may follow if the count
 * is greater than 1. If the count is 1, no digits will follow.
 * 
 * For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
 * Two formulas are concatenated together to produce another formula.
 * 
 * For example, "H2O2He3Mg4" is also a formula.
 * A formula placed in parentheses, and a count (optionally added) is also a
 * formula.
 * 
 * For example, "(H2O2)" and "(H2O2)3" are formulas.
 * Return the count of all elements as a string in the following form: the first
 * name (in sorted order), followed by its count (if that count is more than 1),
 * followed by the second name (in sorted order), followed by its count (if that
 * count is more than 1), and so on.
 * 
 * The test cases are generated so that all the values in the output fit in a
 * 32-bit integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: formula = "H2O"
 * Output: "H2O"
 * Explanation: The count of elements are {'H': 2, 'O': 1}.
 * Example 2:
 * 
 * Input: formula = "Mg(OH)2"
 * Output: "H2MgO2"
 * Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * Example 3:
 * 
 * Input: formula = "K4(ON(SO3)2)2"
 * Output: "K4N2O14S4"
 * Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 * 
 * 
 * Constraints:
 * 
 * 1 <= formula.length <= 1000
 * formula consists of English letters, digits, '(', and ')'.
 * formula is always valid.
 */

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> current = new HashMap<>();
        int n = formula.length();
        int i = 0;

        while (i < n) {
            char c = formula.charAt(i);

            if (c == '(') {
                // Push the current map to stack and start a new one for inner parentheses
                stack.push(current);
                current = new HashMap<>();
                i++;
            } else if (c == ')') {
                // Process the multiplier following the closing parenthesis
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i)))
                    i++;
                int multiplier = (start < i) ? Integer.parseInt(formula.substring(start, i)) : 1;

                // Pop from stack and merge
                Map<String, Integer> prev = stack.pop();
                for (String atom : current.keySet()) {
                    current.put(atom, current.get(atom) * multiplier);
                }

                // Merge with the previous map
                for (String atom : current.keySet()) {
                    prev.put(atom, prev.getOrDefault(atom, 0) + current.get(atom));
                }

                current = prev;
            } else if (Character.isUpperCase(c)) {
                // Process element name
                int start = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i)))
                    i++;
                String atom = formula.substring(start, i);

                // Process the number following the element (if any)
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i)))
                    i++;
                int count = (start < i) ? Integer.parseInt(formula.substring(start, i)) : 1;

                // Update the count in the current map
                current.put(atom, current.getOrDefault(atom, 0) + count);
            }
        }

        // Sort the elements by name and build the result
        StringBuilder sb = new StringBuilder();
        List<String> atoms = new ArrayList<>(current.keySet());
        Collections.sort(atoms);
        for (String atom : atoms) {
            sb.append(atom);
            int count = current.get(atom);
            if (count > 1)
                sb.append(count);
        }

        return sb.toString();
    }
}

/*
 * Explanation:
 * Stack: We use a stack to handle nested parentheses. Each time we encounter an
 * opening parenthesis (, we push the current map to the stack and start fresh.
 * When encountering ), we multiply the contents of the current map by the
 * number following the closing parenthesis and merge it with the previous map.
 * 
 * Element Parsing: When encountering an element (starting with an uppercase
 * letter, possibly followed by lowercase letters), we extract its name and
 * check if it's followed by a number, updating the element's count in the
 * current map.
 * 
 * Sorting and Result: After parsing, we sort the atoms alphabetically and
 * concatenate them with their counts to return the final result.
 */

/*
 * 
 * Approach:
 * Use a stack to store maps of elements and their counts.
 * Traverse the formula and process elements, numbers, and parentheses.
 * Multiply the counts of atoms inside parentheses if a number follows the
 * closing parenthesis.
 */