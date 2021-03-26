package Middle;

import java.util.TreeSet;

class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long g = set.ceiling((long) nums[i]);
            if (g != null && g - nums[i] <= t) {
                return true;
            }
            Long l = set.floor((long) nums[i]);
            if (l != null && nums[i] - l <= t) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
