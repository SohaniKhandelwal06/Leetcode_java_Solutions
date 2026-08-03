// Dijkstra's Algorithm
//
// Approach:
//
// - Initialize all distances as INF.
// - Source distance = 0.
// - Push (distance, node) into a min-heap.
// - While the priority queue is not empty:
//      Remove the node with minimum distance.
//      Relax all adjacent edges.
//      If a shorter path is found,
//      update the distance and push it again.
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

    static int[] dijkstra(
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

            Pair curr = pq.poll();

            int node = curr.node;
            int dis = curr.distance;

            // Skip outdated entries
            if (dis > dist[node]) {
                continue;
            }

            for (ArrayList<Integer> edge : adj.get(node)) {

                int neighbour = edge.get(0);
                int weight = edge.get(1);

                if (dis + weight < dist[neighbour]) {

                    dist[neighbour] =
                        dis + weight;

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
