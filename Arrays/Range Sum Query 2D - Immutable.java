// LeetCode 304 — Range Sum Query 2D - Immutable
/*Approach
You are given a 2D matrix and need to answer multiple queries asking for the sum of elements inside a rectangular region.

Calculating each sum by traversing every cell would take \(O(mn)\) time per query. Instead, use a 2D prefix sum matrix to answer each query in \(O(1)\) time.
How it works
Create a prefix sum matrix prefix where prefix[i][j] stores the sum of all elements in the rectangle from the top-left corner through cell (i - 1, j - 1) of the original matrix.

Use an extra row and column of zeros to simplify boundary handling.
  */

class NumMatrix {
    private final int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        prefix = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefix[i][j] =
                    matrix[i - 1][j - 1]
                    + prefix[i - 1][j]
                    + prefix[i][j - 1]
                    - prefix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(
        int row1, int col1, int row2, int col2
    ) {
        return prefix[row2 + 1][col2 + 1]
             - prefix[row1][col2 + 1]
             - prefix[row2 + 1][col1]
             + prefix[row1][col1];
    }
}
