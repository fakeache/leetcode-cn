package Middle;

import java.util.TreeMap;

public class Solution456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int len = nums.length;
        int numi = nums[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int k = 1; k < len; k++) {
            map.put(nums[k], map.getOrDefault(nums[k], 0) + 1);
        }
        for (int j = 1; j < len - 1; j++) {
            if (map.get(nums[j]) == 1) {
                map.remove(nums[j]);
            } else {
                map.put(nums[j], map.get(nums[j]) - 1);
            }
            Integer ceilingKey = 0;
            if (nums[j] > numi && (ceilingKey = map.ceilingKey(numi + 1)) != null
                    && ceilingKey  < nums[j]) {
                return true;
            }
            numi = Math.min(numi, nums[j]);
        }
        return false;
    }
}
