//  Leetcode 787 - Cheapest Flights Within K Stops
//
// Approach (Bellman-Ford)
//
// - Initialize distances as INF.
// - Source distance = 0.
// - Relax all flights exactly (k + 1) times.
// - Use a temporary array in each iteration.
// - Return the minimum cost to reach destination.
//
// Time Complexity:
// O((k + 1) × E)
//
// Space Complexity:
// O(V)

class Solution {

    public int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for (int i = 0; i <= k; i++) {

            int[] temp = dist.clone();

            for (int[] flight : flights) {

                int u = flight[0];
                int v = flight[1];
                int cost = flight[2];

                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + cost < temp[v]) {

                    temp[v] = dist[u] + cost;
                }
            }

            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE
                ? -1
                : dist[dst];
    }
}
