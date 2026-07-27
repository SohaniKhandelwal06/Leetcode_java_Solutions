// Leetcode 547 - Number of Provinces

/*
Approach (DFS + Visited Array)

- Treat every city as a node in a graph.
- isConnected[i][j] == 1 means there is an edge
  between city i and city j.
- Traverse all cities.
- If a city is not visited, it represents a new province.
- Perform DFS to visit all cities belonging to that province.

Number of DFS calls = Number of Provinces

Time Complexity: O(N^2)

Space Complexity: O(N)

where:
N = Number of cities
*/

class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                provinces++;

                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(
            int city,
            int[][] isConnected,
            boolean[] visited) {

        visited[city] = true;

        for (int neighbour = 0;
             neighbour < isConnected.length;
             neighbour++) {

            if (isConnected[city][neighbour] == 1
                    && !visited[neighbour]) {

                dfs(neighbour,
                    isConnected,
                    visited);
            }
        }
    }
}
