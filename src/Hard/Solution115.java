package Hard;

public class Solution115 {
    public int numDistinct(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int[][] dp = new int[slen + 1][tlen + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= slen; i++) {
            for (int j = 0; j <= tlen; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] += dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[slen][tlen];
    }

    public static void main(String[] args) {
        new Solution115().numDistinct("r", "r");
    }
}
