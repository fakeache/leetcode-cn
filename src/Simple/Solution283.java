package Simple;

import java.util.Arrays;

public class Solution283 {
    public static void moveZeroes(int[] nums) {
        int y = 0;
        int len = nums.length;
        for (int x = 0; x < len; x++) {
            if (nums[x] != 0) {
                if (y != x) {
                    nums[y] = nums[x];
                    nums[x] = 0;
                }
                y++;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,0,6,0,5,1,2};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
