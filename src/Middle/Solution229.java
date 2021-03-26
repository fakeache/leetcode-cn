package Middle;

import java.util.ArrayList;
import java.util.List;

class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rs = new ArrayList<>();
        int len = nums.length;
        int sl1 = 0;
        int sc1 = 0;
        int sl2 = 0;
        int sc2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == sl1) {
                sc1++;
            } else if(nums[i] == sl2) {
                sc2++;
            } else if (sc1 == 0) {
                sl1 = nums[i];
                sc1++;
            } else if (sc2 == 0) {
                sl2 = nums[i];
                sc2++;
            } else {
                sc1--;
                sc2--;
            }
        }
        sc1 = 0;
        sc2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == sl1) {
                sc1++;
            } else if (nums[i] == sl2) {
                sc2++;
            }
        }
        if (sc1 > len / 3) {
            rs.add(sl1);
        }
        if (sc2 > len / 3) {
            rs.add(sl2);
        }
        return rs;
    }
}
