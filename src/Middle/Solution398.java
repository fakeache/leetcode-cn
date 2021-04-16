package Middle;

import java.util.Random;

public class Solution398 {
    int[] nums;
    public Solution398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int idx = -1;
        int n = 0;
        Random rand= new Random();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (rand.nextInt(++n) == 0) {
                    idx = i;
                }
            }
        }
        return idx;
    }
}
