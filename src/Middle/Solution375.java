package Middle;

public class Solution375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = j; k < i + j - 1; k++) {
                    min = Math.min(min, k + Math.max(dp[j][k - 1], dp[k + 1][i + j - 1]));
                }
                min = Math.min(min, dp[j][i + j - 2] + i + j - 1);
                dp[j][i + j - 1] = min;
            }
        }
        return dp[1][n];
    }
}
