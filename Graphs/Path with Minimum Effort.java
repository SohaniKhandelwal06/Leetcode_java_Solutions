// Leetcode 1631 - Path With Minimum Effort

/*
Approach (Modified Dijkstra)

- Maintain an effort[][] array.
- effort[r][c] stores the minimum effort required
  to reach cell (r,c).
- Use a Priority Queue storing:
      (effort, row, col)
- For every neighbour:

      newEffort =
      max(currentEffort,
          abs(height difference))

- If newEffort is smaller than the stored effort,
  update it and push into the priority queue.

Time Complexity:
O(N * M * log(N * M))

Space Complexity:
O(N * M)
*/

class Tuple {

    int effort;
    int row;
    int col;

    Tuple(int effort, int row, int col) {
        this.effort = effort;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] effort = new int[n][m];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Tuple> pq =
            new PriorityQueue<>(
                (a, b) -> a.effort - b.effort
            );

        effort[0][0] = 0;

        pq.offer(new Tuple(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {

            Tuple current = pq.poll();

            int diff = current.effort;
            int row = current.row;
            int col = current.col;

            if (row == n - 1 && col == m - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {

                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow >= 0 &&
                    nrow < n &&
                    ncol >= 0 &&
                    ncol < m) {

                    int newEffort =
                        Math.max(
                            diff,
                            Math.abs(
                                heights[row][col] -
                                heights[nrow][ncol]
                            )
                        );

                    if (newEffort < effort[nrow][ncol]) {

                        effort[nrow][ncol] = newEffort;

                        pq.offer(
                            new Tuple(
                                newEffort,
                                nrow,
                                ncol
                            )
                        );
                    }
                }
            }
        }

        return 0;
    }
}
