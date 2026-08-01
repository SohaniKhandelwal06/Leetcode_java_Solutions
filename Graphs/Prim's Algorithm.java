// Prim's Algorithm (Minimum Spanning Tree)
//
// Approach:
//
// - Start from any node (0).
// - Mark it as visited.
// - Push all adjacent edges into a min-heap.
// - Repeatedly remove the minimum-weight edge.
// - If its destination node is already visited,
//   ignore it.
// - Otherwise:
//      Add its weight to the MST.
//      Mark the node as visited.
//      Push all of its adjacent edges.
//
// Continue until all vertices are included.
//
// Time Complexity: O(E log V)
//
// Space Complexity: O(V + E)

class Pair {

    int weight;
    int node;

    Pair(int weight, int node) {
        this.weight = weight;
        this.node = node;
    }
}

class Solution {

    static int spanningTree(
            int V,
            ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        boolean[] vis = new boolean[V];

        PriorityQueue<Pair> pq =
            new PriorityQueue<>(
                (a, b) -> a.weight - b.weight
            );

        pq.offer(new Pair(0, 0));

        int sum = 0;

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int wt = current.weight;
            int node = current.node;

            if (vis[node]) {
                continue;
            }

            vis[node] = true;

            sum += wt;

            for (ArrayList<Integer> edge : adj.get(node)) {

                int neighbour = edge.get(0);
                int weight = edge.get(1);

                if (!vis[neighbour]) {

                    pq.offer(
                        new Pair(
                            weight,
                            neighbour
                        )
                    );
                }
            }
        }

        return sum;
    }
}
