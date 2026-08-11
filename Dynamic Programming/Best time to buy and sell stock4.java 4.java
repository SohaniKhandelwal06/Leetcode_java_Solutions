// Leetcode 188 - Best Time to Buy and Sell Stock IV
//
// At most k transactions are allowed.
//
// States:
// 0 -> first buy
// 1 -> first sell
// 2 -> second buy
// 3 -> second sell
// ...
//
// Time Complexity: O(N * K)
// Space Complexity: O(K)

class Solution {

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        if (n == 0 || k == 0) {
            return 0;
        }

        // If k is large, it becomes Stock II
        if (k >= n / 2) {

            int profit = 0;

            for (int i = 1; i < n; i++) {

                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }

            return profit;
        }

        int[] dp = new int[2 * k];

        // Buy states
        for (int i = 0; i < 2 * k; i += 2) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int price : prices) {

            // First transaction
            dp[0] = Math.max(
                dp[0],
                -price
            );

            dp[1] = Math.max(
                dp[1],
                dp[0] + price
            );

            // Remaining transactions
            for (int state = 2; state < 2 * k; state++) {

                if (state % 2 == 0) {

                    // Buy
                    dp[state] = Math.max(
                        dp[state],
                        dp[state - 1] - price
                    );

                } else {

                    // Sell
                    dp[state] = Math.max(
                        dp[state],
                        dp[state - 1] + price
                    );
                }
            }
        }

        return dp[2 * k - 1];
    }
}
