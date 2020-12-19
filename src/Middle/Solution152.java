package Middle;

class Solution152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] maxdp = new int[len];
        int[] mindp = new int[len];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            maxdp[i] = Math.max(Math.max(maxdp[i - 1] * nums[i], mindp[i - 1] * nums[i]), nums[i]);
            mindp[i] = Math.min(Math.min(maxdp[i - 1] * nums[i], mindp[i - 1] * nums[i]), nums[i]);
        }
        int rs = nums[0];
        for (int i = 1; i < len; i++) {
            rs = Math.max(maxdp[i], rs);
        }
        return rs;
    }
}
