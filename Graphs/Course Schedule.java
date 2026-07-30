// Leetcode 207 - Course Schedule

/*
Approach (Kahn's Algorithm)

- Build the graph.
- Calculate indegree of every course.
- Add all courses having indegree 0 into the queue.
- Perform BFS.
- Count the number of processed courses.

If processed courses == numCourses
    → No cycle
    → All courses can be completed.

Otherwise
    → Cycle exists
    → Cannot complete all courses.

Time Complexity: O(V + E)

Space Complexity: O(V + E)
*/

class Solution {

    public boolean canFinish(
            int numCourses,
            int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {

            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] edge : prerequisites) {

            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);

            indegree[course]++;
        }

        Queue<Integer> q =
                new LinkedList<>();

        // Add all courses having indegree 0
        for (int i = 0; i < numCourses; i++) {

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

        return count == numCourses;
    }
}
