// Rat in a Maze

/*
Approach (Recursion + Backtracking):
1. Start from the top-left cell (0,0).
2. If the current cell is the destination, store the path.
3. Mark the current cell as visited.
4. Explore all four possible directions (Down, Left, Right, Up) if the next cell:
   - Lies within the grid.
   - Is not visited.
   - Contains the value 1.
5. Append the corresponding direction to the current path during recursion.
6. After exploring all possible paths, unmark the current cell to allow it to be used in other valid paths (backtracking).
7. Return all possible paths in lexicographical order.

Time Complexity: O(4^(N²)) (Worst Case)
Space Complexity: O(N²)
*/

class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.length;

        if (mat[0][0] == 0) {
            return ans;
        }

        boolean[][] vis = new boolean[n][n];

        solve(0, 0, mat, n, vis, ans, "");

        return ans;
    }

    private void solve(int row, int col, int[][] mat, int n,
                       boolean[][] vis, ArrayList<String> ans, String path) {

        if (row == n - 1 && col == n - 1) {
            ans.add(path);
            return;
        }

        vis[row][col] = true;

        // Down
        if (row + 1 < n && !vis[row + 1][col] && mat[row + 1][col] == 1) {
            solve(row + 1, col, mat, n, vis, ans, path + "D");
        }

        // Left
        if (col - 1 >= 0 && !vis[row][col - 1] && mat[row][col - 1] == 1) {
            solve(row, col - 1, mat, n, vis, ans, path + "L");
        }

        // Right
        if (col + 1 < n && !vis[row][col + 1] && mat[row][col + 1] == 1) {
            solve(row, col + 1, mat, n, vis, ans, path + "R");
        }

        // Up
        if (row - 1 >= 0 && !vis[row - 1][col] && mat[row - 1][col] == 1) {
            solve(row - 1, col, mat, n, vis, ans, path + "U");
        }

        vis[row][col] = false;
    }
}
