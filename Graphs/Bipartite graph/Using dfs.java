// Check if a Graph is Bipartite using DFS

/*
Approach (DFS + 2-Coloring)

- Use a color array.
- color[i] = -1 means the node is uncolored.
- For every uncolored node:
    - Assign color 0.
    - Start DFS.
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

                color[i] = 0;

                if (!dfs(i, graph, color)) {

                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(
            int node,
            int[][] graph,
            int[] color) {

        for (int neighbour : graph[node]) {

            // If neighbour is uncolored
            if (color[neighbour] == -1) {

                // Assign opposite color
                color[neighbour] =
                    1 - color[node];

                if (!dfs(
                        neighbour,
                        graph,
                        color)) {

                    return false;
                }
            }

            // Adjacent nodes have same color
            else if (color[neighbour] ==
                     color[node]) {

                return false;
            }
        }

        return true;
    }
}
