// Leetcode 122 - Best Time to Buy and Sell Stock II
//
// Approach: Dynamic Programming
//
// State:
// buy  = maximum profit when holding a stock
// sell = maximum profit when not holding a stock
//
// Transitions:
// buy  = max(oldBuy, oldSell - price)
// sell = max(oldSell, oldBuy + price)
//
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n][2];

        // Day 0
        dp[0][0] = -prices[0]; // Buy
        dp[0][1] = 0;          // Sell / no stock

        for (int i = 1; i < n; i++) {

            // Hold stock
            dp[i][0] = Math.max(
                dp[i - 1][0],
                dp[i - 1][1] - prices[i]
            );

            // Don't hold stock
            dp[i][1] = Math.max(
                dp[i - 1][1],
                dp[i - 1][0] + prices[i]
            );
        }

        return dp[n - 1][1];
    }
}
