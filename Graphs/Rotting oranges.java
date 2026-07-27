// Leetcode 994 - Rotting Oranges

/*
Approach (Multi-Source BFS)

- Add all initially rotten oranges to the queue.
- Count the number of fresh oranges.
- Perform BFS level by level.
- Each level represents one minute.
- For every rotten orange, rot all adjacent fresh oranges.
- Decrease the fresh orange count whenever an orange becomes rotten.
- If fresh oranges remain after BFS, return -1.

Why Multi-Source BFS?

All initially rotten oranges start spreading
simultaneously at time 0.

Time Complexity: O(M * N)

Space Complexity: O(M * N)

where:
M = Number of rows
N = Number of columns
*/

class Pair {

    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int fresh = 0;

        // Add all rotten oranges
        // and count fresh oranges
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {

                    q.offer(new Pair(i, j));
                }

                else if (grid[i][j] == 1) {

                    fresh++;
                }
            }
        }

        int time = 0;

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();

                int row = curr.row;
                int col = curr.col;

                // Up
                if (row - 1 >= 0 &&
                    grid[row - 1][col] == 1) {

                    grid[row - 1][col] = 2;
                    fresh--;

                    q.offer(
                        new Pair(row - 1, col)
                    );
                }

                // Down
                if (row + 1 < m &&
                    grid[row + 1][col] == 1) {

                    grid[row + 1][col] = 2;
                    fresh--;

                    q.offer(
                        new Pair(row + 1, col)
                    );
                }

                // Left
                if (col - 1 >= 0 &&
                    grid[row][col - 1] == 1) {

                    grid[row][col - 1] = 2;
                    fresh--;

                    q.offer(
                        new Pair(row, col - 1)
                    );
                }

                // Right
                if (col + 1 < n &&
                    grid[row][col + 1] == 1) {

                    grid[row][col + 1] = 2;
                    fresh--;

                    q.offer(
                        new Pair(row, col + 1)
                    );
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
