//LeetCode 1219 - Path with Maximum Gold

/*Approach: Backtracking + DFS

Use Depth-First Search (DFS) with backtracking to explore every possible path.

Start DFS from every cell containing gold.

Add the current cell's gold to the total.

Mark the current cell as visited by setting its value to 0.

Explore all four directions: up, down, left, and right.

Update the maximum gold collected.

Restore the original cell value before returning.

Since we cannot visit the same cell more than once in a path, temporarily changing its value to 0 prevents revisiting it.
Complexity Analysis

Let m be the number of rows and n be the number of columns.

Time Complexity: O(m × n × 4^L), where L is the maximum number of cells in a path. Each non-zero cell can be a starting point, and DFS explores possible directions.

Space Complexity: O(L), due to the recursive DFS call stack.

*/

class Solution {

    int maxGold = 0;

    public int getMaximumGold(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] != 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }

        return maxGold;
    }

    private void dfs(int[][] grid, int row, int col, int gold) {

        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length ||
            grid[row][col] == 0) {
            return;
        }

        int currentGold = grid[row][col];

        gold += currentGold;
        maxGold = Math.max(maxGold, gold);

        grid[row][col] = 0;

        dfs(grid, row + 1, col, gold);
        dfs(grid, row - 1, col, gold);
        dfs(grid, row, col + 1, gold);
        dfs(grid, row, col - 1, gold);

        grid[row][col] = currentGold;
    }
}
