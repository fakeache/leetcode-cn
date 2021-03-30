package Middle;

class Solution304 {

    int m;
    int n;
    int[][] dp;

    public Solution304(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[0][0];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rs = 0;
        rs += dp[row2][col2];
        if (row1 > 0) {
            rs -= dp[row1 - 1][col2];
        }
        if (col1 > 0) {
            rs -= dp[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            rs += dp[row1 - 1][col1 - 1];
        }
        return rs;
    }
}

