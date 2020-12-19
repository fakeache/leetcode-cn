package Middle;

class Solution162 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == len - 1 || nums[mid + 1] < nums[mid])) {
                return mid;
            }
            if (mid != 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
