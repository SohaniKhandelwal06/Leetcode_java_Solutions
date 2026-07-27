// Check if a Graph is Bipartite using BFS

/*
Approach (BFS + 2-Coloring)

- Use a color array.
- color[i] = -1 means the node is not colored.
- For every unvisited node:
    - Assign color 0.
    - Start BFS.
- For every neighbour:
    - If uncolored, assign the opposite color.
    - If already colored with the same color,
      the graph is not bipartite.

The graph may be disconnected,
so we check every vertex.

Time Complexity: O(V + E)

Space Complexity: O(V)
*/

class Solution {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];

        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {

                if (!bfs(i, graph, color)) {

                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(
            int start,
            int[][] graph,
            int[] color) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        color[start] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int neighbour : graph[node]) {

                // If neighbour is not colored
                if (color[neighbour] == -1) {

                    // Assign opposite color
                    color[neighbour] =
                        1 - color[node];

                    q.offer(neighbour);
                }

                // Same color on adjacent nodes
                else if (color[neighbour] ==
                         color[node]) {

                    return false;
                }
            }
        }

        return true;
    }
}
