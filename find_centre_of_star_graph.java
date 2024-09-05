/*
 * 1791. Find Center of Star Graph
 * Easy
 * Topics
 * Companies
 * Hint
 * There is an undirected star graph consisting of n nodes labeled from 1 to n.
 * A star graph is a graph where there is one center node and exactly n - 1
 * edges that connect the center node with every other node.
 * 
 * You are given a 2D integer array edges where each edges[i] = [ui, vi]
 * indicates that there is an edge between the nodes ui and vi. Return the
 * center of the given star graph.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: edges = [[1,2],[2,3],[4,2]]
 * Output: 2
 * Explanation: As shown in the figure above, node 2 is connected to every other
 * node, so 2 is the center.
 * Example 2:
 * 
 * Input: edges = [[1,2],[5,1],[1,3],[1,4]]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 3 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 * The given edges represent a valid star graph.
 */

class Solution {
    public int findCenter(int[][] edges) {
        // In a star graph, the center node will appear in both of the first two edges.
        // We just need to check which node is common in the first two edges.

        int node1 = edges[0][0];
        int node2 = edges[0][1];
        int node3 = edges[1][0];
        int node4 = edges[1][1];

        // Check which node is common in the first two edges
        if (node1 == node3 || node1 == node4) {
            return node1;
        } else {
            return node2;
        }
    }
}

/*
 * 
 * Explanation:
 * We extract the first two edges: (node1, node2) from the first edge and
 * (node3, node4) from the second edge.
 * The center node will be common in both edges.
 * If node1 is equal to either node3 or node4, then node1 is the center.
 * Otherwise, node2 is the center.
 */

/*
 * In the case of a star graph, the graph has a specific structure: it consists
 * of one central node connected to all other nodes, but none of the outer nodes
 * are connected to each other. Therefore, the center of the star graph can be
 * found directly by analyzing the edges.
 * 
 * In a star graph, the center is the node that appears in all edges. For
 * example, in a graph with edges
 * (
 * 1
 * ,
 * 2
 * )
 * ,
 * (
 * 1
 * ,
 * 3
 * )
 * ,
 * (
 * 1
 * ,
 * 4
 * )
 * (1,2),(1,3),(1,4), the center node is 1 because it is connected to all other
 * nodes.
 * 
 * You can solve the problem of finding the center of a star graph in a very
 * simple and efficient way by checking the first two edges. Since the center
 * node must appear in all edges, it must appear in the first two edges as well.
 * 
 * Here’s a simplified approach to find the center of a star graph in O(1) time:
 */