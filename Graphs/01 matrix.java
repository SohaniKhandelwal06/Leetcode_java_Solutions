// Leetcode 542 - 01 Matrix

/*
Approach (Multi-Source BFS)

- We need to find the distance of every cell from
  its nearest 0.
- Add all cells containing 0 to the queue initially.
- Their distance is 0.
- Then perform BFS simultaneously from all 0s.
- Whenever an unvisited neighbour is found:
      distance[neighbour] = distance[current] + 1

Why Multi-Source BFS?

All 0s are sources at distance 0.
BFS expands from all of them simultaneously.
Therefore, the first time we reach a 1,
we have found its shortest distance to a 0.

Directions:
    Up
    Down
    Left
    Right

Time Complexity: O(M * N)

Space Complexity: O(M * N)

where:
M = Number of rows
N = Number of columns
*/

class Pair {

    int row;
    int col;
    int distance;

    Pair(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

class Solution {

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Queue<Pair> q = new LinkedList<>();

        int[][] vis = new int[m][n];

        int[][] ans = new int[m][n];

        // Add all 0s as sources
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {

                    q.offer(new Pair(i, j, 0));

                    vis[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {

            Pair current = q.poll();

            int row = current.row;
            int col = current.col;
            int distance = current.distance;

            ans[row][col] = distance;

            // Four directions
            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {

                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 &&
                    nrow < m &&
                    ncol >= 0 &&
                    ncol < n &&
                    vis[nrow][ncol] == 0) {

                    vis[nrow][ncol] = 1;

                    q.offer(
                        new Pair(
                            nrow,
                            ncol,
                            distance + 1
                        )
                    );
                }
            }
        }

        return ans;
    }
}
