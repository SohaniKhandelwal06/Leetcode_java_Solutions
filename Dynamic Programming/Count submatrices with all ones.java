//Leetcode 1277 - Count Square Submatrices with All Ones

//
// Approach: Dynamic Programming
//
// dp[i][j] represents the size of the largest all-ones square
// ending at cell (i, j).
// If the current cell is 1, its square size is determined by the
// minimum of the top, left, and top-left neighboring squares plus 1.
// Add each dp[i][j] to the answer because a square of size k
// contains k valid squares ending at that cell.
//
// Time Complexity:
// O(M × N)
//
// Space Complexity:
// O(M × N)
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(
                                dp[i - 1][j],
                                Math.min(dp[i][j - 1], dp[i - 1][j - 1])
                        );
                    }

                    count += dp[i][j];
                }
            }
        }

        return count;
    }
}
