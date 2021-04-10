package Middle;

import java.util.Random;

public class Solution384 {
    int[] nums;
    int[] origin;
    int len;

    public Solution384(int[] nums) {
        this.nums = nums;
        this.origin = nums.clone();
        len = nums.length;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        origin = nums.clone();
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        origin = nums.clone();
        int k = len;
        while (k > 0) {
            int idx = random.nextInt(k--);
            swap(origin, idx, k);
        }
        return origin;
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
