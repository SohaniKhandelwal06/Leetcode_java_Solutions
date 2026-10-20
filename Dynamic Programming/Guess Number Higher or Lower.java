//Leetcode 375 - Guess Number Higher or Lower II
//
// Approach: Dynamic Programming + Minimax
//
// dp[left][right] stores the minimum money needed to guarantee a win
// when the target is between left and right.
// Try every number as the guess.
// The cost is the guessed number plus the maximum cost of the two
// possible remaining ranges, since the guess may be wrong.
// Choose the guess that minimizes this worst-case cost.
//
// Time Complexity:
// O(N³)
//
// Space Complexity:
// O(N²)
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];

        for (int len = 2; len <= n; len++) {
            for (int left = 1; left + len - 1 <= n; left++) {
                int right = left + len - 1;
                dp[left][right] = Integer.MAX_VALUE;

                for (int guess = left; guess < right; guess++) {
                    int cost = guess + Math.max(
                        dp[left][guess - 1],
                        dp[guess + 1][right]
                    );

                    dp[left][right] = Math.min(dp[left][right], cost);
                }
            }
        }

        return dp[1][n];
    }
}
