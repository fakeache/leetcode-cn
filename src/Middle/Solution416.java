package Middle;

class Solution416 {
    public boolean canPartition(int[] nums) {
        int nlen = nums.length;
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = num > max ? num : max;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        if (max > target) {
            return false;
        }
        // dp[i][j] 代表数组序号[0,...,i] 是否存在选取元素使得和为j
        boolean[][] dp = new boolean[nlen][target + 1];
        for (int i = 0; i < nlen; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = j == nums[0];
                    continue;
                }
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nlen - 1][target];
    }

    public static void main(String[] args) {
        Solution416 solution = new Solution416();
        System.out.println(solution.canPartition(new int[]{3, 3, 3, 4, 5}));
    }
}