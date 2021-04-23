package Hard;

public class Solution10 {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                char pele = p.charAt(j - 1);
                if (i == 0) {
                    if (pele != '*' || j < 2) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                    continue;
                }
                char sele = s.charAt(i - 1);
                if (pele != '*') {
                    dp[i][j] = match(sele, pele) ? dp[i - 1][j - 1] : false;
                } else {
                    char prepele = p.charAt(j - 2);
                    dp[i][j] = match(sele, prepele) ? dp[i][j - 2] ||
                            dp[i - 1][j] : dp[i][j - 2];
                }
            }
        }
        return dp[slen][plen];
    }

    public boolean match(char sele, char pele) {
        return pele == '.' || sele == pele;
    }

    public static void main(String[] args) {
        System.out.println(new Solution10().isMatch("mississippi", "mis*is*ip*."));
    }
}
