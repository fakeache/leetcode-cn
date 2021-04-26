package Hard;

public class Solution42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1, sum = 0;
        while (left < right) {
            int l = height[left], r = height[right];
            while (left < right && height[left] <= height[right]) {
                left++;
                if (height[left] <= l) {
                    sum += l - height[left];
                } else {
                    break;
                }
            }
            while (left < right && height[left] > height[right]) {
                right--;
                if (height[right] <= r) {
                    sum += r - height[right];
                } else {
                    break;
                }
            }
        }
        return sum;
    }
}
