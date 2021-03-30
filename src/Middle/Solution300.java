package Middle;

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int idx = 1;
        int[] tail = new int[len + 1];
        tail[idx] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[idx]) {
                tail[++idx] = nums[i];
            } else {
                int low = 1, high = idx;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if (tail[mid] < nums[i]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                tail[low] = nums[i];
            }
        }
        return idx;
    }

    public int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int rs = 0;
        for (int i = 0; i < len; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                }
                max = Math.max(max, dp[j] + 1);
            }
            dp[i] = max;
            rs = Math.max(dp[i], rs);
        }
        return rs;
    }
}
