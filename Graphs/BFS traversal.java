// BFS Traversal of Graph

/*
Approach (Queue + Visited Array)

- Use a Queue for BFS.
- Mark a node as visited when adding it to the queue.
- Remove a node from the queue.
- Add all its unvisited neighbours.

Why mark visited while adding?

If we wait until removing from the queue,
the same node can be added multiple times
through different paths.

Time Complexity: O(V + E)

Space Complexity: O(V)

where:
V = Number of vertices
E = Number of edges
*/

class Solution {

    public ArrayList<Integer> bfs(
            ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();

        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();

        // Start BFS from vertex 0
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            ans.add(node);

            for (int neighbour : adj.get(node)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;

                    q.offer(neighbour);
                }
            }
        }

        return ans;
    }
}
