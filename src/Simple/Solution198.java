package Simple;

import java.util.Arrays;

public class Solution198 {
    public static int rob(int[] nums) {
        if (nums==null || nums.length == 0) {
            return 0;
        }
        int a = nums[0];
        if (nums.length == 1) {
            return a;
        }
        if (nums.length == 2) {
            int b = Math.max(nums[0], nums[1]);
            return b;
        }
        int b = Math.max(nums[0], nums[1]);
        int c = 0;
        for (int i = 2; i < nums.length; i++) {
            c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2, 1, 1, 2};
        System.out.println(rob(nums));
        System.out.println(9/10);
    }
}