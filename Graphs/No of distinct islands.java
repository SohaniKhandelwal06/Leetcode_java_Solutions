// Number of Distinct Islands
//
// Approach: BFS + Relative Coordinates
//
// - Traverse every unvisited land cell.
// - Start BFS for every new island.
// - Store each cell relative to the starting cell.
// - Insert the island shape into a HashSet.
// - The size of the HashSet gives the number of distinct islands.
//
// Time Complexity: O(M * N)
//
// Space Complexity: O(M * N)

class Pair {

    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    int countDistinctIslands(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        HashSet<ArrayList<String>> set =
            new HashSet<>();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 &&
                    vis[i][j] == 0) {

                    ArrayList<String> shape =
                        new ArrayList<>();

                    bfs(
                        i,
                        j,
                        grid,
                        vis,
                        shape,
                        dr,
                        dc
                    );

                    set.add(shape);
                }
            }
        }

        return set.size();
    }

    private void bfs(
            int row,
            int col,
            int[][] grid,
            int[][] vis,
            ArrayList<String> shape,
            int[] dr,
            int[] dc) {

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(row, col));

        vis[row][col] = 1;

        // Starting cell is the reference point
        shape.add("0,0");

        int m = grid.length;
        int n = grid[0].length;

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int r = curr.first;
            int c = curr.second;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 &&
                    nr < m &&
                    nc >= 0 &&
                    nc < n &&
                    grid[nr][nc] == 1 &&
                    vis[nr][nc] == 0) {

                    vis[nr][nc] = 1;

                    q.offer(new Pair(nr, nc));

                    // Store relative position
                    int relativeRow = nr - row;
                    int relativeCol = nc - col;

                    shape.add(
                        relativeRow + "," +
                        relativeCol
                    );
                }
            }
        }
    }
}
