package Middle;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int l1 = matrix.length, l2 = matrix[0].length;
        int[] dp = new int[l2 + 1];
        dp[1] = matrix[0][0] == '1' ? 1 : 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int s = 0;
                while (i - s > 0 && j - s > 0) {
                    boolean isOne = true;
                    for (int m = 0; m < s + 1; m++) {
                        if (matrix[i - m - 1][j - s - 1] == '0'
                                || matrix[i - s - 1][j - m - 1] == '0') {
                            isOne = false;
                            break;
                        }
                    }
                    if (!isOne) {
                        break;
                    }
                    s++;
                }
                if (i > 1 && j == 1) {
                    dp[j] = Math.max(dp[j], s);
                }
                if (j > 1 && i == 1) {
                    dp[j] = Math.max(dp[j - 1], s);
                }
                if (i > 1 && j >1) {
                    dp[j] = Math.max(Math.max(dp[j - 1], s), dp[j]);
                }
            }
        }
        return dp[l2] * dp[l2];
    }
}
