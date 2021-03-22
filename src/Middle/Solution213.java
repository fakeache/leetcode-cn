package Middle;

class Solution213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int a = robInRange(nums, 1, len - 1);
        int b = robInRange(nums, 0, len - 2);
        return Math.max(a, b);
    }

    public int robInRange(int[] nums, int start, int end) {
        if (end - start == 0) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[end];
    }
}
