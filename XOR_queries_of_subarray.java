/*
 * 1310. XOR Queries of a Subarray
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an array arr of positive integers. You are also given the array
 * queries where queries[i] = [lefti, righti].
 * 
 * For each query i compute the XOR of elements from lefti to righti (that is,
 * arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).
 * 
 * Return an array answer where answer[i] is the answer to the ith query.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * Output: [2,7,14,8]
 * Explanation:
 * The binary representation of the elements in the array are:
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * The XOR values for queries are:
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 * Example 2:
 * 
 * Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * Output: [8,0,4,4]
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length, queries.length <= 3 * 104
 * 1 <= arr[i] <= 109
 * queries[i].length == 2
 * 0 <= lefti <= righti < arr.length
 */

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXOR = new int[n + 1]; // Prefix XOR array

        // Compute the prefix XOR array
        for (int i = 1; i <= n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i - 1];
        }

        int[] result = new int[queries.length];

        // Answer each query using the prefix XOR array
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];
            result[i] = prefixXOR[R + 1] ^ prefixXOR[L];
        }

        return result;
    }
}

/*
 * Explanation:
 * Prefix XOR Array:
 * 
 * prefixXOR[i] represents the XOR of all elements from arr[0] to arr[i-1].
 * For example, if arr = [1, 3, 4, 8], the prefix XOR array will be [0, 1, 2, 6,
 * 14].
 * Query Resolution:
 * 
 * For each query [L, R], we compute the result as prefixXOR[R + 1] ^
 * prefixXOR[L], which gives the XOR of elements from index L to R.
 * Example:
 * 
 * For queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}} and arr = [1, 3, 4, 8], the
 * result will be [2, 7, 14, 8].
 */