package Hard;

public class Solution123 {
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(-prices[i], buy1);
            sell1 = Math.max(prices[i] + buy1, sell1);
            buy2 = Math.max(sell1 - prices[i], buy2);
            sell2 = Math.max(buy2 + prices[i], sell2);
        }
        return sell2;
    }
}
