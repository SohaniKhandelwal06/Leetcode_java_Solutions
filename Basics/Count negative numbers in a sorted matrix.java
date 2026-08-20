// Leetcode 1351 - Count Negative Numbers in a Sorted Matrix
//
// Matrix is sorted in non-increasing order
// in both rows and columns.
//
// Approach: Two Pointers
//
// Start from the bottom-left corner.
//
// If grid[row][col] < 0:
//     All elements to the right are negative.
//     Add (n - col) and move up.
//
// Else:
//     Move right.
//
// Time Complexity: O(M + N)
// Space Complexity: O(1)

class Solution {

    public int countNegatives(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int row = m - 1;
        int col = 0;

        int count = 0;

        while (row >= 0 && col < n) {

            if (grid[row][col] < 0) {

                // All elements to the right are negative
                count += n - col;

                row--;

            } else {

                col++;
            }
        }

        return count;
    }
}
