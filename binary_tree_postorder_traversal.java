/*
 * 145. Binary Tree Postorder Traversal
 * Easy
 * Topics
 * Companies
 * Given the root of a binary tree, return the postorder traversal of its nodes'
 * values.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 * Example 2:
 * 
 * Input: root = []
 * Output: []
 * Example 3:
 * 
 * Input: root = [1]
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        // Traverse left subtree
        postorder(node.left, result);

        // Traverse right subtree
        postorder(node.right, result);

        // Visit the root node
        result.add(node.val);
    }
}

/*
 * 
 * Explanation:
 * Recursive Approach:
 * Base Case: If the current node is null, return immediately.
 * Recursive Case: Traverse the left subtree, then the right subtree, and
 * finally, add the current node's value to the result list.
 */