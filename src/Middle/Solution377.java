package Middle;

public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int j = 0; j < nums.length; j++) {
                int next = i + nums[j];
                if (next > target) {
                    continue;
                }
                dp[next] += dp[i];
            }
        }
        return dp[target];
    }
}
