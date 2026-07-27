// DFS Traversal of Graph

/*
Approach (Recursion + Visited Array)

- Start from the source vertex.
- Mark the current vertex as visited.
- Add it to the answer.
- Recursively visit every unvisited neighbour.

A visited array is required because a graph can contain cycles.

Time Complexity: O(V + E)

Space Complexity: O(V)

where:
V = Number of vertices
E = Number of edges
*/

class Solution {

    public ArrayList<Integer> dfs(
            ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();

        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[V];

        dfsHelper(0, adj, visited, ans);

        return ans;
    }

    private void dfsHelper(
            int node,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited,
            ArrayList<Integer> ans) {

        // Mark node as visited
        visited[node] = true;

        // Add node to answer
        ans.add(node);

        // Visit all unvisited neighbours
        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {

                dfsHelper(
                    neighbour,
                    adj,
                    visited,
                    ans
                );
            }
        }
    }
}
