package Middle;

import java.util.ArrayList;
import java.util.List;

public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> rs = new ArrayList<>(k);
        int len1 = nums1.length, len2 = nums2.length;
        int[] idx = new int[len1];
        for (int i = 0; i < k; i++) {
            int index1 = 0, min = Integer.MAX_VALUE;
            for (int j = 0; j < len1; j++) {
                if (idx[j] >= len2) {
                    continue;
                }
                int sum = nums1[j] + nums2[idx[j]];
                if (sum < min) {
                    min = sum;
                    index1 = j;
                }
            }
            if (min == Integer.MAX_VALUE) {
                break;
            }
            List<Integer> ele = new ArrayList<>(2);
            ele.add(nums1[index1]);
            ele.add(nums2[idx[index1]]);
            rs.add(ele);
            idx[index1]++;
        }
        return rs;
    }
}
