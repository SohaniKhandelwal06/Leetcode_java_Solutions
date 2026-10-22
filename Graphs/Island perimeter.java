//Leetcode 463-Island Perimeter
/*Approach: Counting Boundaries
You are given a 2D grid where 1 represents land and 0 represents water. The island is surrounded by water, and there is exactly one island.

Return the perimeter of the island.

Key idea: Every land cell contributes 4 sides initially. If two land cells share a side, that shared boundary must not be counted twice.

Steps:
1. Traverse every cell in the grid.
2. If the cell is water (0), skip it.
3. If the cell is land (1), add 4 to the perimeter.
4. If the cell has land above it, subtract 2.
5. If the cell has land to its left, subtract 2.
6. Return the total perimeter.
We check only the top and left neighbors to avoid counting shared edges twice.
  */

class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 0) {
                    continue;
                }

                // Every land cell contributes 4 sides
                perimeter += 4;

                // Shared edge with the land cell above
                if (i > 0 && grid[i - 1][j] == 1) {
                    perimeter -= 2;
                }

                // Shared edge with the land cell on the left
                if (j > 0 && grid[i][j - 1] == 1) {
                    perimeter -= 2;
                }
            }
        }

        return perimeter;
    }
}
