package Hard;

import java.util.Arrays;

public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] buy = new int[len][k + 1];
        int[][] sell = new int[len][k + 1];
        Arrays.fill(buy[0], Integer.MIN_VALUE / 2);
        Arrays.fill(sell[0], Integer.MIN_VALUE / 2);
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        for (int i = 0; i <= k; i++) {
            max = Math.max(max, sell[len - 1][i]);
        }
        return max;
    }
}
