// Print Shortest Path using Dijkstra
//
// Approach:
//
// - Run Dijkstra's Algorithm.
// - Maintain a parent[] array.
// - Whenever a shorter path is found,
//   update both distance and parent.
// - Reconstruct the path from destination
//   back to source using parent[].
// - Reverse the path.
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

    public List<Integer> shortestPath(
            int n,
            int m,
            int[][] edges) {

        ArrayList<ArrayList<Pair>> adj =
                new ArrayList<>();

        for (int i = 0; i <= n; i++) {

            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {

            parent[i] = i;
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>(
                (a, b) -> a.distance - b.distance
            );

        dist[1] = 0;

        pq.offer(new Pair(0, 1));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int dis = current.distance;

            if (dis > dist[node]) {
                continue;
            }

            for (Pair edge : adj.get(node)) {

                int neighbour = edge.node;
                int weight = edge.distance;

                if (dis + weight < dist[neighbour]) {

                    dist[neighbour] =
                        dis + weight;

                    parent[neighbour] = node;

                    pq.offer(
                        new Pair(
                            dist[neighbour],
                            neighbour
                        )
                    );
                }
            }
        }

        List<Integer> path =
                new ArrayList<>();

        if (dist[n] == Integer.MAX_VALUE) {

            path.add(-1);

            return path;
        }

        int node = n;

        while (parent[node] != node) {

            path.add(node);

            node = parent[node];
        }

        path.add(1);

        Collections.reverse(path);

        return path;
    }
}
