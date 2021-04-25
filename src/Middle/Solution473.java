package Middle;

import java.util.Arrays;

public class Solution473 {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length == 0) {
            return false;
        }
        int sum = 0;
        for (int x : matchsticks) {
            sum += x;
        }
        if (sum % 4 > 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        int[] square = new int[4];
        Arrays.fill(square, sum / 4);
        return dfs(matchsticks, matchsticks.length - 1, square);
    }

    public boolean dfs(int[] matchsticks, int k, int[] square) {
        if (k < 0) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (square[i] < matchsticks[k]) {
                continue;
            }
            square[i] -= matchsticks[k];
            boolean rs = dfs(matchsticks, k - 1, square);
            square[i] += matchsticks[k];
            if (rs) {
                return true;
            }
        }
        return false;
    }
}
