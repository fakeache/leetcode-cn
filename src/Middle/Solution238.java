package Middle;

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] output = new int[len];
        for (int i = 0; i < len; i++) {
            left[i] = i == 0 ? 1 : left[i - 1] * nums[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            right[i] = i == len - 1 ? 1 : right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            output[i] = left[i] * right[i];
        }
        return output;
    }
}