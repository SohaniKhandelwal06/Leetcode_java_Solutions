// Detect Cycle in a Directed Graph using DFS

/*
Approach (DFS + Recursion Stack)

- Use two arrays:

  visited[]      → Node has been visited.

  pathVisited[]  → Node is currently
                   present in the DFS path.

- Perform DFS from every unvisited node.

- While exploring neighbours:

    1. If neighbour is unvisited:
           DFS(neighbour)

    2. If neighbour is already present
       in the current recursion path,
       a cycle exists.

- Before returning from DFS,
  remove the node from the current path.

Time Complexity: O(V + E)

Space Complexity: O(V)
*/

class Solution {

    public boolean isCyclic(
            int V,
            ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];

        boolean[] pathVisited =
            new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(
                        i,
                        adj,
                        visited,
                        pathVisited)) {

                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(
            int node,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited,
            boolean[] pathVisited) {

        visited[node] = true;

        pathVisited[node] = true;

        for (int neighbour : adj.get(node)) {

            // Visit unvisited neighbour
            if (!visited[neighbour]) {

                if (dfs(
                        neighbour,
                        adj,
                        visited,
                        pathVisited)) {

                    return true;
                }
            }

            // Node already in current DFS path
            else if (pathVisited[neighbour]) {

                return true;
            }
        }

        // Remove node from recursion path
        pathVisited[node] = false;

        return false;
    }
}
