package Hard;

public class Solution44 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();
        int slen = sarr.length;
        int plen = parr.length;
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                if (i == 0) {
                    dp[i][j] = parr[j - 1] == '*' ? dp[i][j - 1] : false;
                } else {
                    if (parr[j - 1] == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (parr[j - 1] == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] && sarr[i - 1] == parr[j - 1];
                    }
                }
            }
        }
        return dp[slen][plen];
    }
}
