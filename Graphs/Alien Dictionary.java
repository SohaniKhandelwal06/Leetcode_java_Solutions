// Alien Dictionary
//
// Approach (Graph + Kahn's Algorithm)
//
// - Compare every adjacent pair of words.
// - Find the first different character.
// - Create a directed edge:
//      word1.charAt(j) -> word2.charAt(j)
// - Compute indegree.
// - Perform Topological Sort using BFS.
// - The resulting order is the alien dictionary.
//
// Time Complexity: O(N * L + K + E)
//
// N = Number of words
// L = Average word length
// K = Number of characters
// E = Number of edges

class Solution {

    public String findOrder(
            String[] dict,
            int N,
            int K) {

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        for (int i = 0; i < K; i++) {

            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < N - 1; i++) {

            String s1 = dict[i];
            String s2 = dict[i + 1];

            int len =
                Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {

                if (s1.charAt(j) != s2.charAt(j)) {

                    adj.get(
                        s1.charAt(j) - 'a'
                    ).add(
                        s2.charAt(j) - 'a'
                    );

                    break;
                }
            }
        }

        // Calculate indegree
        int[] indegree = new int[K];

        for (int i = 0; i < K; i++) {

            for (int neighbour :
                    adj.get(i)) {

                indegree[neighbour]++;
            }
        }

        Queue<Integer> q =
                new LinkedList<>();

        for (int i = 0; i < K; i++) {

            if (indegree[i] == 0) {

                q.offer(i);
            }
        }

        StringBuilder ans =
                new StringBuilder();

        while (!q.isEmpty()) {

            int node = q.poll();

            ans.append(
                (char)(node + 'a')
            );

            for (int neighbour :
                    adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {

                    q.offer(neighbour);
                }
            }
        }

        return ans.toString();
    }
}
