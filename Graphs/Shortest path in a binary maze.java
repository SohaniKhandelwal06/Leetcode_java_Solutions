// Shortest Path in Binary Maze
//
// Approach (BFS)
//
// - Every move has equal weight (1),
//   so BFS gives the shortest path.
// - Maintain a distance matrix.
// - Start from the source.
// - Visit all valid neighbouring cells.
// - Update distance whenever a shorter path is found.
//
// Time Complexity: O(N × M)
//
// Space Complexity: O(N × M)

class Tuple {

    int distance;
    int row;
    int col;

    Tuple(int distance,
          int row,
          int col) {

        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    int shortestPath(
            int[][] grid,
            int[] source,
            int[] destination) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int[] row : dist) {

            Arrays.fill(row,
                        Integer.MAX_VALUE);
        }

        Queue<Tuple> q =
            new LinkedList<>();

        dist[source[0]][source[1]] = 0;

        q.offer(
            new Tuple(
                0,
                source[0],
                source[1]
            )
        );

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Tuple current = q.poll();

            int dis = current.distance;
            int row = current.row;
            int col = current.col;

            if (row == destination[0] &&
                col == destination[1]) {

                return dis;
            }

            for (int i = 0; i < 4; i++) {

                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow >= 0 &&
                    nrow < n &&
                    ncol >= 0 &&
                    ncol < m &&
                    grid[nrow][ncol] == 1 &&
                    dis + 1 < dist[nrow][ncol]) {

                    dist[nrow][ncol] =
                        dis + 1;

                    q.offer(
                        new Tuple(
                            dis + 1,
                            nrow,
                            ncol
                        )
                    );
                }
            }
        }

        return -1;
    }
}
