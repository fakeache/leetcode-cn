package Middle;

public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int sm = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] > mid) {
                return true;
            } else if (nums[i] <= sm) {
                sm = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            }
        }
        return false;
    }
}
