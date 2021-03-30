package Middle;

class Solution287 {
    public int findDuplicate(int[] nums) {
        int len = nums.length, low = 1, high = len - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}