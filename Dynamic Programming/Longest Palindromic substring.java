// Longest Palindromic Subsequence
//
// Approach: LCS(s, reverse(s))
//
// Time Complexity: O(N^2)
// Space Complexity: O(N^2) + O(N)

class Solution {

    public int longestPalindromeSubseq(String s) {

        String rev = new StringBuilder(s)
                .reverse()
                .toString();

        int n = s.length();

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, n - 1, s, rev, dp);
    }

    private int solve(int i, int j,
                      String s,
                      String rev,
                      int[][] dp) {

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == rev.charAt(j)) {

            return dp[i][j] =
                    1 + solve(i - 1, j - 1,
                              s, rev, dp);
        }

        return dp[i][j] = Math.max(
                solve(i - 1, j, s, rev, dp),
                solve(i, j - 1, s, rev, dp)
        );
    }
}
// Longest Palindromic Subsequence
//
// Approach: LCS + Tabulation
//
// Time Complexity: O(N^2)
// Space Complexity: O(N^2)

class Solution {

    public int longestPalindromeSubseq(String s) {

        String rev = new StringBuilder(s)
                .reverse()
                .toString();

        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) ==
                    rev.charAt(j - 1)) {

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

        return dp[n][n];
    }
}
// Longest Palindromic Subsequence
//
// Approach: LCS + Space Optimization
//
// Time Complexity: O(N^2)
// Space Complexity: O(N)

class Solution {

    public int longestPalindromeSubseq(String s) {

        String rev = new StringBuilder(s)
                .reverse()
                .toString();

        int n = s.length();

        int[] prev = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            int[] curr = new int[n + 1];

            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) ==
                    rev.charAt(j - 1)) {

                    curr[j] =
                        1 + prev[j - 1];

                } else {

                    curr[j] = Math.max(
                        prev[j],
                        curr[j - 1]
                    );
                }
            }

            prev = curr;
        }

        return prev[n];
    }
}
