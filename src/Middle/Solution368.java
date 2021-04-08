package Middle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((nums[i] % nums[j]) == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int idx = 0, size = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] > size) {
                size = dp[i];
                idx = i;
            }
        }
        List<Integer> rs = new LinkedList<>();
        rs.add(nums[idx]);
        --size;
        for (int i = idx - 1; i >= 0 && size > 0; i--) {
            if ((nums[idx] % nums[i]) == 0 && dp[i] == size) {
                rs.add(nums[i]);
                size--;
                idx = i;
            }
        }
        return rs;
    }
}
