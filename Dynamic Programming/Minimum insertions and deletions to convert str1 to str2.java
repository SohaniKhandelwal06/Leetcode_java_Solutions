// Minimum Insertions and Deletions to Convert str1 to str2
//
// Only two operations are allowed:
// 1. Delete a character
// 2. Insert a character
//
// Key Idea:
// Keep the LCS unchanged.
// Delete the remaining characters from str1.
// Insert the remaining characters of str2.
//
// Deletions  = n - LCS
// Insertions = m - LCS
//
// Total = n + m - 2 * LCS
//
// Time Complexity: O(N * M)
// Space Complexity: O(N * M)

class Solution {

    public int minOperations(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (str1.charAt(i - 1) ==
                    str2.charAt(j - 1)) {

                    dp[i][j] =
                        1 + dp[i - 1][j - 1];

                } else {

                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        int lcs = dp[n][m];

        int deletions = n - lcs;
        int insertions = m - lcs;

        return deletions + insertions;
    }
}
