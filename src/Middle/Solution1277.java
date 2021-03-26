package Middle;

class Solution1277 {
    public int countSquares(int[][] matrix) {
        int l1 = matrix.length, l2 = matrix[0].length;
        int[][] dp = new int[l1][l2];
        int ans = 0;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j],
                            Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
