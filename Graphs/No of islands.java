// Leetcode 200 - Number of Islands

/*
Approach (BFS + Visited Matrix)

- Traverse every cell of the grid.
- If a cell contains land ('1') and has not been visited,
  we have found a new island.
- Increment the island count.
- Start BFS from that cell and visit all connected land cells.
- Each cell can move in four directions:
      Up
      Down
      Left
      Right

- Diagonal cells are not considered connected.

The condition:

    Math.abs(delrow) == Math.abs(delcol)

removes:
    (-1, -1)
    (-1,  1)
    ( 0,  0)
    ( 1, -1)
    ( 1,  1)

and leaves only the four valid directions.

Time Complexity: O(M * N)

Space Complexity: O(M * N)

where:
M = Number of rows
N = Number of columns
*/

class Pair {

    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        int cnt = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1' &&
                    vis[i][j] == 0) {

                    cnt++;

                    bfs(i, j, grid, vis);
                }
            }
        }

        return cnt;
    }

    private void bfs(int row,
                     int col,
                     char[][] grid,
                     int[][] vis) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(row, col));

        vis[row][col] = 1;

        while (!q.isEmpty()) {

            Pair temp = q.poll();

            row = temp.first;
            col = temp.second;

            for (int delrow = -1;
                 delrow <= 1;
                 delrow++) {

                for (int delcol = -1;
                     delcol <= 1;
                     delcol++) {

                    // Ignore diagonal directions
                    // and the current cell
                    if (Math.abs(delrow) ==
                        Math.abs(delcol)) {

                        continue;
                    }

                    int nrow = row + delrow;
                    int ncol = col + delcol;

                    if (nrow >= 0 &&
                        nrow < m &&
                        ncol >= 0 &&
                        ncol < n &&
                        grid[nrow][ncol] == '1' &&
                        vis[nrow][ncol] == 0) {

                        vis[nrow][ncol] = 1;

                        q.offer(
                            new Pair(nrow, ncol)
                        );
                    }
                }
            }
        }
    }
}
