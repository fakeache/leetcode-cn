package Middle;

class Solution279 {
    int min = Integer.MAX_VALUE;
    final int SIZE = 100;
    int[] nums = new int[SIZE];

    public Solution279() {
        for (int i = 0; i < SIZE; i++) {
            nums[i] = (i + 1) * (i + 1);
        }
    }
    public int numSquares(int n) {
        dfs(n, 0);
        return min;
    }

    public void dfs(int n, int depth) {
        if (depth >= min) {
            return;
        }
        for (int i = SIZE - 1; i >= 0; i--) {
            if (nums[i] == n) {
                min = depth + 1;
                return;
            } else if (nums[i] > n) {
                continue;
            } else {
                dfs(n - nums[i], depth + 1);
            }
        }
    }
}
