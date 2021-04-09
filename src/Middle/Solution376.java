package Middle;

public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        int rs = 0;
        boolean hasStart = false;
        boolean positive = false;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                rs++;
                continue;
            }
            if (!hasStart) {
                positive = nums[i] > pre;
                hasStart = true;
                pre = nums[i];
                continue;
            }
            if ((nums[i] > pre && !positive) || (nums[i] < pre && positive)) {
                positive = !positive;
            } else {
                rs++;
            }
            pre = nums[i];
        }
        return nums.length - rs;
    }
}
