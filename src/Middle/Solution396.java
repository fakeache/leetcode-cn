package Middle;

public class Solution396 {
    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int f0 = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            f0 += i * nums[i];
        }
        max = f0;
        int fi = f0;
        for (int i = 1; i < len; i++) {
            fi += sum - len * nums[len - i];
            max = Math.max(max, fi);
        }
        return max;
    }
}
