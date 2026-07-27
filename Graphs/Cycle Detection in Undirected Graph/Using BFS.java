// Detect Cycle in an Undirected Graph using BFS

/*
Approach (BFS + Parent Tracking)

- Since the graph may be disconnected, check every vertex.
- If a vertex is unvisited, start BFS from it.
- Store:
      node
      parent of node

- For every neighbour:
    1. If it is unvisited:
           mark it visited
           add it to the queue
           store current node as its parent

    2. If it is already visited and it is not the parent:
           A cycle exists.

Why ignore the parent?

In an undirected graph:

    0 ---- 1

If we are at 1, then 0 is already visited,
but the edge 1 → 0 is simply the same edge
through which we arrived.

So it is not a cycle.

Time Complexity: O(V + E)

Space Complexity: O(V)
*/

class Pair {

    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Solution {

    public boolean isCycle(
            int V,
            ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];

        // Handle disconnected components
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (bfs(i, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfs(
            int start,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(start, -1));

        visited[start] = true;

        while (!q.isEmpty()) {

            Pair current = q.poll();

            int node = current.node;
            int parent = current.parent;

            for (int neighbour : adj.get(node)) {

                // Unvisited neighbour
                if (!visited[neighbour]) {

                    visited[neighbour] = true;

                    q.offer(
                        new Pair(node == neighbour
                            ? neighbour
                            : neighbour,
                            node)
                    );
                }

                // Visited neighbour that is not parent
                else if (neighbour != parent) {

                    return true;
                }
            }
        }

        return false;
    }
}
