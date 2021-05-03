package Hard;

import java.util.HashSet;
import java.util.Set;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int rs = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int begin = num;
            while (true) {
                ++num;
                if (!set.contains(num)) {
                    break;
                }
            }
            rs = Math.max(rs, num - begin);
        }
        return rs;
    }
}
