package Middle;

class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        boolean[] canj = new boolean[len];
        canj[0] = true;
        for (int i = 0; i < len; i++) {
            if (!canj[i]) {
                continue;
            }
            int value = nums[i];
            for (int j = i + 1; j <= i + value; j++) {
                if (j >= len) {
                    break;
                }
                canj[j] = true;
            }
        }
        return canj[len - 1];
    }
}