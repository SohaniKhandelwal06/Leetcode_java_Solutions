// Replace O's with X's
//
// Approach: Boundary BFS
//
// - Any 'O' connected to the boundary cannot be surrounded.
// - Start BFS from all boundary 'O's.
// - Mark all reachable 'O's as safe.
// - Finally, replace every unmarked 'O' with 'X'.
//
// Time Complexity: O(M * N)
// Space Complexity: O(M * N)

class Pair {

    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public void fill(char[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] vis = new int[m][n];

        Queue<Pair> q = new LinkedList<>();

        // First and last columns
        for (int i = 0; i < m; i++) {

            if (mat[i][0] == 'O' &&
                vis[i][0] == 0) {

                vis[i][0] = 1;
                q.offer(new Pair(i, 0));
            }

            if (mat[i][n - 1] == 'O' &&
                vis[i][n - 1] == 0) {

                vis[i][n - 1] = 1;
                q.offer(new Pair(i, n - 1));
            }
        }

        // First and last rows
        for (int j = 0; j < n; j++) {

            if (mat[0][j] == 'O' &&
                vis[0][j] == 0) {

                vis[0][j] = 1;
                q.offer(new Pair(0, j));
            }

            if (mat[m - 1][j] == 'O' &&
                vis[m - 1][j] == 0) {

                vis[m - 1][j] = 1;
                q.offer(new Pair(m - 1, j));
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        // BFS from boundary O's
        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int row = curr.row;
            int col = curr.col;

            for (int i = 0; i < 4; i++) {

                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 &&
                    nrow < m &&
                    ncol >= 0 &&
                    ncol < n &&
                    mat[nrow][ncol] == 'O' &&
                    vis[nrow][ncol] == 0) {

                    vis[nrow][ncol] = 1;

                    q.offer(
                        new Pair(nrow, ncol)
                    );
                }
            }
        }

        // Replace surrounded O's
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 'O' &&
                    vis[i][j] == 0) {

                    mat[i][j] = 'X';
                }
            }
        }
    }
}
