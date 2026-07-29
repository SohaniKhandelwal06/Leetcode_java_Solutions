// Detect Cycle in a Directed Graph using Kahn's Algorithm

/*
Approach (BFS + Indegree)

- Calculate the indegree of every vertex.
- Add all vertices having indegree 0 to the queue.
- Perform BFS:
      Remove a node.
      Increase processed node count.
      Decrease indegree of its neighbours.
      If neighbour's indegree becomes 0,
      add it to the queue.

- If processed node count is less than V,
  the graph contains a cycle.

Why?

Nodes inside a cycle never become
indegree 0.

Time Complexity: O(V + E)

Space Complexity: O(V)
*/

class Solution {

    public boolean isCyclic(
            int V,
            ArrayList<ArrayList<Integer>> adj) {

        int[] indegree = new int[V];

        // Calculate indegree
        for (int i = 0; i < V; i++) {

            for (int neighbour : adj.get(i)) {

                indegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Add all nodes with indegree 0
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {

                q.offer(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            count++;

            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {

                    q.offer(neighbour);
                }
            }
        }

        // If all nodes are processed,
        // no cycle exists.
        return count != V;
    }
}
