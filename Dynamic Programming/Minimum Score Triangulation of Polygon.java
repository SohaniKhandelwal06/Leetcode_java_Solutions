
//LeetCode 1039 — Minimum Score Triangulation of Polygon
/*Approach: Interval Dynamic Programming
We are given a convex polygon with vertex values. Each triangle formed by triangulation contributes a score equal to the product of its three vertex values.

Our goal is to minimize the total score.

Define:

dp[i][j] = minimum triangulation score for the polygon section from vertex i to vertex j.

For every possible middle vertex k between i and j, we can form a triangle (i, k, j).

The transition is:
\[
dp[i][j] = \min_{i<k<j}
\left(dp[i][k]+dp[k][j]+values[i]\cdot values[k]\cdot values[j]\right)
\]

Base case: If fewer than three vertices are present, no triangle can be formed, so the score is 0.
  */
class Solution {
    public int minScoreTriangulation(int[] values) {

        int n = values.length;
        int[][] dp = new int[n][n];

        // len represents the distance between endpoints
        for (int len = 2; len < n; len++) {

            for (int i = 0; i + len < n; i++) {

                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                // Try every possible middle vertex
                for (int k = i + 1; k < j; k++) {

                    int score = dp[i][k]
                              + dp[k][j]
                              + values[i] * values[k] * values[j];

                    dp[i][j] = Math.min(dp[i][j], score);
                }
            }
        }

        return dp[0][n - 1];
    }
}
