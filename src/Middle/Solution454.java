package Middle;

import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int L = nums1.length;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                int x1 = nums1[i] + nums2[j];
                map.put(x1, map.getOrDefault(x1, 0) + 1);
            }
        }
        int count = 0;
        for (int x : nums3) {
            for (int y : nums4) {
                if (map.containsKey(-x - y)) {
                    count += map.get(-x - y);
                }
            }
        }
        return count;
    }
}
