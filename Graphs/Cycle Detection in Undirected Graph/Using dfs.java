// Detect Cycle in an Undirected Graph using DFS

/*
Approach (DFS + Parent Tracking)

- The graph may be disconnected, so check every vertex.
- If a vertex is unvisited, start DFS from it.
- Pass the parent of the current node.

For every neighbour:

1. If the neighbour is unvisited:
       Recursively visit it.

2. If the neighbour is already visited
   and it is not the parent:
       A cycle exists.

Why ignore the parent?

In an undirected graph:

    0 ---- 1

While processing 1, node 0 is already visited.
But 0 is the parent of 1, so this is the same edge
through which we arrived.

Therefore, it is not a cycle.

Time Complexity: O(V + E)

Space Complexity: O(V)
*/

class Solution {

    public boolean isCycle(
            int V,
            ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];

        // Handle disconnected components
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(
            int node,
            int parent,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {

        visited[node] = true;

        for (int neighbour : adj.get(node)) {

            // If neighbour is not visited,
            // recursively visit it
            if (!visited[neighbour]) {

                if (dfs(
                        neighbour,
                        node,
                        adj,
                        visited)) {

                    return true;
                }
            }

            // Visited neighbour which is not parent
            else if (neighbour != parent) {

                return true;
            }
        }

        return false;
    }
}
