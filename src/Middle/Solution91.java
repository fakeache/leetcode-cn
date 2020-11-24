package Middle;

class Solution91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = s.charAt(0) - '0' == 0 ? 0 : 1;
        for (int i = 1; i < len; i++) {
            int m = s.charAt(i) - '0';
            int n = (s.charAt(i - 1) - '0') * 10 + m;
            if (m != 0) {
                dp[i] += dp[i - 1];
            }
            if (n >= 10 && n <= 26) {
                if (i == 1) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2];
                }
            } else if (n == 0) {
                dp[i] = 0;
            }
        }
        return dp[len - 1];
    }
}
