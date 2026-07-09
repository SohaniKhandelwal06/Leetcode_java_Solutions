// M-Coloring Problem

/*
Approach (Recursion + Backtracking):
1. Build the graph using an adjacency list.
2. Maintain a color array where 0 indicates an uncolored vertex.
3. Start coloring vertices one by one.
4. For each vertex, try all colors from 1 to M.
5. Assign a color only if none of its adjacent vertices has the same color.
6. Recursively color the next vertex.
7. If no valid color can be assigned, backtrack by removing the assigned color.
8. Return true if all vertices are successfully colored; otherwise, return false.

Time Complexity: O(M^V)
Space Complexity: O(V)
*/

class Solution {
    public boolean graphColoring(int v, List<int[]> edges, int m) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[v];

        return solve(0, adj, color, m);
    }

    private boolean solve(int node, List<List<Integer>> adj, int[] color, int m) {
        if (node == adj.size()) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, adj, color, c)) {
                color[node] = c;

                if (solve(node + 1, adj, color, m)) {
                    return true;
                }

                color[node] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(int node, List<List<Integer>> adj, int[] color, int c) {
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == c) {
                return false;
            }
        }

        return true;
    }
}
