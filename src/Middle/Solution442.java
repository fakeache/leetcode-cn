package Middle;

import java.util.LinkedList;
import java.util.List;

public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> rs = new LinkedList<>();
        int n = nums.length;
        for (int x : nums) {
            int absx = Math.abs(x);
            if (nums[absx - 1] < 0) {
                rs.add(absx);
            }
            nums[absx - 1] = -nums[absx - 1];
        }
        return rs;
    }
}
