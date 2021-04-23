package Simple;

import java.util.LinkedList;
import java.util.List;

public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> rs = new LinkedList<>();
        int pre = 0, back = 0, len = nums.length;
        while (pre < len) {
            while (pre < len - 1 && nums[pre] + 1 == nums[pre + 1]) {
                pre++;
            }
            if (back == pre) {
                rs.add(String.valueOf(nums[back]));
            } else {
                rs.add(nums[back] + "->" + nums[pre]);
            }
            pre++;
            back = pre;
        }
        return rs;
    }
}
