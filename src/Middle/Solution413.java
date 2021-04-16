package Middle;

public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int sum = 0;
        int len = nums.length;
        int i = 0;
        while (i < len - 2) {
            int j = i;
            while (j < len - 2 && (nums[j] + nums[j + 2] == 2 * nums[j + 1])) {
                j++;
            }
            if (j > i) {
                sum += f(2 + j - i);
            }
            i = j + 1;
        }
        return sum;
    }
    public int f(int n) {
        return (n - 1) * (n - 2) / 2;
    }
}
