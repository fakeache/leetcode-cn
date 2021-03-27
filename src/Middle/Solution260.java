package Middle;

import java.util.Arrays;

class Solution260 {
    public int[] singleNumber(int[] nums) {
        int ss = 0, len = nums.length;
        for (int num : nums) {
            ss ^= num;
        }
        int x = 1;
        while (true) {
            if ((x & ss) != 0) {
                break;
            }
            x <<= 1;
        }
        int[] rs = new int[2];
        for (int i = 0; i < len; i++) {
            if ((nums[i] & x) == 0) {
                rs[0] ^= nums[i];
            } else {
                rs[1] ^= nums[i];
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution260().singleNumber(new int[]{1, 1, 0, -2147483648})));
    }
}
