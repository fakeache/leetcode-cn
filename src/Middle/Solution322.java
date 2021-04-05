package Middle;

class Solution322 {
    public int coinChange(int[] coins, int amount) {
        return dfs(amount, coins, new int[amount + 1]);
    }

    public int dfs(int amount, int[] coins, int[] mem) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (mem[amount] != 0) {
            return mem[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int child = dfs(amount - coins[i], coins, mem);
            if (child < 0) {
                continue;
            }
            min = Math.min(min, child + 1);
        }
        mem[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return mem[amount];
    }
}