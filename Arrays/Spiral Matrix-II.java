// Spiral Matrix - Fill 1 to n^2
//
// Example for n = 3:
//
// 1 2 3
// 8 9 4
// 7 6 5
//
// Time Complexity: O(N^2)
// Space Complexity: O(N^2)

class Solution {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int num = 1;

        while (top <= bottom && left <= right) {

            // Left -> Right
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }

            top++;

            // Top -> Bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }

            right--;

            // Right -> Left
            if (top <= bottom) {

                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = num++;
                }

                bottom--;
            }

            // Bottom -> Top
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }

                left++;
            }
        }

        return matrix;
    }
}
