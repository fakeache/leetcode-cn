package Hard;

import java.util.Arrays;

public class Solution214 {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] sarr = s.toCharArray();
        int len = sarr.length;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = dp[i + 1][j - 1] && sarr[i] == sarr[j];
            }
        }
        int k = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if (dp[0][i]) {
                break;
            } else {
                sb.append(sarr[i]);
            }
        }
        sb.append(s);
        return s.toString();
    }

    public String shortestPalindrome1(String s) {
        int base = 131, mod = 1000000007;
        int left = 0, right = 0, mul = 1;
        char[] sarr = s.toCharArray();
        int best = -1;
        for (int i = 0; i < sarr.length; i++) {
            left = (int) (((long)left * base + sarr[i]) % mod);
            right = (int) ((right + (long) sarr[i] * mul) % mod);
            if (left == right) {
                best = i;
            }
            mul = (int)((long) mul * base % mod);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = sarr.length - 1; i > best; i--) {
            sb.append(sarr[i]);
        }
        sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution214().shortestPalindrome("aacecaaa");
    }
}
