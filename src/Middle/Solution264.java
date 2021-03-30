package Middle;

import java.util.HashSet;
import java.util.Set;

class Solution264 {
    int[] dp = new int[1690];
    Set<Integer> set = new HashSet<>();
    public Solution264 () {
        dp[0] = 1;
        int x2 = 0, x3 = 0, x5 = 0;
        for (int i = 1; i < 1690; i++) {
            while (set.contains(dp[x2] * 2)) {
                x2++;
            }
            while (set.contains(dp[x3] * 3)) {
                x3++;
            }
            while (set.contains(dp[x5] * 5)) {
                x5++;
            }
            if (dp[x2] * 2 < dp[x3] * 3 && dp[x2] * 2 < dp[x5] * 5) {
                dp[i] = dp[x2++] * 2;
            } else if (dp[x3] * 3 < dp[x5] * 5) {
                dp[i] = dp[x3++] * 3;
            } else {
                dp[i] = dp[x5++] * 5;
            }
            set.add(dp[i]);
        }
    }
    public int nthUglyNumber(int n) {
        return dp[n - 1];
    }
}
