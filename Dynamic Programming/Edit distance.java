// Leetcode 72 - Edit Distance
//
// Operations:
// 1. Insert
// 2. Delete
// 3. Replace
//
// Time Complexity: O(N * M)
// Space Complexity: O(N * M)

class Solution {

    public int minDistance(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Convert str1[0...i-1] to empty string
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        // Convert empty string to str2[0...j-1]
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (str1.charAt(i - 1) ==
                    str2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    int delete = dp[i - 1][j];

                    int insert = dp[i][j - 1];

                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(
                        delete,
                        Math.min(insert, replace)
                    );
                }
            }
        }

        return dp[n][m];
    }
}
