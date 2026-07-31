// Dijkstra's Algorithm (Priority Queue)
//
// Approach:
//
// - Store (distance, node) in a min-heap.
// - Initialize all distances as INF.
// - Source distance = 0.
// - While the priority queue is not empty:
//      Remove the node having minimum distance.
//      Relax all adjacent edges.
//      If a shorter distance is found,
//      update it and push it into the priority queue.
//
// Works only for graphs having
// non-negative edge weights.
//
// Time Complexity: O((V + E) log V)
//
// Space Complexity: O(V + E)

class Pair {

    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Solution {

    public int[] dijkstra(
            int V,
            ArrayList<ArrayList<ArrayList<Integer>>> adj,
            int S) {

        PriorityQueue<Pair> pq =
            new PriorityQueue<>(
                (a, b) -> a.distance - b.distance
            );

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;

        pq.offer(new Pair(0, S));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int distance = current.distance;

            for (ArrayList<Integer> edge : adj.get(node)) {

                int neighbour = edge.get(0);
                int weight = edge.get(1);

                if (distance + weight < dist[neighbour]) {

                    dist[neighbour] =
                        distance + weight;

                    pq.offer(
                        new Pair(
                            dist[neighbour],
                            neighbour
                        )
                    );
                }
            }
        }

        return dist;
    }
}
