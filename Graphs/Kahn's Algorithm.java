// Kahn's Algorithm (Topological Sort using BFS)

/*
Approach

- Calculate the indegree of every vertex.
- Add all vertices with indegree 0 to the queue.
- While the queue is not empty:
    - Remove a node.
    - Add it to the answer.
    - Decrease the indegree of all its neighbours.
    - If any neighbour's indegree becomes 0,
      add it to the queue.

The produced order is a valid
Topological Ordering.

Works only for Directed Acyclic Graphs (DAG).

Time Complexity: O(V + E)

Space Complexity: O(V)
*/

class Solution {

    static ArrayList<Integer> topoSort(
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

        // Add all vertices with indegree 0
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {

                q.offer(i);
            }
        }

        ArrayList<Integer> ans =
                new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();

            ans.add(node);

            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {

                    q.offer(neighbour);
                }
            }
        }

        return ans;
    }
}
