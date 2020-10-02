package Middle;

import java.util.Arrays;

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int rs = 0;
        int desc = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int d = Math.abs(sum - target);
                if (sum == target) {
                    return target;
                } else {
                    if (d < desc) {
                        desc = d;
                        rs = sum;
                    }
                    if (sum < target) {
                        j++;
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                    } else {
                        k--;
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                }
            }
        }
        return rs;
    }
}