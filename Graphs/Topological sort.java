// Topological Sort using DFS + Stack

/*
Approach:

- Use a visited array.
- Perform DFS from every unvisited vertex.
- Visit all neighbours first.
- After all neighbours are processed,
  push the current node into the stack.
- Pop the stack to get the topological order.

This works only for a DAG
(Directed Acyclic Graph).

Time Complexity: O(V + E)

Space Complexity: O(V)
*/

class Solution {

    public ArrayList<Integer> topoSort(
            int V,
            ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                dfs(i, adj, vis, st);
            }
        }

        ArrayList<Integer> ans =
            new ArrayList<>();

        while (!st.isEmpty()) {

            ans.add(st.pop());
        }

        return ans;
    }

    private void dfs(
            int node,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] vis,
            Stack<Integer> st) {

        vis[node] = true;

        for (int neighbour : adj.get(node)) {

            if (!vis[neighbour]) {

                dfs(
                    neighbour,
                    adj,
                    vis,
                    st
                );
            }
        }

        // Push after all neighbours are processed
        st.push(node);
    }
}
