// Leetcode 309 - Best Time to Buy and Sell Stock with Cooldown
//
// States:
// buy  = maximum profit while holding a stock
// sell = maximum profit after selling
//
// Cooldown:
// After selling on day i, we cannot buy on day i + 1.
// Therefore, buying today uses the sell value from
// two days ago.
//
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {

    public int maxProfit(int[] prices) {

        int buy = -prices[0];

        int sell = 0;

        int prevSell = 0;

        for (int i = 1; i < prices.length; i++) {

            int oldBuy = buy;
            int oldSell = sell;

            // Buy today or continue holding
            buy = Math.max(
                oldBuy,
                prevSell - prices[i]
            );

            // Sell today or don't sell
            sell = Math.max(
                oldSell,
                oldBuy + prices[i]
            );

            // Store previous day's sell
            prevSell = oldSell;
        }

        return sell;
    }
}
