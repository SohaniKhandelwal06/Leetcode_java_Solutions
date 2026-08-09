// Longest Common Substring
//
// Approach: Dynamic Programming
//
// dp[i][j] = length of the longest common substring
//            ending at str1[i-1] and str2[j-1]
//
// If characters match:
// dp[i][j] = 1 + dp[i-1][j-1]
//
// If characters don't match:
// dp[i][j] = 0
//
// Time Complexity: O(N * M)
// Space Complexity: O(N * M)

class Solution {

    public int longestCommonSubstring(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (str1.charAt(i - 1) ==
                    str2.charAt(j - 1)) {

                    dp[i][j] =
                        1 + dp[i - 1][j - 1];

                    ans = Math.max(ans, dp[i][j]);

                } else {

                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }
}
