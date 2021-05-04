package Hard;

public class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int pre = 0;
                if (i == m - 1 && j == n - 1) {
                    pre = 1;
                } else if (i == m - 1) {
                    pre = dp[i][j + 1];
                } else if (j == n - 1) {
                    pre = dp[i + 1][j];
                } else {
                    pre = Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
                dp[i][j] = Math.max(pre - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
