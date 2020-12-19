package Middle;

class Solution153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (nums[len - 1] > nums[0]) {
            return nums[0];
        }
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
