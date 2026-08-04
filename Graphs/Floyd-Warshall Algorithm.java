// Floyd-Warshall Algorithm
//
// Approach
//
// - Convert -1 to INF.
// - Set diagonal to 0.
// - Try every vertex as an intermediate node.
// - Update shortest distance.
// - Convert INF back to -1.
//
// Time Complexity:
// O(V³)
//
// Space Complexity:
// O(1)
// (Uses given matrix)

class Solution {

    public void shortestDistance(
            int[][] matrix) {

        int n = matrix.length;

        int INF = (int)1e9;

        // Replace -1 with INF
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == -1) {

                    matrix[i][j] = INF;
                }

                if (i == j) {

                    matrix[i][j] = 0;
                }
            }
        }

        // Floyd-Warshall
        for (int via = 0; via < n; via++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (matrix[i][via] != INF &&
                        matrix[via][j] != INF) {

                        matrix[i][j] =
                            Math.min(
                                matrix[i][j],
                                matrix[i][via] +
                                matrix[via][j]
                            );
                    }
                }
            }
        }

        // Convert INF back to -1
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == INF) {

                    matrix[i][j] = -1;
                }
            }
        }
    }
}
