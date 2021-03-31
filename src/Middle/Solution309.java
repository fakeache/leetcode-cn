package Middle;

class Solution309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int s1 = -prices[0], s2 = 0, s3 = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp1 = Math.max(s1, s3 - prices[i]);
            int tmp2 = s1 + prices[i];
            s3 = Math.max(s2, s3);
            s1 = tmp1;
            s2 = tmp2;
        }
        return Math.max(s2, s3);
    }
}
