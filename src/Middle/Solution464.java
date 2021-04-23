package Middle;

import java.util.HashMap;
import java.util.Map;

public class Solution464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        Boolean[] dp = new Boolean[1 << maxChoosableInteger];
        return dfs(desiredTotal, maxChoosableInteger, 0, dp);
    }

    public boolean dfs(int total, int max, int visited, Boolean[] dp) {
        if (total <= 0) {
            return false;
        }
        if (dp[visited] != null) {
            return dp[visited];
        }
        for (int i = 1; i <= max; i++) {
            int tmp = 1 << (i - 1);
            if ((tmp & visited) != 0) {
                continue;
            }
            boolean son = dfs(total - i, max, visited | tmp, dp);
            if (total - i <= 0 || !son) {
                dp[visited] = true;
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution464().canIWin(10, 40));
    }
}
