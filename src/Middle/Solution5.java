package Middle;

class Solution5 {
    /**
     * 使用动态规划
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int lk = 0, rk = 0;
        int len = s.length();
        // dp[i][j] 代表 s[i...j]
        // dp[i][j] = (s[i] == s[j]) && (j-i < 3 || dp[i+1][j-1])
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i > rk - lk) {
                    lk = i;
                    rk = j;
                }
            }
        }
        return s.substring(lk, rk + 1);
    }
}