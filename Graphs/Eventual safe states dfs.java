// Leetcode 802 - Find Eventual Safe States (DFS)

/*
Approach (DFS + Cycle Detection)

- Use three arrays:

  visited[]      -> Node has been visited.

  pathVisited[]  -> Node is currently in the DFS path.

  safe[]         -> Marks whether a node is safe.

- Perform DFS from every unvisited node.

- If DFS finds a cycle:
      return true

- If no cycle is found:
      mark the current node as safe.

- Finally, collect all safe nodes.

Time Complexity: O(V + E)

Space Complexity: O(V)
*/

class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        boolean[] safe = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                dfs(i, graph, visited, pathVisited, safe);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (safe[i]) {

                ans.add(i);
            }
        }

        return ans;
    }

    private boolean dfs(
            int node,
            int[][] graph,
            boolean[] visited,
            boolean[] pathVisited,
            boolean[] safe) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbour : graph[node]) {

            if (!visited[neighbour]) {

                if (dfs(neighbour,
                        graph,
                        visited,
                        pathVisited,
                        safe)) {

                    return true;
                }
            }

            else if (pathVisited[neighbour]) {

                return true;
            }
        }

        pathVisited[node] = false;

        safe[node] = true;

        return false;
    }
}
