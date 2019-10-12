package Simple;

public class Solution303 {

    int[] sums;

    public Solution303(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        sums = new int[len];
        sums[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (j > sums.length) {
            return 0;
        }
        int f = (i == 0) ? 0 : sums[i - 1];
        return sums[j] - f;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */