package Middle;

/**
 * LCP 19. 秋叶收藏集
 */
class LCP19 {
    public int minimumOperations(String leaves) {
        if (leaves == null || leaves.length() == 0) {
            return 0;
        }
        // dp[i][j] 代表leaves[0...i]处于j状态最少需要的步数，j=0 红；j=1 红黄；j=2 红黄红；
        int len = leaves.length();
        int[][] dp = new int[len][3];
        dp[0][0] = isRed(leaves, 0);
        dp[0][1] = Integer.MAX_VALUE;
        dp[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                if (i < j) {
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + isRed(leaves, i);
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + isYellow(leaves, i);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + isRed(leaves, i);
                }
            }
        }
        return dp[len - 1][2];
    }

    public int isRed(String leaves, int x) {
        return leaves.charAt(x) == 'r' ? 0 : 1;
    }

    public int isYellow(String leaves, int x) {
        return leaves.charAt(x) == 'y' ? 0 : 1;
    }
}
