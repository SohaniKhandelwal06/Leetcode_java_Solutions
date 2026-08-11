// Leetcode 714 - Best Time to Buy and Sell Stock with Transaction Fee
//
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {

    public int maxProfit(int[] prices, int fee) {

        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < prices.length; i++) {

            int oldBuy = buy;
            int oldSell = sell;

            // Buy / continue holding
            buy = Math.max(
                oldBuy,
                oldSell - prices[i]
            );

            // Sell / continue without stock
            sell = Math.max(
                oldSell,
                oldBuy + prices[i] - fee
            );
        }

        return sell;
    }
}
