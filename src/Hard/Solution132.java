package Hard;

import java.util.Arrays;

public class Solution132 {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < len; i++) {
                if (i < j) {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
            }
        }
        int[] sdp = new int[len + 1];
        sdp[0] = -1;
        for (int i = 1; i <= len; i++) {
            int rs = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (dp[j - 1][i - 1]) {
                    rs = Math.min(rs, sdp[j - 1] + 1);
                }
            }
            sdp[i] = rs;
        }
        return sdp[len];
    }
}
