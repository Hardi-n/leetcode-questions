/*
 * 2045. Second Minimum Time to Reach Destination
 * Hard
 * Topics
 * Companies
 * Hint
 * A city is represented as a bi-directional connected graph with n vertices
 * where each vertex is labeled from 1 to n (inclusive). The edges in the graph
 * are represented as a 2D integer array edges, where each edges[i] = [ui, vi]
 * denotes a bi-directional edge between vertex ui and vertex vi. Every vertex
 * pair is connected by at most one edge, and no vertex has an edge to itself.
 * The time taken to traverse any edge is time minutes.
 * 
 * Each vertex has a traffic signal which changes its color from green to red
 * and vice versa every change minutes. All signals change at the same time. You
 * can enter a vertex at any time, but can leave a vertex only when the signal
 * is green. You cannot wait at a vertex if the signal is green.
 * 
 * The second minimum value is defined as the smallest value strictly larger
 * than the minimum value.
 * 
 * For example the second minimum value of [2, 3, 4] is 3, and the second
 * minimum value of [2, 2, 4] is 4.
 * Given n, edges, time, and change, return the second minimum time it will take
 * to go from vertex 1 to vertex n.
 * 
 * Notes:
 * 
 * You can go through any vertex any number of times, including 1 and n.
 * You can assume that when the journey starts, all signals have just turned
 * green.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 5, edges = [[1,2],[1,3],[1,4],[3,4],[4,5]], time = 3, change = 5
 * Output: 13
 * Explanation:
 * The figure on the left shows the given graph.
 * The blue path in the figure on the right is the minimum time path.
 * The time taken is:
 * - Start at 1, time elapsed=0
 * - 1 -> 4: 3 minutes, time elapsed=3
 * - 4 -> 5: 3 minutes, time elapsed=6
 * Hence the minimum time needed is 6 minutes.
 * 
 * The red path shows the path to get the second minimum time.
 * - Start at 1, time elapsed=0
 * - 1 -> 3: 3 minutes, time elapsed=3
 * - 3 -> 4: 3 minutes, time elapsed=6
 * - Wait at 4 for 4 minutes, time elapsed=10
 * - 4 -> 5: 3 minutes, time elapsed=13
 * Hence the second minimum time is 13 minutes.
 * Example 2:
 * 
 * 
 * Input: n = 2, edges = [[1,2]], time = 3, change = 2
 * Output: 11
 * Explanation:
 * The minimum time path is 1 -> 2 with time = 3 minutes.
 * The second minimum time path is 1 -> 2 -> 1 -> 2 with time = 11 minutes.
 * 
 * 
 * Constraints:
 * 
 * 2 <= n <= 104
 * n - 1 <= edges.length <= min(2 * 104, n * (n - 1) / 2)
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 * There are no duplicate edges.
 * Each vertex can be reached directly or indirectly from every other vertex.
 * 1 <= time, change <= 103
 */

class Solution {
    static class Edge {
        int node, time;

        Edge(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // Create the graph as an adjacency list
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Edge(edge[1], time));
            graph.get(edge[1]).add(new Edge(edge[0], time));
        }

        // Arrays to store the minimum and second minimum time to reach each node
        int[] firstMin = new int[n + 1];
        int[] secondMin = new int[n + 1];
        Arrays.fill(firstMin, Integer.MAX_VALUE);
        Arrays.fill(secondMin, Integer.MAX_VALUE);

        // Priority queue to track current position and time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] { 1, 0 }); // Start from node 1 with time 0
        firstMin[1] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], currTime = current[1];

            // Explore all neighbors
            for (Edge edge : graph.get(node)) {
                int neighbor = edge.node;
                int travelTime = currTime + edge.time;

                // Handle traffic light wait time
                if ((currTime / change) % 2 == 1) { // if it's red light
                    travelTime += change - (currTime % change); // wait for green light
                }

                // Update firstMin and secondMin arrays for each neighbor
                if (travelTime < firstMin[neighbor]) {
                    secondMin[neighbor] = firstMin[neighbor];
                    firstMin[neighbor] = travelTime;
                    pq.add(new int[] { neighbor, travelTime });
                } else if (travelTime > firstMin[neighbor] && travelTime < secondMin[neighbor]) {
                    secondMin[neighbor] = travelTime;
                    pq.add(new int[] { neighbor, travelTime });
                }
            }
        }

        // The second minimum time to reach node n
        return secondMin[n];
    }
}

/*
 * 
 * Explanation:
 * Graph Representation:
 * We use an adjacency list to represent the road network between nodes
 * (cities).
 * Tracking Minimum and Second Minimum Times:
 * For each node, maintain two values: the minimum time and the second minimum
 * time to reach that node.
 * Use a priority queue to explore the shortest path first, updating the first
 * and second minimum times for each node as you find shorter paths.
 * Handling the Traffic Lights:
 * The time at which you reach a node might cause you to wait for the green
 * light if it's currently red. The traffic lights alternate every change
 * seconds.
 * If you reach an intersection during the red light, you wait for it to turn
 * green before continuing.
 */

/*
 * 
 * Key Points:
 * Graph Construction: We build an adjacency list based on the input edges,
 * where each road has a fixed travel time time.
 * 
 * Priority Queue (Min-Heap): This ensures that we process nodes in increasing
 * order of travel time, similar to Dijkstra’s algorithm.
 * 
 * Handling Traffic Lights: If you reach an intersection during the red light
 * (i.e., when (currTime / change) % 2 == 1), you wait until the green light.
 * 
 * Tracking First and Second Minimum Times: We update the first minimum and
 * second minimum travel times for each node. If the new path offers a better
 * solution for the second minimum time, it gets updated.
 * 
 * Time Complexity: The algorithm runs in O(E log V), where E is the number of
 * edges, and V is the number of nodes, due to the priority queue.
 */