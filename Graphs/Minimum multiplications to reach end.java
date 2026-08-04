// Minimum Multiplications to Reach End
//
// Approach (BFS)
//
// - Every multiplication costs one move.
// - Use BFS because every edge has equal weight.
// - Maintain dist[] where
//      dist[x] = minimum multiplications
//      needed to reach x.
// - Generate next number:
//
//      (current * arr[i]) % 100000
//
// Time Complexity:
// O(100000 × N)
//
// Space Complexity:
// O(100000)

class Pair {

    int node;
    int steps;

    Pair(int node, int steps) {

        this.node = node;
        this.steps = steps;
    }
}

class Solution {

    int minimumMultiplications(
            int[] arr,
            int start,
            int end) {

        int[] dist = new int[100000];

        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q =
            new LinkedList<>();

        q.offer(new Pair(start, 0));

        dist[start] = 0;

        while (!q.isEmpty()) {

            Pair current = q.poll();

            int node = current.node;
            int steps = current.steps;

            if (node == end) {
                return steps;
            }

            for (int num : arr) {

                int next =
                    (node * num) % 100000;

                if (steps + 1 < dist[next]) {

                    dist[next] = steps + 1;

                    q.offer(
                        new Pair(
                            next,
                            steps + 1
                        )
                    );
                }
            }
        }

        return -1;
    }
}
