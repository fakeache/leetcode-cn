package Middle;

public class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                dp[j] = Math.max(dp[j], Math.max(dp[i], i) * (j - i));
            }
        }
        return dp[n];
    }
}
