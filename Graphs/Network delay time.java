// Leetcode 743 - Network Delay Time
//
// Approach (Bellman-Ford)
//
// - Initialize all distances as INF.
// - Source distance = 0.
// - Relax all edges (n-1) times.
// - Find the maximum shortest distance.
// - If any node is unreachable,
//   return -1.
//
// Time Complexity:
// O(V × E)
//
// Space Complexity:
// O(V)

class Solution {

    public int networkDelayTime(
            int[][] times,
            int n,
            int k) {

        int[] dist = new int[n + 1];

        Arrays.fill(dist, (int)1e8);

        dist[k] = 0;

        // Relax all edges n-1 times
        for (int i = 1; i <= n - 1; i++) {

            for (int[] edge : times) {

                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != (int)1e8 &&
                    dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == (int)1e8) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}
